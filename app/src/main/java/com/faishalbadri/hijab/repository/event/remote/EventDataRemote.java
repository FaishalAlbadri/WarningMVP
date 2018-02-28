package com.faishalbadri.hijab.repository.event.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.event.EventItem;
import com.faishalbadri.hijab.data.event.EventResponse;
import com.faishalbadri.hijab.repository.event.EventDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 11/6/17.
 */

public class EventDataRemote implements EventDataResource {

  private Context context;


  public EventDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEventResult(int PAGE, @NonNull EventGetCallback eventGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<EventResponse> eventResponseCall = apiInterface
        .getEvent("event?page=" + PAGE, DataUser.getInstance().getUserApiKey());
    eventResponseCall.enqueue(new Callback<EventResponse>() {
      @Override
      public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
        try {
          if (response.body().getEvent().toString().equals("[]")) {
            eventGetCallback.onErrorEvent("Data Null");
          } else {
            EventResponse eventResponse = response.body();
            List<EventItem> items = eventResponse.getEvent();
            eventGetCallback.onSuccesEvent(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<EventResponse> call, Throwable t) {
        if (PAGE == 1) {
          eventGetCallback.onErrorEvent(
              context.getResources().getString(R.string.caption_error_internet_acces));
        } else if (PAGE > 1) {
          eventGetCallback.onErrorEvent("Data Pagination Error");
        }
      }
    });
  }
}
