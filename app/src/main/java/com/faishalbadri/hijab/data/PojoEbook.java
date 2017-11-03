package com.faishalbadri.hijab.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class PojoEbook {

  /**
   * ebook : [{"id_ebook":"1","judul_ebook":"helloo","gambar_ebook":"example.png","link":"http://santriprogrammer.com"},{"id_ebook":"2","judul_ebook":"halloow","gambar_ebook":"example.png","link":"http://santriprogrammer.com"},{"id_ebook":"3","judul_ebook":"helloo","gambar_ebook":"example.png","link":"http://santriprogrammer.com"},{"id_ebook":"4","judul_ebook":"halloow","gambar_ebook":"example.png","link":"http://santriprogrammer.com"}]
   * status : 1
   * msg : Data Semua Ebook
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

  public static class EbookBean implements Parcelable{

    /**
     * id_ebook : 1
     * judul_ebook : helloo
     * gambar_ebook : example.png
     * link : http://santriprogrammer.com
     */

    private String id_ebook;
    private String judul_ebook;
    private String gambar_ebook;
    private String link;

    protected EbookBean(Parcel in) {
      id_ebook = in.readString();
      judul_ebook = in.readString();
      gambar_ebook = in.readString();
      link = in.readString();
    }

    public static final Creator<EbookBean> CREATOR = new Creator<EbookBean>() {
      @Override
      public EbookBean createFromParcel(Parcel in) {
        return new EbookBean(in);
      }

      @Override
      public EbookBean[] newArray(int size) {
        return new EbookBean[size];
      }
    };

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

    public String getGambar_ebook() {
      return gambar_ebook;
    }

    public void setGambar_ebook(String gambar_ebook) {
      this.gambar_ebook = gambar_ebook;
    }

    public String getLink() {
      return link;
    }

    public void setLink(String link) {
      this.link = link;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
      parcel.writeString(id_ebook);
      parcel.writeString(judul_ebook);
      parcel.writeString(gambar_ebook);
      parcel.writeString(link);
    }
  }
}
