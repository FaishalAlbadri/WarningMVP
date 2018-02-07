package com.faishalbadri.hijab.data;

/**
 * Created by faishal on 10/30/17.
 */

public class DataHomeFragment {

  private String judul;
  private String judulDetail;
  private int gambar;
  private int titleImage;

  public DataHomeFragment(String judul, String judulDetail, int gambar, int titleImage) {
    this.judul = judul;
    this.judulDetail = judulDetail;
    this.gambar = gambar;
    this.titleImage = titleImage;
  }

  public String getJudul() {
    return judul;
  }

  public void setJudul(String judul) {
    this.judul = judul;
  }

  public String getJudulDetail() {
    return judulDetail;
  }

  public void setJudulDetail(String judulDetail) {
    this.judulDetail = judulDetail;
  }

  public int getGambar() {
    return gambar;
  }

  public void setGambar(int gambar) {
    this.gambar = gambar;
  }

  public int getTitleImage() {
    return titleImage;
  }

  public void setTitleImage(int titleImage) {
    this.titleImage = titleImage;
  }
}
