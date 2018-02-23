package com.faishalbadri.hijab.api;

import com.faishalbadri.hijab.util.server.Server;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by faishal on 23/02/18.
 */

public class APIClient {

  private static Retrofit retrofit = null;

  public static Retrofit getRetrofit() {

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    retrofit = new Retrofit.Builder()
        .baseUrl(Server.BASE_URL_REVAMP)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build();

    return retrofit;
  }

}
