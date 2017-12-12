package com.faishalbadri.hijab.ui.video.fragment.category_video;


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
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoCategory.KategoriBean;
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
  ArrayList<KategoriBean> resultItem;
  View v;

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
    if (savedInstanceState != null) {
      ArrayList<KategoriBean> resultArray = savedInstanceState
          .getParcelableArrayList(SAVE_DATA_CATEGORY_VIDEO);
      this.resultItem.clear();
      this.resultItem.addAll(resultArray);
      categoryVideoAdapter.notifyDataSetChanged();
    } else {
      categoryVideoPresenter.getDataCategoryVideo();
    }
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
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(SAVE_DATA_CATEGORY_VIDEO, resultItem);
  }

  @Override
  public void onSuccesCategoryVideo(List<KategoriBean> category, String msg) {
    resultItem.clear();
    resultItem.addAll(category);
    categoryVideoAdapter.notifyDataSetChanged();
  }

  @Override
  public void onErrorCategoryVideo(String msg) {
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }
}
