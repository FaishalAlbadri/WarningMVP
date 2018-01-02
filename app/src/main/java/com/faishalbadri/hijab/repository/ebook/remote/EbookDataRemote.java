package com.faishalbadri.hijab.repository.ebook.remote;

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

  public EbookDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEbookList(@NonNull EbookGetCallBack ebookGetCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL),
        response -> {
          Log.i("response", response);
          final PojoEbook pojoEbook = new Gson().fromJson(response, PojoEbook.class);
          try {
            if (pojoEbook == null) {
              ebookGetCallBack.onNullEbook("Error");
            } else {
              ebookGetCallBack
                  .onSuccessEbook(pojoEbook.getEbook(), "Ok");
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
