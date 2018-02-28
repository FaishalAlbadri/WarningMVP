package com.faishalbadri.hijab.repository.slider_home.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.slider.SliderItem;
import com.faishalbadri.hijab.data.slider.SliderResponse;
import com.faishalbadri.hijab.repository.slider_home.SliderHomeDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 20/12/17.
 */

public class SliderHomeDataRemote implements SliderHomeDataResource {

  private Context context;

  public SliderHomeDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSliderHomeResult(@NonNull SliderHomeGetCallback sliderHomeGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<SliderResponse> sliderResponseCall = apiInterface
        .getSlider(DataUser.getInstance().getUserApiKey());
    sliderResponseCall.enqueue(new Callback<SliderResponse>() {
      @Override
      public void onResponse(Call<SliderResponse> call, Response<SliderResponse> response) {
        try {
          if (response.body().getSlider() == null) {
            sliderHomeGetCallback.onErrorSliderHome("Error");
          } else {
            SliderResponse sliderResponse = response.body();
            List<SliderItem> items = sliderResponse.getSlider();
            sliderHomeGetCallback.onSuccesSliderHome(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<SliderResponse> call, Throwable t) {
        sliderHomeGetCallback.onErrorSliderHome("Tidak ada koneksi internet");
      }
    });
  }
}
