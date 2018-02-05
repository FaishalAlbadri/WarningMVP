package com.faishalbadri.hijab.data;

import java.util.List;

/**
 * Created by faishal on 01/02/18.
 */

public class PojoEbookWithCategory {

  private boolean error;
  private String message;
  private List<DataBean> data;

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

  public List<DataBean> getData() {
    return data;
  }

  public void setData(List<DataBean> data) {
    this.data = data;
  }

  public static class DataBean {

    private String ebook_category_id;
    private String ebook_category_name;
    private List<EbookBean> ebook;

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

    public List<EbookBean> getEbook() {
      return ebook;
    }

    public void setEbook(List<EbookBean> ebook) {
      this.ebook = ebook;
    }

    public static class EbookBean {

      private String id_ebook;
      private String id_ebook_category;
      private String ebook_title;
      private String ebook_writer;
      private String ebook_publisher;
      private String ebook_released;
      private String ebook_image;
      private String ebook_description;
      private String ebook_link;
      private String ebook_category_title;

      public String getId_ebook() {
        return id_ebook;
      }

      public void setId_ebook(String id_ebook) {
        this.id_ebook = id_ebook;
      }

      public String getId_ebook_category() {
        return id_ebook_category;
      }

      public void setId_ebook_category(String id_ebook_category) {
        this.id_ebook_category = id_ebook_category;
      }

      public String getEbook_title() {
        return ebook_title;
      }

      public void setEbook_title(String ebook_title) {
        this.ebook_title = ebook_title;
      }

      public String getEbook_writer() {
        return ebook_writer;
      }

      public void setEbook_writer(String ebook_writer) {
        this.ebook_writer = ebook_writer;
      }

      public String getEbook_publisher() {
        return ebook_publisher;
      }

      public void setEbook_publisher(String ebook_publisher) {
        this.ebook_publisher = ebook_publisher;
      }

      public String getEbook_released() {
        return ebook_released;
      }

      public void setEbook_released(String ebook_released) {
        this.ebook_released = ebook_released;
      }

      public String getEbook_image() {
        return ebook_image;
      }

      public void setEbook_image(String ebook_image) {
        this.ebook_image = ebook_image;
      }

      public String getEbook_description() {
        return ebook_description;
      }

      public void setEbook_description(String ebook_description) {
        this.ebook_description = ebook_description;
      }

      public String getEbook_link() {
        return ebook_link;
      }

      public void setEbook_link(String ebook_link) {
        this.ebook_link = ebook_link;
      }

      public String getEbook_category_title() {
        return ebook_category_title;
      }

      public void setEbook_category_title(String ebook_category_title) {
        this.ebook_category_title = ebook_category_title;
      }
    }
  }
}
