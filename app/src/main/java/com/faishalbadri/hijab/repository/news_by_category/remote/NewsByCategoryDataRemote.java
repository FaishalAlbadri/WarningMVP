package com.faishalbadri.hijab.repository.news_by_category.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.repository.news_by_category.NewsByCategoryDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 11/4/17.
 */

public class NewsByCategoryDataRemote implements NewsByCategoryDataResource {

  Context context;
  private static final String URL = Server.BASE_URL+"getTbIsiPerKategori.php";

  public NewsByCategoryDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getNewsByCategoryGetDataCallBack(String id,
      @NonNull NewsByCategoryGetDataCallBack newsByCategoryGetDataCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL), response -> {
      try {
        if (String.valueOf(new JSONObject(response).getString("msg")).equals("Data Semua Isi")) {
          try {
            Log.i("Response",response);
            PojoNews pojoNews = new Gson().fromJson(response,PojoNews.class);
            newsByCategoryGetDataCallBack.onSuccessNewsByCategory(pojoNews.getIsi(),context.getString(R.string.text_succes));
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else {
          newsByCategoryGetDataCallBack.onErrorNewsByCategory(context.getString(R.string.text_error));
        }
      } catch (JSONException e) {

      } catch (Exception e) {

      }

    }, error -> newsByCategoryGetDataCallBack.onErrorNewsByCategory(String.valueOf(error)))
    {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<>();
        params.put("id_kategori", id);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
