package com.faishalbadri.hijab.ui.news.fragment.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.daimajia.slider.library.SliderTypes.BaseSliderView.ScaleType;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews.NewsBean;
import com.faishalbadri.hijab.di.NewsRepositoryInject;
import com.faishalbadri.hijab.ui.news.fragment.news.NewsContract.newsView;
import com.faishalbadri.hijab.util.Singleton.LoadingStatus;
import com.faishalbadri.hijab.util.server.Server;
import com.faishalbadri.hijab.util.widget.slider.ChildAnimationExample;
import com.faishalbadri.hijab.util.widget.slider.SliderLayout;
import com.faishalbadri.hijab.util.widget.slider.SliderLayout.PresetIndicators;
import com.faishalbadri.hijab.util.widget.slider.SliderLayout.Transformer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements newsView {

  @BindView(R.id.recyclerview_fragment_news)
  RecyclerView recyclerviewFragmentNews;
  NewsPresenter newsPresenter;
  ArrayList<NewsBean> list_data;
  NewsAdapter newsAdapter;
  @BindView(R.id.slider_fragment_news)
  SliderLayout sliderFragmentNews;
  TextSliderView textSliderView;
  @BindView(R.id.refresh_fragment_news)
  SwipeRefreshLayout refreshFragmentNews;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  private int PAGE = 2;

  public NewsFragment() {
    // Required empty public constructor
  }

  public static NewsFragment instance() {
    return new NewsFragment();
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_news, container, false);
    ButterKnife.bind(this, view);
    PAGE++;
    setView();
    newsPresenter.onAttachView(this);
    newsPresenter.getDataNews(2);
    newsPresenter.getDataSlider();

    refreshFragmentNews.setOnRefreshListener(() -> {
      refreshFragmentNews.setRefreshing(false);
      PAGE = 1;
      PAGE++;
      this.list_data.clear();
      newsPresenter.getDataNews(2);
      newsPresenter.getDataSlider();
    });
    return view;
  }

  private void setView() {
    newsPresenter = new NewsPresenter(NewsRepositoryInject.provideToNewsRepository(getActivity()));
    list_data = new ArrayList<>();
    newsAdapter = new NewsAdapter(getActivity(), list_data, NewsFragment.this);
    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerviewFragmentNews.setLayoutManager(llm);
    recyclerviewFragmentNews.setAdapter(newsAdapter);
    refreshFragmentNews.setColorSchemeResources(
        android.R.color.holo_blue_bright,
        android.R.color.holo_green_light,
        android.R.color.holo_orange_light,
        android.R.color.holo_red_light);
  }

  @Override
  public void onSuccesNews(List<NewsBean> data, String msg) {
    list_data.addAll(data);
    LoadingStatus.getInstance().setStatus(null);
    newsAdapter.notifyDataSetChanged();
    refreshFragmentNews.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onErrorNews(String msg) {
    if (msg.equals("Data Null")) {
      LoadingStatus.getInstance().setStatus("error");
      newsAdapter.notifyDataSetChanged();
    } else {
      refreshFragmentNews.setVisibility(View.GONE);
      layoutNoInternetAcces.setVisibility(View.VISIBLE);
    }
  }

  @Override
  public void onSuccesSlider(List<NewsBean> dataSlider, String msg) {
    for (int a = 0; a < dataSlider.size(); a++) {
      HashMap<String, String> file_maps = new HashMap<String, String>();
      file_maps.put(dataSlider.get(a).getNews_title(),
          Server.BASE_ASSETS + dataSlider.get(a).getNews_images());

      for (final String name : file_maps.keySet()) {
        textSliderView = new TextSliderView(getActivity());

        String image = file_maps.get(name);

        textSliderView
            .description(name)
            .image(image)
            .setScaleType(ScaleType.CenterCrop)
            .setOnSliderClickListener(slider -> {
              Toast.makeText(getActivity(), slider.getBundle().get("extra") + "",
                  Toast.LENGTH_SHORT).show();
            });

        textSliderView.bundle(new Bundle());
        textSliderView.getBundle().putString("extra", name);

        sliderFragmentNews.addSlider(textSliderView);
      }
      sliderFragmentNews.setPresetTransformer(Transformer.Default);
      sliderFragmentNews.setPresetIndicator(PresetIndicators.Center_Bottom);
      sliderFragmentNews.setCustomAnimation(new ChildAnimationExample());
      sliderFragmentNews.setDuration(2000);
      sliderFragmentNews.addOnPageChangeListener(getActivity());
    }
    refreshFragmentNews.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onErrorSlider(String msg) {
    refreshFragmentNews.setVisibility(View.GONE);
    layoutNoInternetAcces.setVisibility(View.VISIBLE);
  }


  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    newsPresenter.getDataNews(PAGE);
    newsPresenter.getDataSlider();
  }

  public void getData() {
    newsPresenter.getDataNews(PAGE++);
  }
}
