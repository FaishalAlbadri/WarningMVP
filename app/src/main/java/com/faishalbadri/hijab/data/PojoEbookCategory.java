package com.faishalbadri.hijab.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by fikriimaduddin on 10/11/17.
 */

public class PojoEbookCategory {

  /**
   * kategori_ebook : [{"id_kategori_ebook":"3","nama_kategori":"horor"},{"id_kategori_ebook":"2","nama_kategori":"komedi"},{"id_kategori_ebook":"4","nama_kategori":"noon"},{"id_kategori_ebook":"1","nama_kategori":"romance"}]
   * status : 1 msg : Data Semua Kategori
   */

  private String status;
  private String msg;
  private List<KategoriEbookBean> kategori_ebook;

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

  public List<KategoriEbookBean> getKategori_ebook() {
    return kategori_ebook;
  }

  public void setKategori_ebook(List<KategoriEbookBean> kategori_ebook) {
    this.kategori_ebook = kategori_ebook;
  }

  public static class KategoriEbookBean implements Parcelable {

    public static final Creator<KategoriEbookBean> CREATOR = new Creator<KategoriEbookBean>() {
      @Override
      public KategoriEbookBean createFromParcel(Parcel in) {
        return new KategoriEbookBean(in);
      }

      @Override
      public KategoriEbookBean[] newArray(int size) {
        return new KategoriEbookBean[size];
      }
    };
    /**
     * id_kategori_ebook : 3
     * nama_kategori : horor
     */

    private String id_kategori_ebook;
    private String nama_kategori;

    protected KategoriEbookBean(Parcel in) {
      id_kategori_ebook = in.readString();
      nama_kategori = in.readString();
    }

    public String getId_kategori_ebook() {
      return id_kategori_ebook;
    }

    public void setId_kategori_ebook(String id_kategori_ebook) {
      this.id_kategori_ebook = id_kategori_ebook;
    }

    public String getNama_kategori() {
      return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
      this.nama_kategori = nama_kategori;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(id_kategori_ebook);
      dest.writeString(nama_kategori);
    }
  }
}
