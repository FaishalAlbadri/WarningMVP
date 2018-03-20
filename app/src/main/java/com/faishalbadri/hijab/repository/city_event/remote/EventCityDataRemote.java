package com.faishalbadri.hijab.repository.city_event.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.city.CityItem;
import com.faishalbadri.hijab.data.city.CityResponse;
import com.faishalbadri.hijab.repository.city_event.EventCityDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 11/6/17.
 */

public class EventCityDataRemote implements EventCityDataResource {

  private Context context;

  public EventCityDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEventCityResult(@NonNull EventCityGetCallback eventCityGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<CityResponse> cityResponseCall = apiInterface
        .getCity(DataUser.getInstance().getUserApiKey());
    cityResponseCall.enqueue(new Callback<CityResponse>() {
      @Override
      public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {
        try {
          if (response.body().getEventCity().toString().equals("[]")) {
            eventCityGetCallback.onErrorEventCity("Error");
          } else {
            CityResponse cityResponse = response.body();
            List<CityItem> items = cityResponse.getEventCity();
            eventCityGetCallback.onSuccesEventCity(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<CityResponse> call, Throwable t) {
        eventCityGetCallback.onErrorEventCity("Tidak ada koneksi internet");
      }
    });
  }
}
