package com.faishalbadri.hijab.data;

import android.os.Parcel;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class PojoEbook {

  /**
   * ebook : [{"id_ebook":"9","judul_ebook":"asdadsada","penulis_ebook":"asdasdas","penerbit_ebook":"asdasdas","tanggal_terbit_ebook":"2017-11-05","gambar_ebook":"norel.png","description":"In
   * order to take full advantage of Kotlin, we have to revisit some best practices we got used to
   * in Java. Many of them can be replaced with better alternatives that are provided by
   * Kotlin","link":"faishalbadri.com","id_kategori_ebook":"1"}] status : 1 msg : Data Semua Ebook
   */

  private String status;
  private String msg;
  private List<EbookBean> ebook;

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

  public List<EbookBean> getEbook() {
    return ebook;
  }

  public void setEbook(List<EbookBean> ebook) {
    this.ebook = ebook;
  }

  public static class EbookBean implements android.os.Parcelable {

    public static final Creator<EbookBean> CREATOR = new Creator<EbookBean>() {
      @Override
      public EbookBean createFromParcel(Parcel source) {
        return new EbookBean(source);
      }

      @Override
      public EbookBean[] newArray(int size) {
        return new EbookBean[size];
      }
    };
    /**
     * id_ebook : 9 judul_ebook : asdadsada penulis_ebook : asdasdas penerbit_ebook : asdasdas
     * tanggal_terbit_ebook : 2017-11-05 gambar_ebook : norel.png description : In order to take
     * full advantage of Kotlin, we have to revisit some best practices we got used to in Java. Many
     * of them can be replaced with better alternatives that are provided by Kotlin link :
     * faishalbadri.com id_kategori_ebook : 1
     */

    private String id_ebook;
    private String judul_ebook;
    private String penulis_ebook;
    private String penerbit_ebook;
    private String tanggal_terbit_ebook;
    private String gambar_ebook;
    private String description;
    private String link;
    private String id_kategori_ebook;

    public EbookBean() {
    }

    protected EbookBean(Parcel in) {
      this.id_ebook = in.readString();
      this.judul_ebook = in.readString();
      this.penulis_ebook = in.readString();
      this.penerbit_ebook = in.readString();
      this.tanggal_terbit_ebook = in.readString();
      this.gambar_ebook = in.readString();
      this.description = in.readString();
      this.link = in.readString();
      this.id_kategori_ebook = in.readString();
    }

    public String getId_ebook() {
      return id_ebook;
    }

    public void setId_ebook(String id_ebook) {
      this.id_ebook = id_ebook;
    }

    public String getJudul_ebook() {
      return judul_ebook;
    }

    public void setJudul_ebook(String judul_ebook) {
      this.judul_ebook = judul_ebook;
    }

    public String getPenulis_ebook() {
      return penulis_ebook;
    }

    public void setPenulis_ebook(String penulis_ebook) {
      this.penulis_ebook = penulis_ebook;
    }

    public String getPenerbit_ebook() {
      return penerbit_ebook;
    }

    public void setPenerbit_ebook(String penerbit_ebook) {
      this.penerbit_ebook = penerbit_ebook;
    }

    public String getTanggal_terbit_ebook() {
      return tanggal_terbit_ebook;
    }

    public void setTanggal_terbit_ebook(String tanggal_terbit_ebook) {
      this.tanggal_terbit_ebook = tanggal_terbit_ebook;
    }

    public String getGambar_ebook() {
      return gambar_ebook;
    }

    public void setGambar_ebook(String gambar_ebook) {
      this.gambar_ebook = gambar_ebook;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getLink() {
      return link;
    }

    public void setLink(String link) {
      this.link = link;
    }

    public String getId_kategori_ebook() {
      return id_kategori_ebook;
    }

    public void setId_kategori_ebook(String id_kategori_ebook) {
      this.id_kategori_ebook = id_kategori_ebook;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.id_ebook);
      dest.writeString(this.judul_ebook);
      dest.writeString(this.penulis_ebook);
      dest.writeString(this.penerbit_ebook);
      dest.writeString(this.tanggal_terbit_ebook);
      dest.writeString(this.gambar_ebook);
      dest.writeString(this.description);
      dest.writeString(this.link);
      dest.writeString(this.id_kategori_ebook);
    }
  }
}
