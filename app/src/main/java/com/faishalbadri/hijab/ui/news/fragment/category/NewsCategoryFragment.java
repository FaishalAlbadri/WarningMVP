package com.faishalbadri.hijab.ui.news.fragment.category;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoCategory;
import com.faishalbadri.hijab.data.PojoCategory.KategoriBean;
import com.faishalbadri.hijab.di.NewsCategoryRepositoryInject;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsCategoryFragment extends Fragment implements NewsCategoryContract.newsCategoryView {


  @BindView(R.id.recyclerview_fragment_news_category)
  RecyclerView recyclerviewFragmentNewsCategory;
  NewsCategoryPresenter newsCategoryPresenter;
  ArrayList<PojoCategory.KategoriBean> list_data;
  NewsCategoryAdapter newsCategoryAdapter;
  private static final String save_category = "saveCategory";


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

    if (savedInstanceState != null){
      ArrayList<PojoCategory.KategoriBean> data = savedInstanceState.getParcelableArrayList(save_category);
      this.list_data.clear();
      this.list_data.addAll(data);
      newsCategoryAdapter.notifyDataSetChanged();
    }else {
      newsCategoryPresenter.getDataNewsCategory();
    }
    return v;
  }

  private void setView() {
    newsCategoryPresenter = new NewsCategoryPresenter(NewsCategoryRepositoryInject.provideToNewsCategoryInject(getActivity()));
    list_data = new ArrayList<>();
    newsCategoryAdapter = new NewsCategoryAdapter(getActivity(),list_data);
    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
    llm.setOrientation(LinearLayoutManager.VERTICAL);
    recyclerviewFragmentNewsCategory.setLayoutManager(llm);
    recyclerviewFragmentNewsCategory.setAdapter(newsCategoryAdapter);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(save_category,list_data);
  }

  @Override
  public void onSuccesNewsCategory(List<KategoriBean> data, String msg) {
    list_data.clear();
    list_data.addAll(data);
    newsCategoryAdapter.notifyDataSetChanged();
  }

  @Override
  public void onErrorNewsCategory(String msg) {

  }

}
