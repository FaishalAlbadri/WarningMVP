package com.faishalbadri.hijab.repository.video.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.videos.VideosItem;
import com.faishalbadri.hijab.data.videos.VideosResponse;
import com.faishalbadri.hijab.repository.video.VideoDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoDataRemote implements VideoDataResource {

  private Context context;

  public VideoDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getVideoList(int PAGE, @NonNull VideoGetCallBack videoGetCallBack) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<VideosResponse> videosResponseCall = apiInterface
        .getVideos("videos?page=" + PAGE, DataUser.getInstance().getUserApiKey());
    videosResponseCall.enqueue(new Callback<VideosResponse>() {
      @Override
      public void onResponse(Call<VideosResponse> call, Response<VideosResponse> response) {
        try {
          if (response.body().getVideos().toString().equals("[]")) {
            videoGetCallBack.onErrorVideo("Data Null");
          } else {
            VideosResponse videosResponse = response.body();
            List<VideosItem> items = videosResponse.getVideos();
            videoGetCallBack.onSuccessVideo(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<VideosResponse> call, Throwable t) {
        if (PAGE == 1) {
          videoGetCallBack.onErrorVideo(
              context.getResources().getString(R.string.caption_error_internet_acces));
        } else if (PAGE > 1) {
          videoGetCallBack.onErrorVideo("Data Pagination Error");
        }
      }
    });
  }
}
