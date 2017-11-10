package com.faishalbadri.hijab.ui.ebook_by_category;

import com.faishalbadri.hijab.data.PojoEbook.EbookBean;
import com.faishalbadri.hijab.repository.ebook_by_category.EbookByCategoryDataResource.EbookByCategoryDataCallBack;
import com.faishalbadri.hijab.repository.ebook_by_category.EbookByCategoryRepository;
import com.faishalbadri.hijab.ui.ebook_by_category.EbookByCategoryContract.ebookByCategoryView;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookByCategoryPresenter implements EbookByCategoryContract.EbookByCategoryPresenter {

  ebookByCategoryView ebookByCategoryView;
  EbookByCategoryRepository ebookByCategoryRepository;

  public EbookByCategoryPresenter(EbookByCategoryRepository ebookByCategoryRepository) {
    this.ebookByCategoryRepository = ebookByCategoryRepository;
  }

  @Override
  public void onAttachView(ebookByCategoryView view) {
    ebookByCategoryView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataEbookByCategory(String id) {
    ebookByCategoryRepository.getByCategoryGetDataCallBack(id, new EbookByCategoryDataCallBack() {
      @Override
      public void onSuccessEbookByCategory(List<EbookBean> video, String msg) {
        ebookByCategoryView.onSuccesEbookByCategory(video, msg);
      }

      @Override
      public void onErrorEbookByCategory(String msg) {
        ebookByCategoryView.onErrorEbookByCategory(msg);
      }
    });
  }
}
