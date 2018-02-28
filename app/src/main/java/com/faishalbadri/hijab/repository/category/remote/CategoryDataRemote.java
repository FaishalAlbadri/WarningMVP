package com.faishalbadri.hijab.repository.category.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.faishalbadri.hijab.api.APIClient;
import com.faishalbadri.hijab.api.APIInterface;
import com.faishalbadri.hijab.data.categories.CategoriesItem;
import com.faishalbadri.hijab.data.categories.CategoriesResponse;
import com.faishalbadri.hijab.repository.category.CategoryDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by faishal on 11/4/17.
 */

public class CategoryDataRemote implements CategoryDataResource {

  private Context context;


  public CategoryDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getCategoryResult(@NonNull CategoryGetCallback categoryGetCallback) {
    APIInterface apiInterface = APIClient.getRetrofit().create(APIInterface.class);
    final Call<CategoriesResponse> categoriesResponseCall = apiInterface
        .getCategories(DataUser.getInstance().getUserApiKey());
    categoriesResponseCall.enqueue(new Callback<CategoriesResponse>() {
      @Override
      public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
        try {
          if (response.body().getCategories().toString().equals("[]")) {
            categoryGetCallback.onErrorCategory("Error");
          } else {
            CategoriesResponse categoriesResponse = response.body();
            List<CategoriesItem> items = categoriesResponse.getCategories();
            categoryGetCallback.onSuccesCategory(items, "Ok");
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<CategoriesResponse> call, Throwable t) {
        categoryGetCallback.onErrorCategory("Tidak ada koneksi internet");
      }
    });
  }
}
