package com.faishalbadri.hijab.data;

import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class PojoEbook {

  /**
   * error : false
   * message : ADA
   * ebook : [{"ebook_id":1,"ebook_title":"Bintang","ebook_writer":"Tere Liye","ebook_publisher":"Gramedia Pustaka Utama","ebook_release_date":"2017-06-12","ebook_image":"assets/ebook_images/IMG_1513595728.jpg","ebook_description":"Sample Desc","ebook_link":"assets/ebook_files/PDF_1513601688.pdf","ebook_category_id":1,"ebook_category_name":"Fantasi"},{"ebook_id":2,"ebook_title":"asd","ebook_writer":"asd","ebook_publisher":"asd","ebook_release_date":"2017-12-11","ebook_image":"assets/ebook_images/IMG_1513595883.jpg","ebook_description":"<p>sdasdas<\/p>\r\n","ebook_link":"assets/ebook_files/PDF_1513601688.pdf","ebook_category_id":1,"ebook_category_name":"Fantasi"}]
   */

  private boolean error;
  private String message;
  private List<EbookBean> ebook;

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

  public List<EbookBean> getEbook() {
    return ebook;
  }

  public void setEbook(List<EbookBean> ebook) {
    this.ebook = ebook;
  }

  public static class EbookBean {

    /**
     * ebook_id : 1
     * ebook_title : Bintang
     * ebook_writer : Tere Liye
     * ebook_publisher : Gramedia Pustaka Utama
     * ebook_release_date : 2017-06-12
     * ebook_image : assets/ebook_images/IMG_1513595728.jpg
     * ebook_description : Sample Desc
     * ebook_link : assets/ebook_files/PDF_1513601688.pdf
     * ebook_category_id : 1
     * ebook_category_name : Fantasi
     */

    private String ebook_id;
    private String ebook_title;
    private String ebook_writer;
    private String ebook_publisher;
    private String ebook_release_date;
    private String ebook_image;
    private String ebook_description;
    private String ebook_link;
    private String ebook_category_id;
    private String ebook_category_name;

    public String getEbook_id() {
      return ebook_id;
    }

    public void setEbook_id(String ebook_id) {
      this.ebook_id = ebook_id;
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

    public String getEbook_release_date() {
      return ebook_release_date;
    }

    public void setEbook_release_date(String ebook_release_date) {
      this.ebook_release_date = ebook_release_date;
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
