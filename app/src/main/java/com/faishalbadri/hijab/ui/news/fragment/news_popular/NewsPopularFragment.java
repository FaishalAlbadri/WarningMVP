package com.faishalbadri.hijab.ui.news.fragment.news_popular;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import com.faishalbadri.hijab.di.NewsPopularRepositoryInject;
import com.faishalbadri.hijab.di.NewsRepositoryInject;
import com.faishalbadri.hijab.ui.news.fragment.news.NewsAdapter;
import com.faishalbadri.hijab.ui.news.fragment.news.NewsPresenter;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsPopularFragment extends Fragment implements NewsPopularContract.newsPopularView {


  @BindView(R.id.recyclerview_fragment_news_popular)
  RecyclerView recyclerviewFragmentNewsPopular;
  NewsPopularPresenter newsPopularPresenter;
  ArrayList<IsiBean> list_data;
  NewsPopularAdapter newsPopularAdapter;
  private static final String save_news_popular = "saveNewsPopular";

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

    if (savedInstanceState != null){
      ArrayList<PojoNews.IsiBean> data = savedInstanceState.getParcelableArrayList(save_news_popular);
      this.list_data.clear();
      this.list_data.addAll(data);
      newsPopularAdapter.notifyDataSetChanged();
    }else {
      newsPopularPresenter.getDataNewsPopular();
    }
    return v;
  }

  private void setView() {
    newsPopularPresenter = new NewsPopularPresenter(NewsPopularRepositoryInject.provideToNewsPopularRepository(getActivity()));
    list_data = new ArrayList<>();
    newsPopularAdapter = new NewsPopularAdapter(getActivity(),list_data);
    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerviewFragmentNewsPopular.setLayoutManager(llm);
    recyclerviewFragmentNewsPopular.setAdapter(newsPopularAdapter);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(save_news_popular,list_data);
  }

  @Override
  public void onSuccesNewsPopular(List<IsiBean> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    newsPopularAdapter.notifyDataSetChanged();
  }

  @Override
  public void onErrorNewsPopular(String msg) {

  }
}
