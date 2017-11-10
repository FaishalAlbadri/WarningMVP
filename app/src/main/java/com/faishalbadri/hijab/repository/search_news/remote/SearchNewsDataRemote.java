package com.faishalbadri.hijab.repository.search_news.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoEbook;
import com.faishalbadri.hijab.data.PojoNews;
import com.faishalbadri.hijab.repository.search_news.SearchNewsDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 10/11/17.
 */

public class SearchNewsDataRemote implements SearchNewsDataResource {

  Context context;
  private static final String URL = Server.BASE_URL + "searchNews.php";

  public SearchNewsDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getSearchNewsResult(String key,
      @NonNull SearchNewsGetCallback searchNewsGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.POST, String.valueOf(URL), response -> {
      try {
        if (String.valueOf(new JSONObject(response).getString("msg")).equals("Data Semua Search")) {
          try {
            PojoNews pojoNews = new Gson().fromJson(response, PojoNews.class);
            searchNewsGetCallback
                .onSuccesSearchNews(pojoNews.getIsi(), context.getString(R.string.text_succes));
          } catch (Exception e) {
            e.printStackTrace();
          }
        } else {
          searchNewsGetCallback.onWrongSearchNews(context.getString(R.string.text_error));
        }
      } catch (JSONException e) {

      } catch (Exception e) {

      }

    }, error -> searchNewsGetCallback.onErrorSearchNews(String.valueOf(error))) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<>();
        params.put("key", key);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
