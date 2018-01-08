package com.faishalbadri.hijab.data;

import java.util.List;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class PojoEbookCategory {

  /**
   * error : false
   * message : ADA
   * ebook_categories : [{"ebook_category_id":1,"ebook_category_name":"Fantasi"},{"ebook_category_id":4,"ebook_category_name":"Horor"},{"ebook_category_id":3,"ebook_category_name":"Komedi"},{"ebook_category_id":2,"ebook_category_name":"Romance"}]
   */

  private boolean error;
  private String message;
  private List<EbookCategoriesBean> ebook_categories;

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

  public List<EbookCategoriesBean> getEbook_categories() {
    return ebook_categories;
  }

  public void setEbook_categories(List<EbookCategoriesBean> ebook_categories) {
    this.ebook_categories = ebook_categories;
  }

  public static class EbookCategoriesBean {

    /**
     * ebook_category_id : 1
     * ebook_category_name : Fantasi
     */

    private String ebook_category_id;
    private String ebook_category_name;

    public String getEbook_category_id() {
      return ebook_category_id;
    }

    public void setEbook_category_id(String ebook_category_id) {
      this.ebook_category_id = ebook_category_id;
    }

    public String getEbook_category_name() {
      return ebook_category_name;
    }

    public void setEbook_category_name(String ebook_category_name) {
      this.ebook_category_name = ebook_category_name;
    }
  }
}
