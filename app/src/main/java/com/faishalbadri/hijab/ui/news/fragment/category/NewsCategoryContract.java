package com.faishalbadri.hijab.ui.news.fragment.category;

import com.faishalbadri.hijab.aaa_migration_server.base.BasePresenter;
import com.faishalbadri.hijab.aaa_migration_server.data.PojoCategory;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsCategoryContract {

  public interface newsCategoryView {

    void onSuccesNewsCategory(List<PojoCategory.CategoriesBean> data, String msg);

    void onErrorNewsCategory(String msg);

  }

  public interface newsCategoryPresenter extends BasePresenter<newsCategoryView> {

    void getDataNewsCategory();

  }

}
