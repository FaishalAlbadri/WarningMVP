package com.faishalbadri.hijab.repository.detail_video_related.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.videos.VideosItem;
import com.faishalbadri.hijab.data.videos.VideosResponse;
import com.faishalbadri.hijab.repository.detail_video_related.DetailVideoDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailVideoDataRemote implements DetailVideoDataResource {

  private Context context;

  public DetailVideoDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getDetailVideo(@NonNull DetailVideoGetDataCallBack
      detailVideoGetDataCallBack) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<VideosResponse> videosResponseCall = apiInterface
        .getVideos("videos?limit=4", DataUser.getInstance().getUserApiKey());
    videosResponseCall.enqueue(new Callback<VideosResponse>() {
      @Override
      public void onResponse(Call<VideosResponse> call, Response<VideosResponse> response) {
        try {
          if (response.body().getVideos().toString().equals("[]")) {
            detailVideoGetDataCallBack.onError("Error");
          } else {
            VideosResponse videosResponse = response.body();
            List<VideosItem> items = videosResponse.getVideos();
            detailVideoGetDataCallBack.onSuccessDetailVideo(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<VideosResponse> call, Throwable t) {
        detailVideoGetDataCallBack
            .onError(context.getResources().getString(R.string.caption_error_internet_acces));
      }
    });
  }
}
