package com.faishalbadri.hijab.repository.ebook_by_category.remote;

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
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.repository.ebook_by_category.EbookByCategoryDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class EbookByCategoryDataRemote implements EbookByCategoryDataResource {

  Context context;
  private static final String URL = Server.BASE_URL+"getTbEbookPerKategori.php";

  public EbookByCategoryDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getByCategoryGetDataCallBack(String id,
      @NonNull EbookByCategoryDataCallBack newsByCategoryGetDataCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL), response -> {
      try {
        if (String.valueOf(new JSONObject(response).getString("msg")).equals("Data Semua ebook")) {
          try {
            Log.i("Response",response);
            PojoEbook pojoEbook = new Gson().fromJson(response,PojoEbook.class);
            newsByCategoryGetDataCallBack.onSuccessEbookByCategory(pojoEbook.getEbook(),context.getString(
                R.string.text_succes));
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else {
          newsByCategoryGetDataCallBack.onErrorEbookByCategory(context.getString(R.string.text_error));
        }
      } catch (JSONException e) {

      } catch (Exception e) {

      }

    }, error -> newsByCategoryGetDataCallBack.onErrorEbookByCategory(String.valueOf(error)))
    {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<>();
        params.put("id_kategori_ebook", id);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
