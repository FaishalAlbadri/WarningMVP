package com.faishalbadri.hijab.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/**
 * Created by fikriimaduddin on 11/3/17.
 */

public class PojoEbook {

  /**
   * ebook : [{"id_ebook":"1","judul_ebook":"helloo","gambar_ebook":"norel.png","description":"In order to take full advantage of Kotlin, we have to revisit some best practices we got used to in Java. Many of them can be replaced with better alternatives that are provided by Kotlin","link":"http://santriprogrammer.com","id_kategori":"1"},{"id_ebook":"2","judul_ebook":"halloowqwejqeoqwejweojwqe","gambar_ebook":"norel.png","description":"In order to take full advantage of Kotlin, we have to revisit some best practices we got used to in Java. Many of them can be replaced with better alternatives that are provided by Kotlin","link":"http://santriprogrammer.com","id_kategori":"1"},{"id_ebook":"3","judul_ebook":"halloowqwejqeoqwejweojwqe","gambar_ebook":"norel.png","description":"In order to take full advantage of Kotlin, we have to revisit some best practices we got used to in Java. Many of them can be replaced with better alternatives that are provided by Kotlin","link":"http://santriprogrammer.com","id_kategori":"1"},{"id_ebook":"4","judul_ebook":"halloow","gambar_ebook":"norel.png","description":"In order to take full advantage of Kotlin, we have to revisit some best practices we got used to in Java. Many of them can be replaced with better alternatives that are provided by Kotlin","link":"http://santriprogrammer.com","id_kategori":"2"},{"id_ebook":"5","judul_ebook":"halloowqwejqeoqwejweojwqe","gambar_ebook":"norel.png","description":"In order to take full advantage of Kotlin, we have to revisit some best practices we got used to in Java. Many of them can be replaced with better alternatives that are provided by Kotlin","link":"http://santriprogrammer.com","id_kategori":"2"},{"id_ebook":"6","judul_ebook":"halloow","gambar_ebook":"norel.png","description":"In order to take full advantage of Kotlin, we have to revisit some best practices we got used to in Java. Many of them can be replaced with better alternatives that are provided by Kotlin","link":"http://santriprogrammer.com","id_kategori":"2"},{"id_ebook":"7","judul_ebook":"helloo","gambar_ebook":"norel.png","description":"In order to take full advantage of Kotlin, we have to revisit some best practices we got used to in Java. Many of them can be replaced with better alternatives that are provided by Kotlin","link":"http://santriprogrammer.com","id_kategori":"3"},{"id_ebook":"8","judul_ebook":"halloowqwejqeoqwejweojwqe","gambar_ebook":"norel.png","description":"In order to take full advantage of Kotlin, we have to revisit some best practices we got used to in Java. Many of them can be replaced with better alternatives that are provided by Kotlin","link":"http://santriprogrammer.com","id_kategori":"3"}]
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
     * gambar_ebook : norel.png
     * description : In order to take full advantage of Kotlin, we have to revisit some best practices we got used to in Java. Many of them can be replaced with better alternatives that are provided by Kotlin
     * link : http://santriprogrammer.com
     * id_kategori : 1
     */

    private String id_ebook;
    private String judul_ebook;
    private String gambar_ebook;
    private String description;
    private String link;
    private String id_kategori;

    protected EbookBean(Parcel in) {
      id_ebook = in.readString();
      judul_ebook = in.readString();
      gambar_ebook = in.readString();
      description = in.readString();
      link = in.readString();
      id_kategori = in.readString();
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

    public String getId_kategori() {
      return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
      this.id_kategori = id_kategori;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(id_ebook);
      dest.writeString(judul_ebook);
      dest.writeString(gambar_ebook);
      dest.writeString(description);
      dest.writeString(link);
      dest.writeString(id_kategori);
    }
  }
}
