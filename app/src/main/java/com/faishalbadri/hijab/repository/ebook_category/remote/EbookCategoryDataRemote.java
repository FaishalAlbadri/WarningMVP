package com.faishalbadri.hijab.repository.ebook_category.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoEbookCategory;
import com.faishalbadri.hijab.repository.ebook_category.EbookCategoryDataResource;
import com.faishalbadri.hijab.util.ApiKey;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookCategoryDataRemote implements EbookCategoryDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "ebook_categories";
  private Context context;

  public EbookCategoryDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEbookCategoryList(@NonNull EbookCategoryGetCallBack ebookCategoryGetCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
          Log.i("response", response);
          final PojoEbookCategory pojoEbookCategory = new Gson()
              .fromJson(response, PojoEbookCategory.class);
          try {
            if (pojoEbookCategory == null) {
              ebookCategoryGetCallBack.onNullCategoryEbook("Error");
            } else {
              ebookCategoryGetCallBack
                  .onSuccessCategoryEbook(pojoEbookCategory.getEbook_categories(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> ebookCategoryGetCallBack.onErrorCategoryEbook(String.valueOf(error))) {
      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Authorization", ApiKey.getInstance(context).getApiKey());
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
