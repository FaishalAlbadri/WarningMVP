package com.faishalbadri.hijab.repository.ebook.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEbookWithCategory;
import com.faishalbadri.hijab.repository.ebook.EbookDataResource;
import com.faishalbadri.hijab.util.Singleton.DataUser;
import com.faishalbadri.hijab.util.server.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class EbookDataRemote implements EbookDataResource {

  private static final String URL = Server.BASE_URL_REVAMP + "ebook";
  private Context context;
  private RequestQueue requestQueue;


  public EbookDataRemote(Context context) {
    this.context = context;
    requestQueue = Volley.newRequestQueue(context);
  }

  @Override
  public void getEbookList(@NonNull EbookGetCallBack ebookGetCallBack) {
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
          final PojoEbookWithCategory pojoEbookWithCategory = new Gson()
              .fromJson(response, PojoEbookWithCategory.class);
          try {
            if (pojoEbookWithCategory.getData().toString().equals("[]")) {
              ebookGetCallBack.onErrorEbook("Error");
            } else {
              ebookGetCallBack
                  .onSuccessEbook(pojoEbookWithCategory.getData(), "Ok");
            }
          } catch (Exception e) {

          }
        }, error -> ebookGetCallBack
        .onErrorEbook(context.getResources().getString(R.string.caption_error_internet_acces))) {
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
