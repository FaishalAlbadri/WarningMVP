package com.faishalbadri.hijab.api;

import com.faishalbadri.hijab.data.ResponseRegister;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by faishal on 23/02/18.
 */

public interface APIInterface {

  @FormUrlEncoded
  @POST("user/new")
  Call<ResponseRegister> getRegister(
      @Field("username") String username,
      @Field("email") String email,
      @Field("password") String password,
      @Field("verify_code") String verify_code);
}
