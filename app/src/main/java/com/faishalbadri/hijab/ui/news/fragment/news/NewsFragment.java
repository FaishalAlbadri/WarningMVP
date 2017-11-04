package com.faishalbadri.hijab.ui.news.fragment.news;


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
import com.faishalbadri.hijab.data.PojoCategory;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.data.PojoNews.IsiBean;
import com.faishalbadri.hijab.di.NewsRepositoryInject;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements NewsContract.newsView {

  @BindView(R.id.recyclerview_fragment_news)
  RecyclerView recyclerviewFragmentNews;
  NewsPresenter newsPresenter;
  ArrayList<PojoNews.IsiBean> list_data;
  NewsAdapter newsAdapter;
  private static final String save_news = "saveNews";


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

    if (savedInstanceState != null){
      ArrayList<PojoNews.IsiBean> data = savedInstanceState.getParcelableArrayList(save_news);
      this.list_data.clear();
      this.list_data.addAll(data);
      newsAdapter.notifyDataSetChanged();
    }else {
      newsPresenter.getDataNews();
    }
    return view;
  }

  private void setView() {
    newsPresenter = new NewsPresenter(NewsRepositoryInject.provideToNewsRepository(getActivity()));
    list_data = new ArrayList<>();
    newsAdapter = new NewsAdapter(getActivity(),list_data);
    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerviewFragmentNews.setLayoutManager(llm);
    recyclerviewFragmentNews.setAdapter(newsAdapter);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(save_news,list_data);
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
}
