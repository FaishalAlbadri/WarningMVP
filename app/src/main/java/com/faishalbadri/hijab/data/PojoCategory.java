package com.faishalbadri.hijab.data;


import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class PojoCategory {

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


    private String category_id;
    private String category_name;
    private String category_image;

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

    public String getCategory_image() {
      return category_image;
    }

    public void setCategory_image(String category_image) {
      this.category_image = category_image;
    }
  }
}
