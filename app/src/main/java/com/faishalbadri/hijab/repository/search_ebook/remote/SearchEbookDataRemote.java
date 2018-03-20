package com.faishalbadri.hijab.repository.search_ebook.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.ebook.EbookItem;
import com.faishalbadri.hijab.data.ebook.EbookResponse;
import com.faishalbadri.hijab.repository.search_ebook.SearchEbookDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEbookDataRemote implements SearchEbookDataResource {

  private Context context;


  public SearchEbookDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSearchEbookResult(String key,
      @NonNull SearchEbookGetCallback searchEbookGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<EbookResponse> ebookResponseCall = apiInterface
        .searchEbook(key, DataUser.getInstance().getUserApiKey());
    ebookResponseCall.enqueue(new Callback<EbookResponse>() {
      @Override
      public void onResponse(Call<EbookResponse> call, Response<EbookResponse> response) {
        try {
          if (response.body().getEbook() == null) {
            searchEbookGetCallback.onWrongSearchEbook("Null");
          } else {
            EbookResponse ebookResponse = response.body();
            List<EbookItem> items = ebookResponse.getEbook();
            searchEbookGetCallback.onSuccesSearchEbook(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<EbookResponse> call, Throwable t) {
        searchEbookGetCallback.onErrorSearchEbook("Tidak ada Koneksi internet");
      }
    });
  }
}
