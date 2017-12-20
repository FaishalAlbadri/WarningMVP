package com.faishalbadri.hijab.revamp.repository.category.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.revamp.data.PojoCategory;
import com.faishalbadri.hijab.revamp.repository.category.CategoryDataResource;
import com.faishalbadri.hijab.revamp.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 11/4/17.
 */

public class CategoryDataRemote implements CategoryDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "categories";
  Context context;


  public CategoryDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getCategoryResult(@NonNull CategoryGetCallback categoryGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
          Log.i("response", response);
          final PojoCategory pojoCategory = new Gson().fromJson(response, PojoCategory.class);
          try {
            if (pojoCategory == null) {
              categoryGetCallback.onErrorCategory("Error");
            } else {
              categoryGetCallback.onSuccesCategory(pojoCategory.getCategories(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> categoryGetCallback.onErrorCategory(String.valueOf(error))) {
      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Authorization", "57b44757920f9b2544cd57f1d998e7f7");
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
