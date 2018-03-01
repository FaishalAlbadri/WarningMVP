package com.faishalbadri.hijab.repository.search_video.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.videos.VideosItem;
import com.faishalbadri.hijab.data.videos.VideosResponse;
import com.faishalbadri.hijab.repository.search_video.SearchVideoDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchVideoDataRemote implements SearchVideoDataResource {

  private Context context;

  public SearchVideoDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSearchVideoResult(String key,
      @NonNull SearchVideoGetCallback searchVideoGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<VideosResponse> videosResponseCall = apiInterface
        .searchVideos(key, DataUser.getInstance().getUserApiKey());
    videosResponseCall.enqueue(new Callback<VideosResponse>() {
      @Override
      public void onResponse(Call<VideosResponse> call, Response<VideosResponse> response) {
        try {
          if (response.body().getVideos() == null) {
            searchVideoGetCallback.onWrongSearchVideo("Null");
          } else {
            VideosResponse videosResponse = response.body();
            List<VideosItem> items = videosResponse.getVideos();
            searchVideoGetCallback.onSuccesSearchVideo(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<VideosResponse> call, Throwable t) {
        searchVideoGetCallback.onErrorSearchVideo(
            context.getResources().getString(R.string.caption_error_internet_acces));
      }
    });
  }
}
