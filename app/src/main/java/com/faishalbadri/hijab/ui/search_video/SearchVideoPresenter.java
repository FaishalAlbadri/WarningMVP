package com.faishalbadri.hijab.ui.search_video;


import com.faishalbadri.hijab.data.PojoVideo.VideosBean;
import com.faishalbadri.hijab.repository.search_video_.SearchVideoDataResource.SearchVideoGetCallback;
import com.faishalbadri.hijab.repository.search_video_.SearchVideoRepository;
import com.faishalbadri.hijab.ui.search_video.SearchVideoContract.SearchVideoView;
import java.util.List;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchVideoPresenter implements SearchVideoContract.SearchVideoPresenter {

  private SearchVideoContract.SearchVideoView searchVideoView;
  private SearchVideoRepository searchVideoRepository;

  public SearchVideoPresenter(
      SearchVideoRepository searchVideoRepository) {
    this.searchVideoRepository = searchVideoRepository;
  }

  @Override
  public void onAttachView(SearchVideoView view) {
    this.searchVideoView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataSearchVideo(String key) {
    searchVideoRepository.getSearchVideoResult(key, new SearchVideoGetCallback() {
      @Override
      public void onSuccesSearchVideo(List<VideosBean> data, String msg) {
        searchVideoView.onSuccesSearchVideo(data, msg);
      }

      @Override
      public void onWrongSearchVideo(String msg) {
        searchVideoView.onWrongSearchVideo(msg);
      }

      @Override
      public void onErrorSearchVideo(String msg) {
        searchVideoView.onErrorSearchVideo(msg);
      }
    });
  }
}
