package com.faishalbadri.hijab.ui.video.fragment.category_video;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import com.faishalbadri.hijab.util.Singleton.DataServerProgress;
import com.faishalbadri.hijab.util.widget.GridItemDecoration;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryVideoFragment extends Fragment implements categoryVideoView {


  @BindView(R.id.recyclerview_fragment_category_video)
  RecyclerView recyclerviewFragmentCategoryVideo;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  @BindView(R.id.layout_loading)
  RelativeLayout layoutLoading;
  private CategoryVideoPresenter categoryVideoPresenter;
  private CategoryVideoAdapter categoryVideoAdapter;
  private ArrayList<CategoriesBean> resultItem;
  private View v;

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
    categoryVideoPresenter.getDataCategoryVideo();
    return v;
  }

  private void setView() {
    categoryVideoPresenter = new CategoryVideoPresenter(
        CategoryRepositoryInject.provideToCategoryInject(getActivity()));
    categoryVideoPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    categoryVideoAdapter = new CategoryVideoAdapter(getActivity(), resultItem);
    recyclerviewFragmentCategoryVideo.setLayoutManager(new GridLayoutManager(getActivity(), 4));
    recyclerviewFragmentCategoryVideo.addItemDecoration(new GridItemDecoration(4, 4, true));
    recyclerviewFragmentCategoryVideo.setAdapter(categoryVideoAdapter);
  }

  @Override
  public void onSuccesCategoryVideo(List<CategoriesBean> category, String msg) {
    resultItem.clear();
    resultItem.addAll(category);
    categoryVideoAdapter.notifyDataSetChanged();
    DataServerProgress.getInstance().onSuccesData(recyclerviewFragmentCategoryVideo, layoutLoading);
  }

  @Override
  public void onErrorCategoryVideo(String msg) {
    whenError();
  }

  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    layoutLoading.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
    whenError();
  }

  private void whenError() {
    DataServerProgress.getInstance().onErrorData(layoutNoInternetAcces, layoutLoading);
    if (DataServerProgress.getInstance().getStatus().equals("error")) {
      categoryVideoPresenter.getDataCategoryVideo();
    }
  }
}
