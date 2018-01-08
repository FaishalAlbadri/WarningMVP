package com.faishalbadri.hijab.data;


import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class PojoCategory {

  /**
   * error : false
   * message : ADA
   * categories : [{"category_id":5,"category_name":"Beauty"},{"category_id":10,"category_name":"Cerpen"},{"category_id":3,"category_name":"Community"},{"category_id":21,"category_name":"Event Update"},{"category_id":6,"category_name":"Fashion"},{"category_id":15,"category_name":"Financial"},{"category_id":4,"category_name":"Global Muslim"},{"category_id":16,"category_name":"Kesehatan"},{"category_id":12,"category_name":"Kisahmu"},{"category_id":20,"category_name":"Konsultasi"},{"category_id":23,"category_name":"Kuliner"},{"category_id":8,"category_name":"LifeStyle"},{"category_id":14,"category_name":"Motivation"},{"category_id":17,"category_name":"Music,Film,Buku"},{"category_id":1,"category_name":"Muslimah Inspiratif"},{"category_id":2,"category_name":"Muslimah World"},{"category_id":31,"category_name":"Pinky Story"},{"category_id":24,"category_name":"Referensi"},{"category_id":22,"category_name":"Resep"},{"category_id":13,"category_name":"Selebritis"},{"category_id":18,"category_name":"Sport"},{"category_id":19,"category_name":"Teknologi"},{"category_id":9,"category_name":"Travel"}]
   */

  private boolean error;
  private String message;
  private List<CategoriesBean> categories;

  public boolean isError() {
    return error;
  }

  public void setError(boolean error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<CategoriesBean> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoriesBean> categories) {
    this.categories = categories;
  }

  public static class CategoriesBean {

    /**
     * category_id : 5
     * category_name : Beauty
     */

    private String category_id;
    private String category_name;

    public String getCategory_id() {
      return category_id;
    }

    public void setCategory_id(String category_id) {
      this.category_id = category_id;
    }

    public String getCategory_name() {
      return category_name;
    }

    public void setCategory_name(String category_name) {
      this.category_name = category_name;
    }
  }
}
