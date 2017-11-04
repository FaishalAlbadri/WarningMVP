package com.faishalbadri.hijab.repository.category_video.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoCategory;
import com.faishalbadri.hijab.data.PojoEbook;
import com.faishalbadri.hijab.repository.category_video.CategoryVideoDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by fikriimaduddin on 11/4/17.
 */

public class CategoryVideoDataRemote implements CategoryVideoDataResource{

  Context context;
  private static final String URL = Server.BASE_URL + "getTbKategori.php";

  public CategoryVideoDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getCategoryVideoList(@NonNull CategoryVideoGetCallBack CategoryVideoGetCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(
        Method.GET, String.valueOf(URL), response -> {
          try {
            if (String.valueOf(new JSONObject(response).getString("msg")).equals("Data Semua Kategori")) {
              try {
                Log.i("Response",response);
                PojoCategory pojoCategory = new Gson().fromJson(response,PojoCategory.class);
                CategoryVideoGetCallBack.onSuccessCategoryVideo(pojoCategory.getKategori(),context.getString(
                    R.string.text_succes));
              } catch (Exception e) {
                e.printStackTrace();
              }
            } else {
              CategoryVideoGetCallBack.onErrorCategoryVideo(context.getString(R.string.text_error));
            }
          } catch (JSONException e) {

          } catch (Exception e) {

          }

        }, error -> CategoryVideoGetCallBack.onErrorCategoryVideo(String.valueOf(error)));
    requestQueue.add(stringRequest);
  }
}
