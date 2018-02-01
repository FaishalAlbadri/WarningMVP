package com.faishalbadri.hijab.ui.ebook.fragment.ebook;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
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
import com.faishalbadri.hijab.data.PojoEbookWithCategory;
import com.faishalbadri.hijab.di.EbookRepositoryInject;
import com.faishalbadri.hijab.ui.ebook.fragment.ebook.EbookContract.EbookView;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EbookFragment extends Fragment implements EbookView {


  View v;
  @BindView(R.id.recyclerview_activity_ebook)
  RecyclerView recyclerviewActivityEbook;
  EbookPresenter ebookPresenter;
  EbookAdapter ebookAdapter;
  ArrayList<PojoEbookWithCategory.DataBean> resultItem;
  @BindView(R.id.refresh_fragment_ebook)
  SwipeRefreshLayout refreshFragmentEbook;
  @BindView(R.id.layout_no_internet_acces)
  RelativeLayout layoutNoInternetAcces;

  public EbookFragment() {
    // Required empty public constructor
  }

  public static EbookFragment instance() {
    return new EbookFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    v = inflater.inflate(R.layout.fragment_ebook, container, false);
    ButterKnife.bind(this, v);
    setView();
    ebookPresenter.getData();

    refreshFragmentEbook.setOnRefreshListener(() -> {
      refreshFragmentEbook.setRefreshing(false);
      ebookPresenter.getData();
    });
    return v;
  }

  private void setView() {
    ebookPresenter = new EbookPresenter(
        EbookRepositoryInject.provideToEbookRepositories(getActivity()));
    ebookPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    ebookAdapter = new EbookAdapter(getActivity(), resultItem);
    recyclerviewActivityEbook.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    recyclerviewActivityEbook.setAdapter(ebookAdapter);
    refreshFragmentEbook.setColorSchemeResources(
        android.R.color.holo_blue_bright,
        android.R.color.holo_green_light,
        android.R.color.holo_orange_light,
        android.R.color.holo_red_light);
  }

  @Override
  public void onSuccessEbook(List<PojoEbookWithCategory.DataBean> ebook, String msg) {
//    resultItem.clear();
//    resultItem.addAll(ebook);
//    ebookAdapter.notifyDataSetChanged();
//    refreshFragmentEbook.setVisibility(View.VISIBLE);
//    layoutNoInternetAcces.setVisibility(View.GONE);
  }

  @Override
  public void onNullEbook(String msg) {
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorEbook(String msg) {
    refreshFragmentEbook.setVisibility(View.GONE);
    layoutNoInternetAcces.setVisibility(View.VISIBLE);
  }

  @OnClick(R.id.layout_no_internet_acces)
  public void onViewClicked() {
    ebookPresenter.getData();
  }
}
