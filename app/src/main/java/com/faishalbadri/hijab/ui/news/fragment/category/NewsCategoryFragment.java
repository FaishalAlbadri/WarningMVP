package com.faishalbadri.hijab.ui.news.fragment.category;


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
import com.faishalbadri.hijab.data.categories.CategoriesItem;
import com.faishalbadri.hijab.di.CategoryRepositoryInject;
import com.faishalbadri.hijab.ui.news.fragment.category.NewsCategoryContract.newsCategoryView;
import com.faishalbadri.hijab.util.Singleton.DataServerProgress;
import com.faishalbadri.hijab.util.widget.GridItemDecoration;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsCategoryFragment extends Fragment implements
    newsCategoryView {


  @BindView(R.id.recyclerview_fragment_news_category)
  RecyclerView recyclerviewFragmentNewsCategory;
  NewsCategoryPresenter newsCategoryPresenter;
  ArrayList<CategoriesItem> list_data;
  NewsCategoryAdapter newsCategoryAdapter;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;
  @BindView(R.id.layout_loading)
  RelativeLayout layoutLoading;


  public NewsCategoryFragment() {
    // Required empty public constructor
  }


  public static NewsCategoryFragment instance() {
    return new NewsCategoryFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_news_category, container, false);
    ButterKnife.bind(this, v);
    setView();
    newsCategoryPresenter.onAttachView(this);
    newsCategoryPresenter.getDataNewsCategory();
    return v;
  }

  private void setView() {
    newsCategoryPresenter = new NewsCategoryPresenter(
        CategoryRepositoryInject.provideToCategoryInject(getActivity()));
    list_data = new ArrayList<>();
    newsCategoryAdapter = new NewsCategoryAdapter(getActivity(), list_data);
    recyclerviewFragmentNewsCategory.setLayoutManager(new GridLayoutManager(getActivity(), 4));
    recyclerviewFragmentNewsCategory.addItemDecoration(new GridItemDecoration(4, 4, true));
    recyclerviewFragmentNewsCategory.setAdapter(newsCategoryAdapter);
  }

  @Override
  public void onSuccesNewsCategory(List<CategoriesItem> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    newsCategoryAdapter.notifyDataSetChanged();
    DataServerProgress.getInstance().onSuccesData(recyclerviewFragmentNewsCategory, layoutLoading);
  }

  @Override
  public void onErrorNewsCategory(String msg) {
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
      newsCategoryPresenter.getDataNewsCategory();
    }
  }

}
