package com.faishalbadri.hijab.ui.send_article;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.util.ActivityUtil;

/**
 * Created by fikriimaduddin on 12/02/18.
 */

public class SendArticleContract {

  public interface uploadFileView {

    void onSuccessUploadFile(ActivityUtil activityUtil);

    void onErrorUploadFile(String msg);
  }

  public interface uploadFilePresenter extends BasePresenter<uploadFileView> {

    void getUploadFile(String path);
  }

}
