package com.faishalbadri.hijab.repository.category_video.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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

  private Context context;
  private static final String URL_CATEGORY_VIDEO = Server.BASE_URL+"getTbEbook.php";

  public CategoryVideoDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getCategoryVideoList(@NonNull CategoryVideoGetCallBack CategoryVideoGetCallBack) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Request.Method.GET, String.valueOf(URL_CATEGORY_VIDEO),
        response -> {
          try {
            if (String.valueOf(new JSONObject(response).getString("msg")).equals("Data Semua Ebook")) {
              try {
                final PojoEbook pojoKategori = new Gson().fromJson(response, PojoEbook.class);
                  CategoryVideoGetCallBack.onSuccessCategoryVideo(pojoKategori.getEbook(), "Success");
              } catch (Exception e) {
                e.printStackTrace();
              }
            }
          } catch (JSONException e) {

          }
        }
        , error -> CategoryVideoGetCallBack.onErrorCategoryVideo(String.valueOf(error)));
    requestQueue.add(stringRequest);
  }
}
