package com.faishalbadri.hijab.repository.ebook_category.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.data.PojoEbookCategory;
import com.faishalbadri.hijab.repository.ebook_category.EbookCategoryDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookCategoryDataRemote implements EbookCategoryDataResource {

  private static final String URL_CATEGORY_EBOOK = Server.BASE_URL + "getTbKategoriEbook.php";
  private Context context;

  public EbookCategoryDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getEbookCategoryList(@NonNull EbookCategoryGetCallBack ebookCategoryGetCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Request.Method.GET,
        String.valueOf(URL_CATEGORY_EBOOK),
        response -> {
          final PojoEbookCategory pojoEbookCategory = new Gson()
              .fromJson(response, PojoEbookCategory.class);
          Log.i("response", response);
          try {
            if (pojoEbookCategory == null) {
              ebookCategoryGetCallBack.onNullCategoryEbook("Internal Server error");
            } else {
              ebookCategoryGetCallBack.onSuccessCategoryEbook(pojoEbookCategory.getKategori_ebook(),
                  "Data Semua Kategori");
              Log.i(pojoEbookCategory.getKategori_ebook().toString(), "Data Semua Kategori");
            }
          } catch (Exception e) {

          }

        }, error -> ebookCategoryGetCallBack.onErrorCategoryEbook(String.valueOf(error)));
    requestQueue.add(stringRequest);
  }
}
