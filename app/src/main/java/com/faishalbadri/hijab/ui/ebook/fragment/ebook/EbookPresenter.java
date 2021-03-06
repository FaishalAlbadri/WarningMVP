package com.faishalbadri.hijab.ui.ebook.fragment.ebook;

import com.faishalbadri.hijab.data.ebook.with_category.EbookCategoryItem;
import com.faishalbadri.hijab.repository.ebook.EbookDataResource.EbookGetCallBack;
import com.faishalbadri.hijab.repository.ebook.EbookRepository;
import com.faishalbadri.hijab.ui.ebook.fragment.ebook.EbookContract.EbookView;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class EbookPresenter implements EbookContract.EbookPresenter {

  private EbookView ebookView;
  private EbookRepository ebookRepository;

  public EbookPresenter(EbookRepository ebookRepository) {
    this.ebookRepository = ebookRepository;
  }

  @Override
  public void onAttachView(EbookView view) {
    this.ebookView = view;
  }

  @Override
  public void onDettachView() {
  }

  @Override
  public void getData() {
    ebookRepository.getEbookList(new EbookGetCallBack() {
      @Override
      public void onSuccessEbook(List<EbookCategoryItem> ebook, String msg) {
        ebookView.onSuccessEbook(ebook, msg);
      }

      @Override
      public void onErrorEbook(String msg) {
        ebookView.onErrorEbook(msg);
      }
    });
  }
}
