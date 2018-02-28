package com.faishalbadri.hijab.repository.ebook_by_category.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.ebook.EbookItem;
import com.faishalbadri.hijab.data.ebook.EbookResponse;
import com.faishalbadri.hijab.repository.ebook_by_category.EbookByCategoryDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EbookByCategoryDataRemote implements EbookByCategoryDataResource {

  private Context context;


  public EbookByCategoryDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getByCategoryGetDataCallBack(String id,
      @NonNull EbookByCategoryDataCallBack newsByCategoryGetDataCallBack) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<EbookResponse> ebookResponseCall = apiInterface
        .getEbookByCategory("ebook/" + id, DataUser.getInstance().getUserApiKey());
    ebookResponseCall.enqueue(new Callback<EbookResponse>() {
      @Override
      public void onResponse(Call<EbookResponse> call, Response<EbookResponse> response) {
        try {
          if (response.body().getEbook() == null) {
            newsByCategoryGetDataCallBack.onErrorEbookByCategory("Error");
          } else {
            EbookResponse ebookResponse = response.body();
            List<EbookItem> items = ebookResponse.getEbook();
            newsByCategoryGetDataCallBack.onSuccessEbookByCategory(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<EbookResponse> call, Throwable t) {
        newsByCategoryGetDataCallBack.onErrorEbookByCategory("Tidak ada koneksi internet");
      }
    });
  }
}
