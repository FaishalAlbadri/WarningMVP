package com.faishalbadri.hijab.revamp.data;

/**
 * Created by faishal on 10/30/17.
 */

public class DataHomeFragment {

  private String judul;
  private String judulDetail;
  private int gambar;

  public DataHomeFragment(String judul, String judulDetail, int gambar) {
    this.judul = judul;
    this.judulDetail = judulDetail;
    this.gambar = gambar;
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
}
