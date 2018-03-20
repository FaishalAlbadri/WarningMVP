package com.faishalbadri.hijab.repository.ebook.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.ebook.with_category.EbookByCategoryResponse;
import com.faishalbadri.hijab.data.ebook.with_category.EbookCategoryItem;
import com.faishalbadri.hijab.repository.ebook.EbookDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class EbookDataRemote implements EbookDataResource {

  private Context context;

  public EbookDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEbookList(@NonNull EbookGetCallBack ebookGetCallBack) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<EbookByCategoryResponse> ebookByCategoryResponseCall = apiInterface
        .getEbook(DataUser.getInstance()
            .getUserApiKey());
    ebookByCategoryResponseCall.enqueue(new Callback<EbookByCategoryResponse>() {
      @Override
      public void onResponse(Call<EbookByCategoryResponse> call,
          Response<EbookByCategoryResponse> response) {
        try {
          if (response.body().getData().toString().equals("[]")) {
            ebookGetCallBack.onErrorEbook("Error");
          } else {
            EbookByCategoryResponse ebookResponse = response.body();
            List<EbookCategoryItem> items = ebookResponse.getData();
            ebookGetCallBack.onSuccessEbook(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<EbookByCategoryResponse> call, Throwable t) {
        ebookGetCallBack
            .onErrorEbook(context.getResources().getString(R.string.caption_error_internet_acces));
      }
    });
  }
}
