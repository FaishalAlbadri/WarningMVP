package com.faishalbadri.hijab.ui.ebook.fragment.category;

import com.faishalbadri.hijab.aaa_migration_server.data.PojoEbookCategory;
import com.faishalbadri.hijab.aaa_migration_server.repository.ebook_category.EbookCategoryDataResource.EbookCategoryGetCallBack;
import com.faishalbadri.hijab.aaa_migration_server.repository.ebook_category.EbookCategoryRepository;
import com.faishalbadri.hijab.ui.ebook.fragment.category.EbookCategoryContract.EbookCategoryView;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookCategoryPresenter implements EbookCategoryContract.EbookCategoryPresenter {

  EbookCategoryView ebookCategoryView;
  private EbookCategoryRepository ebookCategoryRepository;

  public EbookCategoryPresenter(EbookCategoryRepository ebookCategoryRepository) {
    this.ebookCategoryRepository = ebookCategoryRepository;
  }

  @Override
  public void onAttachView(EbookCategoryView view) {
    ebookCategoryView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getData() {
    ebookCategoryRepository.getEbookCategoryList(new EbookCategoryGetCallBack() {
      @Override
      public void onSuccessCategoryEbook(List<PojoEbookCategory.EbookCategoriesBean> data,
          String msg) {
        ebookCategoryView.onSuccessCategoryEbook(data, msg);
      }

      @Override
      public void onNullCategoryEbook(String msg) {
        ebookCategoryView.onNullCategoryEbook(msg);
      }

      @Override
      public void onErrorCategoryEbook(String msg) {
        ebookCategoryView.onErrorCategoryEbook(msg);
      }
    });
  }
}
