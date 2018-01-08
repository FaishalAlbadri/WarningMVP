package com.faishalbadri.hijab.ui.ebook.fragment.category;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEbookCategory.EbookCategoriesBean;
import com.faishalbadri.hijab.di.EbookCategoryRepositoryInject;
import com.faishalbadri.hijab.ui.ebook.fragment.category.EbookCategoryContract.EbookCategoryView;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EbookCategoryFragment extends Fragment implements EbookCategoryView {


  @BindView(R.id.recyclerview_fragment_category_ebook)
  RecyclerView recyclerviewFragmentCategoryEbook;
  View view;
  EbookCategoryPresenter ebookCategoryPresenter;
  EbookCategoryAdapter adapter;
  ArrayList<EbookCategoriesBean> resultItem;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;

  public EbookCategoryFragment() {
    // Required empty public constructor
  }

  public static EbookCategoryFragment instance() {
    return new EbookCategoryFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    view = inflater.inflate(R.layout.fragment_ebook_category, container, false);
    ButterKnife.bind(this, view);
    setView();
    ebookCategoryPresenter.getData();
    return view;
  }

  private void setView() {
    ebookCategoryPresenter = new EbookCategoryPresenter(
        EbookCategoryRepositoryInject.provideToEbookCategoryRepositories(getActivity()));
    ebookCategoryPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    adapter = new EbookCategoryAdapter(getActivity(), resultItem);
    recyclerviewFragmentCategoryEbook.setLayoutManager(new LinearLayoutManager(getActivity()));
    recyclerviewFragmentCategoryEbook.setAdapter(adapter);
  }

  @Override
  public void onSuccessCategoryEbook(List<EbookCategoriesBean> ebook,
      String msg) {
    resultItem.clear();
    resultItem.addAll(ebook);
    adapter.notifyDataSetChanged();
    recyclerviewFragmentCategoryEbook.setVisibility(View.VISIBLE);
    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onNullCategoryEbook(String msg) {
    Toast.makeText(getActivity(), "No Data", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorCategoryEbook(String msg) {
    recyclerviewFragmentCategoryEbook.setVisibility(View.GONE);
    layoutNoInternetAcces.setVisibility(View.VISIBLE);
  }

  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    ebookCategoryPresenter.getData();
  }
}
