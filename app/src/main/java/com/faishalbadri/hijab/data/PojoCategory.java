package com.faishalbadri.hijab.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class PojoCategory {

  /**
   * kategori : [{"id_kategori":"5","kategori_nama":"Beauty"},{"id_kategori":"11","kategori_nama":"Cerbung"},{"id_kategori":"10","kategori_nama":"Cerpen"},{"id_kategori":"3","kategori_nama":"Community"},{"id_kategori":"21","kategori_nama":"Event Update"},{"id_kategori":"6","kategori_nama":"Fashion"},{"id_kategori":"15","kategori_nama":"Financial"},{"id_kategori":"4","kategori_nama":"Global Muslim"},{"id_kategori":"16","kategori_nama":"Kesehatan"},{"id_kategori":"12","kategori_nama":"Kisahmu"},{"id_kategori":"20","kategori_nama":"Konsultasi"},{"id_kategori":"23","kategori_nama":"Kuliner"},{"id_kategori":"8","kategori_nama":"LifeStyle"},{"id_kategori":"14","kategori_nama":"Motivation"},{"id_kategori":"17","kategori_nama":"Music,Film,Buku"},{"id_kategori":"1","kategori_nama":"Muslimah Inspiratif"},{"id_kategori":"2","kategori_nama":"Muslimah World"},{"id_kategori":"24","kategori_nama":"Referensi"},{"id_kategori":"7","kategori_nama":"Religi"},{"id_kategori":"22","kategori_nama":"Resep"},{"id_kategori":"13","kategori_nama":"Selebritis"},{"id_kategori":"18","kategori_nama":"Sport"},{"id_kategori":"19","kategori_nama":"Teknologi"},{"id_kategori":"9","kategori_nama":"Travel"}]
   * status : 1
   * msg : Data Semua Kategori
   */

  private String status;
  private String msg;
  private List<KategoriBean> kategori;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public List<KategoriBean> getKategori() {
    return kategori;
  }

  public void setKategori(List<KategoriBean> kategori) {
    this.kategori = kategori;
  }

  public static class KategoriBean implements android.os.Parcelable {

    /**
     * id_kategori : 5
     * kategori_nama : Beauty
     */

    private String id_kategori;
    private String kategori_nama;

    public String getId_kategori() {
      return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
      this.id_kategori = id_kategori;
    }

    public String getKategori_nama() {
      return kategori_nama;
    }

    public void setKategori_nama(String kategori_nama) {
      this.kategori_nama = kategori_nama;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.id_kategori);
      dest.writeString(this.kategori_nama);
    }

    public KategoriBean() {
    }

    protected KategoriBean(Parcel in) {
      this.id_kategori = in.readString();
      this.kategori_nama = in.readString();
    }

    public static final Creator<KategoriBean> CREATOR = new Creator<KategoriBean>() {
      @Override
      public KategoriBean createFromParcel(Parcel source) {
        return new KategoriBean(source);
      }

      @Override
      public KategoriBean[] newArray(int size) {
        return new KategoriBean[size];
      }
    };
  }
}
