package com.faishalbadri.hijab.ui.news.fragment.news;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.request.RequestOptions;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import com.faishalbadri.hijab.data.PojoSlider;
import com.faishalbadri.hijab.data.PojoSlider.SliderBean;
import com.faishalbadri.hijab.di.NewsRepositoryInject;
import com.faishalbadri.hijab.ui.news.fragment.news.NewsContract.newsView;
import com.faishalbadri.hijab.util.Server;
import com.faishalbadri.hijab.util.slider.ChildAnimationExample;
import com.faishalbadri.hijab.util.slider.SliderLayout;
import com.squareup.picasso.Picasso;
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
  ArrayList<IsiBean> list_data;
  NewsAdapter newsAdapter;
  private static final String save_news = "saveNews";
  @BindView(R.id.slider_fragment_news)
  SliderLayout sliderFragmentNews;
  TextSliderView textSliderView;


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
      ArrayList<IsiBean> data = savedInstanceState.getParcelableArrayList(save_news);
      this.list_data.clear();
      this.list_data.addAll(data);
      newsAdapter.notifyDataSetChanged();
    } else {
      newsPresenter.getDataNews();
      newsPresenter.getDataSlider();
    }
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
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(save_news, list_data);
  }

  @Override
  public void onSuccesNews(List<IsiBean> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    newsAdapter.notifyDataSetChanged();
  }

  @Override
  public void onErrorNews(String msg) {

  }

  @Override
  public void onSuccesSlider(List<SliderBean> dataSlider, String msg) {

    Log.i("responsesucces",msg);
    for (int a = 0; a < dataSlider.size(); a++) {
      HashMap<String, String> file_maps = new HashMap<String, String>();
      file_maps.put(dataSlider.get(a).getSlider_judul(),
          Server.BASE_IMG + dataSlider.get(a).getSlider_gambar());


      for (final String name : file_maps.keySet()) {
        textSliderView = new TextSliderView(getActivity());

        String image = file_maps.get(name);

        textSliderView
            .description(name)
            .image(image)
            .setScaleType(BaseSliderView.ScaleType.CenterCrop)
            .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
              @Override
              public void onSliderClick(BaseSliderView slider) {
                Toast.makeText(getActivity(), slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
              }
            });

        textSliderView.bundle(new Bundle());
        textSliderView.getBundle().putString("extra", name);

        sliderFragmentNews.addSlider(textSliderView);
      }
      sliderFragmentNews.setPresetTransformer(SliderLayout.Transformer.Default);
      sliderFragmentNews.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
      sliderFragmentNews.setCustomAnimation(new ChildAnimationExample());
      sliderFragmentNews.setDuration(2000);
      sliderFragmentNews.addOnPageChangeListener(getActivity());
    }
  }

  @Override
  public void onErrorSlider(String msg) {
    Log.i("responseerror",msg);
  }
}
