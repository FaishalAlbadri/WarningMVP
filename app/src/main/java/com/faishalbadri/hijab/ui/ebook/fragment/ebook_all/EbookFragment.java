package com.faishalbadri.hijab.ui.ebook.fragment.ebook_all;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.di.EbookRepositoryInject;
import com.faishalbadri.hijab.ui.ebook.fragment.ebook_all.EbookContract.EbookView;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EbookFragment extends Fragment implements EbookView{


  public EbookFragment() {
    // Required empty public constructor
  }

  View v;
  @BindView(R.id.recyclerview_activity_ebook)
  RecyclerView recyclerviewActivityEbook;
  EbookPresenter ebookPresenter;
  EbookAdapter ebookAdapter;
  ArrayList<EbookBean> resultItem;
  private static final String SAVE_DATA_EBOOK = "save";

  public static EbookFragment instance() {
    return new EbookFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    v = inflater.inflate(R.layout.fragment_ebook, container, false);
    ButterKnife.bind(this, v);
    setView();
    if (savedInstanceState != null) {
      ArrayList<EbookBean> resultArray = savedInstanceState.getParcelableArrayList(SAVE_DATA_EBOOK);
      this.resultItem.clear();
      this.resultItem.addAll(resultArray);
      ebookAdapter.notifyDataSetChanged();
    } else {
      ebookPresenter.getData();
    }
    return v;
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putParcelableArrayList(SAVE_DATA_EBOOK, resultItem);
  }

  private void setView() {
    ebookPresenter = new EbookPresenter(
        EbookRepositoryInject.provideToEbookRepositories(getActivity()));
    ebookPresenter.onAttachView(this);
    resultItem = new ArrayList<>();
    ebookAdapter = new EbookAdapter(getActivity(), resultItem);
    recyclerviewActivityEbook.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    recyclerviewActivityEbook.setAdapter(ebookAdapter);
  }

  @Override
  public void onSuccessEbook(List<EbookBean> ebook, String msg) {
    resultItem.clear();
    resultItem.addAll(ebook);
    ebookAdapter.notifyDataSetChanged();
  }

  @Override
  public void onNullEbook(String msg) {
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onErrorEbook(String msg) {
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }
}