package com.faishalbadri.hijab.repository.event_by_city.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.event.EventItem;
import com.faishalbadri.hijab.data.event.EventResponse;
import com.faishalbadri.hijab.repository.event_by_city.EventByCityDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 11/6/17.
 */

public class EventByCityDataRemote implements EventByCityDataResource {

  private Context context;

  public EventByCityDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEventByCityResult(String id_city_event,
      @NonNull EventByCityGetCallback eventByCityGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<EventResponse> eventResponseCall = apiInterface
        .getEventByCity("event/" + id_city_event, DataUser
            .getInstance().getUserApiKey());
    eventResponseCall.enqueue(new Callback<EventResponse>() {
      @Override
      public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
        try {
          if (response.body().getEvent() == null) {
            eventByCityGetCallback.onErrorEventByCity("Data Null");
          } else {
            EventResponse eventResponse = response.body();
            List<EventItem> items = eventResponse.getEvent();
            eventByCityGetCallback.onSuccesEventByCity(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<EventResponse> call, Throwable t) {
        eventByCityGetCallback.onErrorEventByCity("Tidak ada Koneksi internet");
      }
    });
  }
}
