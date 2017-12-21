package com.faishalbadri.hijab.revamp.ui.video.fragment.video;

import com.faishalbadri.hijab.revamp.base.BasePresenter;
import com.faishalbadri.hijab.revamp.data.PojoVideo;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class VideoContract {

  public interface VideoView {

    void onSuccesVideo(List<PojoVideo.VideosBean> video, String msg);

    void onErrorVideo(String msg);
  }

  public interface VideoPresenter extends BasePresenter<VideoView> {

    void getDataVideo();
  }

}
