package com.faishalbadri.hijab.repository.search_ebook.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEbook;
import com.faishalbadri.hijab.repository.search_ebook.SearchEbookDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchEbookDataRemote implements SearchEbookDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "ebook/find";
  Context context;


  public SearchEbookDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSearchEbookResult(String key,
      @NonNull SearchEbookGetCallback searchEbookGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL),
        response -> {
          Log.i("response", response);
          final PojoEbook pojoEbook = new Gson().fromJson(response, PojoEbook.class);
          try {
            if (pojoEbook == null) {
              searchEbookGetCallback.onWrongSearchEbook("Null");
            } else {
              searchEbookGetCallback
                  .onSuccesSearchEbook(pojoEbook.getEbook(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> searchEbookGetCallback.onErrorSearchEbook(context.getResources().getString(R
        .string.caption_error_internet_acces))) {

      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("query", key);
        return params;
      }

      @Override
      public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Authorization", DataUser.getInstance().getUserApiKey());
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
