package com.faishalbadri.hijab.repository.category.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.hijab.R;
import com.faishalbadri.hijab.data.PojoCategory;
import com.faishalbadri.hijab.repository.category.CategoryDataResource;
import com.faishalbadri.hijab.util.Server;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 11/4/17.
 */

public class CategoryDataRemote implements CategoryDataResource {

  Context context;
  private static final String URL = Server.BASE_URL + "getTbKategori.php";


  public CategoryDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getCategoryResult(@NonNull CategoryGetCallback categoryGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(Method.GET, String.valueOf(URL), new Listener<String>() {
      @Override
      public void onResponse(String response) {
        try {
          if (String.valueOf(new JSONObject(response).getString("msg")).equals("Data Semua Kategori")) {
            try {
              Log.i("Response",response);
              PojoCategory pojoCategory = new Gson().fromJson(response,PojoCategory.class);
              categoryGetCallback.onSuccesCategory(pojoCategory.getKategori(),context.getString(R.string.text_succes));
            } catch (Exception e) {
              e.printStackTrace();
            }
          } else {
            categoryGetCallback.onErrorCategory(context.getString(R.string.text_error));
          }
        } catch (JSONException e) {

        } catch (Exception e) {

        }

      }
    }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        categoryGetCallback.onErrorCategory(String.valueOf(error));
      }
    });
    requestQueue.add(stringRequest);
  }
}
