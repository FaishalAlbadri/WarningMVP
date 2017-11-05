package com.faishalbadri.hijab.repository.news_by_category;

import android.support.annotation.NonNull;
import com.faishalbadri.hijab.data.PojoNews;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public interface NewsByCategoryDataResource {

  interface NewsByCategoryGetDataCallBack{

    void onSuccessNewsByCategory(List<PojoNews.IsiBean> video, String msg);

    void onErrorNewsByCategory(String msg);

  }

  void getNewsByCategoryGetDataCallBack(String id, @NonNull NewsByCategoryDataResource.NewsByCategoryGetDataCallBack newsByCategoryGetDataCallBack);

}
