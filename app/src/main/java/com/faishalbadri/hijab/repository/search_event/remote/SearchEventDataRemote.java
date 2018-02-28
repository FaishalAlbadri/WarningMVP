package com.faishalbadri.hijab.repository.search_event.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.event.EventItem;
import com.faishalbadri.hijab.data.event.EventResponse;
import com.faishalbadri.hijab.repository.search_event.SearchEventDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEventDataRemote implements SearchEventDataResource {

  private Context context;

  public SearchEventDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSearchEventResult(String key,
      @NonNull SearchEventGetCallback searchEventGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<EventResponse> eventResponseCall = apiInterface
        .searchEvent(key, DataUser.getInstance().getUserApiKey());
    eventResponseCall.enqueue(new Callback<EventResponse>() {
      @Override
      public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
        try {
          if (response.body().getEvent() == null) {
            searchEventGetCallback.onWrongSearchEvent("Null");
          } else {
            EventResponse eventResponse = response.body();
            List<EventItem> items = eventResponse.getEvent();
            searchEventGetCallback.onSuccesSearchEvent(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<EventResponse> call, Throwable t) {
        searchEventGetCallback.onErrorSearchEvent("Tidak ada Koneksi internet");
      }
    });
  }
}
