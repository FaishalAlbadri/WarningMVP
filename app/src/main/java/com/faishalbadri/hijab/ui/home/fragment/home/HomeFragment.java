package com.faishalbadri.hijab.ui.home.fragment.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.daimajia.slider.library.SliderTypes.BaseSliderView.ScaleType;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.DataHomeFragment;
import com.faishalbadri.hijab.data.PojoSlider.SliderBean;
import com.faishalbadri.hijab.di.SliderHomeRepositoryInject;
import com.faishalbadri.hijab.ui.home.fragment.home.HomeContract.homeView;
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
public class HomeFragment extends Fragment implements homeView {


  @BindView(R.id.slider_fragment_home)
  SliderLayout sliderFragmentHome;
  @BindView(R.id.recyclerview_fragment_home)
  RecyclerView recyclerviewFragmentHome;
  private HomeFragmentAdapter homeFragmentAdapter;
  private List<DataHomeFragment> data_list;
  private String event, ebook, news, voting, video;
  private String eventDetail, ebookDetail, newsDetail, votingDetail, videoDetail, communityDetail;
  private int[] image;
  private HomePresenter homePresenter;
  private TextSliderView textSliderView;


  public HomeFragment() {
    // Required empty public constructor
  }

  public static HomeFragment instance() {
    return new HomeFragment();
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    ButterKnife.bind(this, view);
    setView();
    homePresenter.onAttachView(this);
    homePresenter.getDataSlider();
    setString();
    dataHomeFragment();
    return view;
  }

  private void setString() {
    image = new int[]{
        R.drawable.banner_news,
        R.drawable.banner_video,
        R.drawable.banner_vote,
        R.drawable.banner_event,
        R.drawable.banner_ebook
    };
    event = getActivity().getResources().getString(R.string.text_pinky_hijab_event);
    ebook = getActivity().getResources().getString(R.string.text_pinky_hijab_ebook);
    news = getActivity().getResources().getString(R.string.text_pinky_hijab_news);
    voting = getActivity().getResources().getString(R.string.text_pinky_hijab_voting);
    video = getActivity().getResources().getString(R.string.text_pinky_hijab_video);

    eventDetail = getActivity().getResources().getString(R.string.text_pinky_hijab_event_detail);
    ebookDetail = getActivity().getResources().getString(R.string.text_pinky_hijab_ebook_detail);
    newsDetail = getActivity().getResources().getString(R.string.text_pinky_hijab_news_detail);
    votingDetail = getActivity().getResources().getString(R.string.text_pinky_hijab_voting_detail);
    videoDetail = getActivity().getResources().getString(R.string.text_pinky_hijab_video_detail);
  }


  private void setView() {
    data_list = new ArrayList<>();
    homePresenter = new HomePresenter(
        SliderHomeRepositoryInject.provideToSliderHomeRepository(getActivity()));
    homeFragmentAdapter = new HomeFragmentAdapter(getActivity(), data_list);
    LinearLayoutManager llmHomeFragment = new LinearLayoutManager(getActivity());
    llmHomeFragment.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerviewFragmentHome.setLayoutManager(llmHomeFragment);
    recyclerviewFragmentHome.setAdapter(homeFragmentAdapter);
  }

  private void dataHomeFragment() {
    data_list.add(new DataHomeFragment(news, newsDetail, image[0]));
    data_list.add(new DataHomeFragment(video, videoDetail, image[1]));
    data_list.add(new DataHomeFragment(voting, votingDetail, image[2]));
    data_list.add(new DataHomeFragment(event, eventDetail, image[3]));
    data_list.add(new DataHomeFragment(ebook, ebookDetail, image[4]));
    homeFragmentAdapter.notifyDataSetChanged();
  }

  @Override
  public void onSuccesSlider(List<SliderBean> dataSlider, String msg) {
    for (int a = 0; a < dataSlider.size(); a++) {
      HashMap<String, String> file_maps = new HashMap<String, String>();
      file_maps.put(dataSlider.get(a).getSlider_title(),
          Server.BASE_ASSETS + dataSlider.get(a).getSlider_img());

      for (final String name : file_maps.keySet()) {
        textSliderView = new TextSliderView(getActivity());

        String image = file_maps.get(name);

        textSliderView
            .description(name)
            .image(image)
            .setScaleType(ScaleType.CenterCrop)
            .setOnSliderClickListener(slider -> {
              Toast.makeText(getActivity(), slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
            });

        textSliderView.bundle(new Bundle());
        textSliderView.getBundle().putString("extra", name);

        sliderFragmentHome.addSlider(textSliderView);
      }
      sliderFragmentHome.setPresetTransformer(Transformer.Default);
      sliderFragmentHome.setPresetIndicator(PresetIndicators.Center_Bottom);
      sliderFragmentHome.setCustomAnimation(new ChildAnimationExample());
      sliderFragmentHome.setDuration(5000);
      sliderFragmentHome.addOnPageChangeListener(getActivity());
    }
  }

  @Override
  public void onErrorSlider(String msg) {

  }


}
