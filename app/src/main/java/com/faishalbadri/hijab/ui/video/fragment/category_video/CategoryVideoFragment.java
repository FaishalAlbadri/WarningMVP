package com.faishalbadri.hijab.ui.video.fragment.category_video;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoCategory.CategoriesBean;
import com.faishalbadri.hijab.di.CategoryRepositoryInject;
import com.faishalbadri.hijab.ui.video.fragment.category_video.CatergoryVideoContract.categoryVideoView;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryVideoFragment extends Fragment implements categoryVideoView {


  private static final String SAVE_DATA_CATEGORY_VIDEO = "save";
  @BindView(R.id.recyclerview_fragment_category_video)
  RecyclerView recyclerviewFragmentCategoryVideo;
  CategoryVideoPresenter categoryVideoPresenter;
  CategoryVideoAdapter categoryVideoAdapter;
  ArrayList<CategoriesBean> resultItem;
  View v;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;

  public CategoryVideoFragment() {
    // Required empty public constructor
  }

  public static CategoryVideoFragment instance() {
    return new CategoryVideoFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    v = inflater.inflate(R.layout.fragment_category_video, container, false);
    ButterKnife.bind(this, v);
    setView();
    categoryVideoAdapter.notifyDataSetChanged();
    categoryVideoPresenter.getDataCategoryVideo();
    return v;
  }

  private void setView() {
    categoryVideoPresenter = new CategoryVideoPresenter(
        CategoryRepositoryInject.provideToCategoryInject(getActivity()));
    categoryVideoPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    categoryVideoAdapter = new CategoryVideoAdapter(getActivity(), resultItem);
    recyclerviewFragmentCategoryVideo.setLayoutManager(new LinearLayoutManager(getActivity()));
    recyclerviewFragmentCategoryVideo.setAdapter(categoryVideoAdapter);
  }

  @Override
  public void onSuccesCategoryVideo(List<CategoriesBean> category, String msg) {
    resultItem.clear();
    resultItem.addAll(category);
    categoryVideoAdapter.notifyDataSetChanged();
    recyclerviewFragmentCategoryVideo.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onErrorCategoryVideo(String msg) {
    recyclerviewFragmentCategoryVideo.setVisibility(View.GONE);
    layoutNoInternetAcces.setVisibility(View.VISIBLE);
  }

  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    categoryVideoPresenter.getDataCategoryVideo();
  }
}
