package com.faishalbadri.hijab.aaa_migration_server.ui.news.fragment.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.BaseSliderView.OnSliderClickListener;
import com.daimajia.slider.library.SliderTypes.BaseSliderView.ScaleType;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoNews.NewsBean;
import com.faishalbadri.hijab.aaa_migration_server.di.NewsRepositoryInject;
import com.faishalbadri.hijab.aaa_migration_server.ui.news.fragment.news.NewsContract.newsView;
import com.faishalbadri.hijab.aaa_migration_server.util.Server;
import com.faishalbadri.hijab.aaa_migration_server.util.slider.ChildAnimationExample;
import com.faishalbadri.hijab.aaa_migration_server.util.slider.SliderLayout;
import com.faishalbadri.hijab.aaa_migration_server.util.slider.SliderLayout.PresetIndicators;
import com.faishalbadri.hijab.aaa_migration_server.util.slider.SliderLayout.Transformer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements newsView {

  private static final String save_news = "saveNews";
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
    setView();
    newsPresenter.onAttachView(this);

    if (savedInstanceState != null) {
      ArrayList<NewsBean> data = savedInstanceState.getParcelableArrayList(save_news);
      this.list_data.clear();
      this.list_data.addAll(data);
      newsAdapter.notifyDataSetChanged();
    } else {
      newsPresenter.getDataNews();
      newsPresenter.getDataSlider();
    }

    refreshFragmentNews.setOnRefreshListener(new OnRefreshListener() {
      @Override
      public void onRefresh() {
        refreshFragmentNews.setRefreshing(false);
        newsPresenter.getDataNews();
        newsPresenter.getDataSlider();
      }
    });
    return view;
  }

  private void setView() {
    newsPresenter = new NewsPresenter(NewsRepositoryInject.provideToNewsRepository(getActivity()));
    list_data = new ArrayList<>();
    newsAdapter = new NewsAdapter(getActivity(), list_data);
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
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(save_news, list_data);
  }

  @Override
  public void onSuccesNews(List<NewsBean> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    newsAdapter.notifyDataSetChanged();
  }

  @Override
  public void onErrorNews(String msg) {

  }

  @Override
  public void onSuccesSlider(List<PojoNews.NewsBean> dataSlider, String msg) {

    Log.i("responsesucces", msg);
    for (int a = 0; a < dataSlider.size(); a++) {
      HashMap<String, String> file_maps = new HashMap<String, String>();
      file_maps.put(dataSlider.get(a).getNews_title(),
          Server.BASE_API + dataSlider.get(a).getNews_images());

      for (final String name : file_maps.keySet()) {
        textSliderView = new TextSliderView(getActivity());

        String image = file_maps.get(name);

        textSliderView
            .description(name)
            .image(image)
            .setScaleType(ScaleType.CenterCrop)
            .setOnSliderClickListener(new OnSliderClickListener() {
              @Override
              public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(getActivity(), slider.getBundle().get("extra") + "",
                    Toast.LENGTH_SHORT).show();
              }
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
  }

  @Override
  public void onErrorSlider(String msg) {
    Log.i("responseerror", msg);
  }

}
