package com.faishalbadri.hijab.repository.ebook_by_category.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEbook;
import com.faishalbadri.hijab.repository.ebook_by_category.EbookByCategoryDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookByCategoryDataRemote implements EbookByCategoryDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "ebook/";
  private Context context;
  private RequestQueue requestQueue;


  public EbookByCategoryDataRemote(Context context) {
    this.context = context;
    requestQueue = Volley.newRequestQueue(context);
  }

  @Override
  public void getByCategoryGetDataCallBack(String id,
      @NonNull EbookByCategoryDataCallBack newsByCategoryGetDataCallBack) {
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL + id),
        response -> {
          final PojoEbook pojoEbook = new Gson().fromJson(response, PojoEbook.class);
          try {
            if (pojoEbook.getEbook() == null) {
              newsByCategoryGetDataCallBack.onErrorEbookByCategory("Error");
            } else {
              newsByCategoryGetDataCallBack
                  .onSuccessEbookByCategory(pojoEbook.getEbook(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> newsByCategoryGetDataCallBack.onErrorEbookByCategory(
        context.getResources().getString(R.string.caption_error_internet_acces))) {
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
