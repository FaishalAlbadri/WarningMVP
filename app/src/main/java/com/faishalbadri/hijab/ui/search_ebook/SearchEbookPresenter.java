package com.faishalbadri.hijab.ui.search_ebook;

import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.repository.search_ebook.SearchEbookDataResource.SearchEbookGetCallback;
import com.faishalbadri.hijab.repository.search_ebook.SearchEbookRepository;
import com.faishalbadri.hijab.ui.search_ebook.SearchEbookContract.SearchEbookView;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEbookPresenter implements SearchEbookContract.SearchEbookPresenter {

  SearchEbookContract.SearchEbookView searchEbookView;
  SearchEbookRepository searchEbookRepository;

  public SearchEbookPresenter(
      SearchEbookRepository searchEbookRepository) {
    this.searchEbookRepository = searchEbookRepository;
  }

  @Override
  public void onAttachView(SearchEbookView view) {
    this.searchEbookView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataSearchEbook(String key) {
    searchEbookRepository.getSearchEbookResult(key, new SearchEbookGetCallback() {
      @Override
      public void onSuccesSearchEbook(List<EbookBean> data, String msg) {
        searchEbookView.onSuccesSearchEbook(data, msg);
      }

      @Override
      public void onWrongSearchEbook(String msg) {
        searchEbookView.onWrongSearchEbook(msg);
      }

      @Override
      public void onErrorSearchEbook(String msg) {
        searchEbookView.onErrorSearchEbook(msg);
      }
    });
  }
}
