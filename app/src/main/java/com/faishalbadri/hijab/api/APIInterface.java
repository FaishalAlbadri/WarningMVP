package com.faishalbadri.hijab.api;

import com.faishalbadri.hijab.data.categories.CategoriesResponse;
import com.faishalbadri.hijab.data.city.CityResponse;
import com.faishalbadri.hijab.data.ebook.EbookResponse;
import com.faishalbadri.hijab.data.ebook.with_category.EbookByCategoryResponse;
import com.faishalbadri.hijab.data.event.EventResponse;
import com.faishalbadri.hijab.data.news.NewsResponse;
import com.faishalbadri.hijab.data.response.GlobalResponse;
import com.faishalbadri.hijab.data.session.SessionResponse;
import com.faishalbadri.hijab.data.slider.SliderResponse;
import com.faishalbadri.hijab.data.sponsor.SponsorResponse;
import com.faishalbadri.hijab.data.user.UserResponse;
import com.faishalbadri.hijab.data.videos.VideosResponse;
import com.faishalbadri.hijab.data.voting.VotingResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by faishal on 23/02/18.
 */
public interface APIInterface {

  /**
   * Gets register.
   *
   * @param username the username
   * @param email the email
   * @param password the password
   * @param verify_code the verify code
   * @return the register
   */
  @FormUrlEncoded
  @POST("user/new")
  Call<GlobalResponse> getRegister(
      @Field("username") String username,
      @Field("email") String email,
      @Field("password") String password,
      @Field("verify_code") String verify_code);

  /**
   * Gets login.
   *
   * @param username the username
   * @param password the password
   * @return the login
   */
  @FormUrlEncoded
  @POST("loginuser")
  Call<UserResponse> getLogin(
      @Field("username") String username,
      @Field("password") String password);

  /**
   * Change password user call.
   *
   * @param id_user the id user
   * @param password the password
   * @return the call
   */
  @FormUrlEncoded
  @POST("user/change/password")
  Call<GlobalResponse> changePasswordUser(
      @Field("user_id") String id_user,
      @Field("password") String password);

  /**
   * Verify code call.
   *
   * @param user_id the user id
   * @param verify_code the verify code
   * @return the call
   */
  @FormUrlEncoded
  @POST("verifycode")
  Call<GlobalResponse> verifyCode(
      @Field("user_id") String user_id,
      @Field("verify_code") String verify_code);

  /**
   * Gets session.
   *
   * @param user_id the user id
   * @param voting_id the voting id
   * @param apikey the apikey
   * @return the session
   */
  @FormUrlEncoded
  @POST("session")
  Call<SessionResponse> getSession(
      @Field("user_id") String user_id,
      @Field("voting_id") String voting_id,
      @Header("Authorization") String apikey);

  /**
   * Gets voting vote.
   *
   * @param user_id the user id
   * @param voting_id the voting id
   * @param type the type
   * @param voting_session_id the voting session id
   * @param apikey the apikey
   * @return the voting vote
   */
  @FormUrlEncoded
  @POST("voting/vote")
  Call<GlobalResponse> getVotingVote(
      @Field("user_id") String user_id,
      @Field("voting_id") String voting_id,
      @Field("type") String type,
      @Field("voting_session_id") String voting_session_id,
      @Header("Authorization") String apikey);

  /**
   * Search ebook call.
   *
   * @param query the query
   * @param apikey the apikey
   * @return the call
   */
  @FormUrlEncoded
  @POST("ebook/find")
  Call<EbookResponse> searchEbook(
      @Field("query") String query,
      @Header("Authorization") String apikey);

  /**
   * Search videos call.
   *
   * @param query the query
   * @param apikey the apikey
   * @return the call
   */
  @FormUrlEncoded
  @POST("videos/find")
  Call<VideosResponse> searchVideos(
      @Field("query") String query,
      @Header("Authorization") String apikey);

  /**
   * Search news call.
   *
   * @param query the query
   * @param apikey the apikey
   * @return the call
   */
  @FormUrlEncoded
  @POST("newsfeed/find")
  Call<NewsResponse> searchNews(
      @Field("query") String query,
      @Header("Authorization") String apikey);

  /**
   * Search event call.
   *
   * @param query the query
   * @param apikey the apikey
   * @return the call
   */
  @FormUrlEncoded
  @POST("event/find")
  Call<EventResponse> searchEvent(
      @Field("query") String query,
      @Header("Authorization") String apikey);

  /**
   * Gets categories.
   *
   * @param apikey the apikey
   * @return the categories
   */
  @GET("categories")
  Call<CategoriesResponse> getCategories(@Header("Authorization") String apikey);

  /**
   * Gets city.
   *
   * @param apikey the apikey
   * @return the city
   */
  @GET("event_city")
  Call<CityResponse> getCity(@Header("Authorization") String apikey);

  /**
   * Gets slider.
   *
   * @param apikey the apikey
   * @return the slider
   */
  @GET("slider")
  Call<SliderResponse> getSlider(@Header("Authorization") String apikey);

  /**
   * Gets sponsor.
   *
   * @param apikey the apikey
   * @return the sponsor
   */
  @GET("sponsor")
  Call<SponsorResponse> getSponsor(@Header("Authorization") String apikey);

  /**
   * Gets event.
   * Gets event by cities
   *
   * @param url the url
   * @param apikey the apikey
   * @return the event
   */
  @GET
  Call<EventResponse> getEvent(@Url String url, @Header("Authorization") String apikey);

  /**
   * Gets all ebook.
   * Gets ebook by category.
   *
   * @param url the url
   * @param apikey the apikey
   * @return the ebook by category
   */
  @GET
  Call<EbookResponse> getEbook(@Url String url, @Header("Authorization") String apikey);

  @GET("ebook")
  Call<EbookByCategoryResponse> getEbook(@Header("Authorization") String apikey);


  /**
   * Gets voting.
   *
   * @param url the url
   * @param apikey the apikey
   * @return the voting
   */
  @GET
  Call<VotingResponse> getVoting(@Url String url, @Header("Authorization") String apikey);


  /**
   * Gets videos (videos?page=)
   * Gets videos limit (videos?limit=)
   * Gets videos by categories (videos/)
   *
   * @param url the url
   * @param apikey the apikey
   * @return the videos
   */
  @GET
  Call<VideosResponse> getVideos(@Url String url, @Header("Authorization") String apikey);

  /**
   * Gets all news (newsfeed?page=)
   * Gets detail news (newsfeed/detail/)
   * Gets news by category (newsfeed/)
   * Gets popular news (newsfeed/popular)
   * Gets News limit (newsfeed?limit=)
   *
   * @param url the url newsfeed
   * @param apikey the apikey
   * @return the news
   */
  @GET
  Call<NewsResponse> getNews(@Url String url, @Header("Authorization") String apikey);

}
