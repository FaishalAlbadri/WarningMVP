package com.faishalbadri.hijab.repository.ebook.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoEbook;
import com.faishalbadri.hijab.repository.ebook.EbookDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class EbookDataRemote implements EbookDataResource{

  private Context context;
  private static final String URL_EBOOK = Server.BASE_URL+"getTbEbook.php";

  public EbookDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEbookList(@NonNull EbookGetCallBack ebookGetCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL_EBOOK),
        response -> {
          final PojoEbook pojoEbook = new Gson().fromJson(response, PojoEbook.class);
          Log.i("response", response);
          if (pojoEbook == null) {
            ebookGetCallBack.onNullEbook("Internal Server error");
          } else {
            ebookGetCallBack.onSuccessEbook(pojoEbook.getEbook(), "Data Semua Ebook");
            Log.i(pojoEbook.getEbook().toString(), "Data Semua Ebook");
          }
        }, error -> ebookGetCallBack.onErrorEbook(String.valueOf(error)));
    requestQueue.add(stringRequest);
  }
}
