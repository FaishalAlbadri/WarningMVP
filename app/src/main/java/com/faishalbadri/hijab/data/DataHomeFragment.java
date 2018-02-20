package com.faishalbadri.hijab.data;

/**
 * Created by faishal on 10/30/17.
 */

public class DataHomeFragment {

  private String judul;
  private int gambar;

  public DataHomeFragment(String judul, int gambar) {
    this.judul = judul;
    this.gambar = gambar;
  }

  public String getJudul() {
    return judul;
  }

  public void setJudul(String judul) {
    this.judul = judul;
  }

  public int getGambar() {
    return gambar;
  }

  public void setGambar(int gambar) {
    this.gambar = gambar;
  }
}
