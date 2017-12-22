package com.faishalbadri.hijab.ui.news.fragment.news_popular;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews.NewsBean;
import com.faishalbadri.hijab.di.NewsPopularRepositoryInject;
import com.faishalbadri.hijab.ui.news.fragment.news_popular.NewsPopularContract.newsPopularView;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsPopularFragment extends Fragment implements newsPopularView {


  private static final String save_news_popular = "saveNewsPopular";
  @BindView(R.id.recyclerview_fragment_news_popular)
  RecyclerView recyclerviewFragmentNewsPopular;
  NewsPopularPresenter newsPopularPresenter;
  ArrayList<NewsBean> list_data;
  NewsPopularAdapter newsPopularAdapter;
  @BindView(R.id.refresh_fragment_news_popular)
  SwipeRefreshLayout refreshFragmentNewsPopular;

  public NewsPopularFragment() {
    // Required empty public constructor
  }

  public static NewsPopularFragment instance() {
    return new NewsPopularFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_news_popular, container, false);
    ButterKnife.bind(this, v);
    setView();
    newsPopularPresenter.onAttachView(this);

    if (savedInstanceState != null) {
      ArrayList<NewsBean> data = savedInstanceState.getParcelableArrayList(save_news_popular);
      this.list_data.clear();
      this.list_data.addAll(data);
      newsPopularAdapter.notifyDataSetChanged();
    } else {
      newsPopularPresenter.getDataNewsPopular();
    }

    refreshFragmentNewsPopular.setOnRefreshListener(new OnRefreshListener() {
      @Override
      public void onRefresh() {
        refreshFragmentNewsPopular.setRefreshing(false);
        newsPopularPresenter.getDataNewsPopular();
      }
    });
    return v;
  }

  private void setView() {
    newsPopularPresenter = new NewsPopularPresenter(
        NewsPopularRepositoryInject.provideToNewsPopularRepository(getActivity()));
    list_data = new ArrayList<>();
    newsPopularAdapter = new NewsPopularAdapter(getActivity(), list_data);
    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerviewFragmentNewsPopular.setLayoutManager(llm);
    recyclerviewFragmentNewsPopular.setAdapter(newsPopularAdapter);
    refreshFragmentNewsPopular.setColorSchemeResources(
        android.R.color.holo_blue_bright,
        android.R.color.holo_green_light,
        android.R.color.holo_orange_light,
        android.R.color.holo_red_light);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(save_news_popular, list_data);
  }

  @Override
  public void onSuccesNewsPopular(List<NewsBean> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    newsPopularAdapter.notifyDataSetChanged();

  }

  @Override
  public void onErrorNewsPopular(String msg) {

  }
}
