package com.faishalbadri.hijab.ui.video.fragment.video;

import com.faishalbadri.hijab.base.BasePresenter;
import com.faishalbadri.hijab.data.PojoVideo.VideosBean;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoContract {

  public interface VideoView {

    void onSuccesVideo(List<VideosBean> video, String msg);

    void onErrorVideo(String msg);
  }

  public interface VideoPresenter extends BasePresenter<VideoView> {

    void getDataVideo();
  }

}
