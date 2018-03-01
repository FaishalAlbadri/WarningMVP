package com.faishalbadri.hijab.repository.video_by_category.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.videos.VideosItem;
import com.faishalbadri.hijab.data.videos.VideosResponse;
import com.faishalbadri.hijab.repository.video_by_category.VideoByCategoryDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoByCategoryRemote implements VideoByCategoryDataResource {

  private Context context;

  public VideoByCategoryRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getVideoByCategoryGetDataCallBack(String id,
      @NonNull VideoByCategoryGetDataCallBack videoByCategoryGetDataCallBack) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<VideosResponse> videosResponseCall = apiInterface
        .getVideos("videos/" + id, DataUser.getInstance().getUserApiKey());
    videosResponseCall.enqueue(new Callback<VideosResponse>() {
      @Override
      public void onResponse(Call<VideosResponse> call, Response<VideosResponse> response) {
        try {
          if (response.body().getVideos() == null) {
            videoByCategoryGetDataCallBack.onErrorVideoByCategory("Data Null");
          } else {
            VideosResponse videosResponse = response.body();
            List<VideosItem> items = videosResponse.getVideos();
            videoByCategoryGetDataCallBack.onSuccessVideoByCategory(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<VideosResponse> call, Throwable t) {
        videoByCategoryGetDataCallBack.onErrorVideoByCategory(
            context.getResources().getString(R.string.caption_error_internet_acces));
      }
    });
  }
}
