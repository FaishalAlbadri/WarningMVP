package com.faishalbadri.hijab.data;

import android.os.Parcel;
import java.util.List;

/**
 * Created by faishal on 11/4/17.
 */

public class PojoNews {

  /**
   * isi : [{"id_isi":"41","id_admin":"1","id_kategori":"18","isi_judul":"Tips Tampil Sporty dengan
   * Celana Jeans Buat Hijaber","admin_nama":"admin","kategori_nama":"Sport","isi_keterangan":"asdas","isi_tgl_upload":"2017-11-04
   * 17:34:02","isi_kunjungan":"0","isi_gambar":"hijaber-begini-tampil-sporty-dengan-celana-jeans-171023d_3x2.jpg"}]
   * status : 1 msg : Data Semua Isi
   */

  private String status;
  private String msg;
  private List<IsiBean> isi;

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

  public List<IsiBean> getIsi() {
    return isi;
  }

  public void setIsi(List<IsiBean> isi) {
    this.isi = isi;
  }

  public static class IsiBean implements android.os.Parcelable {

    public static final Creator<IsiBean> CREATOR = new Creator<IsiBean>() {
      @Override
      public IsiBean createFromParcel(Parcel source) {
        return new IsiBean(source);
      }

      @Override
      public IsiBean[] newArray(int size) {
        return new IsiBean[size];
      }
    };
    /**
     * id_isi : 41
     * id_admin : 1
     * id_kategori : 18
     * isi_judul : Tips Tampil Sporty dengan Celana Jeans Buat Hijaber
     * admin_nama : admin
     * kategori_nama : Sport
     * isi_keterangan : asdas
     * isi_tgl_upload : 2017-11-04 17:34:02
     * isi_kunjungan : 0
     * isi_gambar : hijaber-begini-tampil-sporty-dengan-celana-jeans-171023d_3x2.jpg
     */

    private String id_isi;
    private String id_admin;
    private String id_kategori;
    private String isi_judul;
    private String admin_nama;
    private String kategori_nama;
    private String isi_keterangan;
    private String isi_tgl_upload;
    private Double isi_kunjungan;
    private String isi_gambar;

    public IsiBean() {
    }

    protected IsiBean(Parcel in) {
      this.id_isi = in.readString();
      this.id_admin = in.readString();
      this.id_kategori = in.readString();
      this.isi_judul = in.readString();
      this.admin_nama = in.readString();
      this.kategori_nama = in.readString();
      this.isi_keterangan = in.readString();
      this.isi_tgl_upload = in.readString();
      this.isi_kunjungan = (Double) in.readValue(Double.class.getClassLoader());
      this.isi_gambar = in.readString();
    }

    public String getId_isi() {
      return id_isi;
    }

    public void setId_isi(String id_isi) {
      this.id_isi = id_isi;
    }

    public String getId_admin() {
      return id_admin;
    }

    public void setId_admin(String id_admin) {
      this.id_admin = id_admin;
    }

    public String getId_kategori() {
      return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
      this.id_kategori = id_kategori;
    }

    public String getIsi_judul() {
      return isi_judul;
    }

    public void setIsi_judul(String isi_judul) {
      this.isi_judul = isi_judul;
    }

    public String getAdmin_nama() {
      return admin_nama;
    }

    public void setAdmin_nama(String admin_nama) {
      this.admin_nama = admin_nama;
    }

    public String getKategori_nama() {
      return kategori_nama;
    }

    public void setKategori_nama(String kategori_nama) {
      this.kategori_nama = kategori_nama;
    }

    public String getIsi_keterangan() {
      return isi_keterangan;
    }

    public void setIsi_keterangan(String isi_keterangan) {
      this.isi_keterangan = isi_keterangan;
    }

    public String getIsi_tgl_upload() {
      return isi_tgl_upload;
    }

    public void setIsi_tgl_upload(String isi_tgl_upload) {
      this.isi_tgl_upload = isi_tgl_upload;
    }

    public Double getIsi_kunjungan() {
      return isi_kunjungan;
    }

    public void setIsi_kunjungan(Double isi_kunjungan) {
      this.isi_kunjungan = isi_kunjungan;
    }

    public String getIsi_gambar() {
      return isi_gambar;
    }

    public void setIsi_gambar(String isi_gambar) {
      this.isi_gambar = isi_gambar;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.id_isi);
      dest.writeString(this.id_admin);
      dest.writeString(this.id_kategori);
      dest.writeString(this.isi_judul);
      dest.writeString(this.admin_nama);
      dest.writeString(this.kategori_nama);
      dest.writeString(this.isi_keterangan);
      dest.writeString(this.isi_tgl_upload);
      dest.writeValue(this.isi_kunjungan);
      dest.writeString(this.isi_gambar);
    }
  }
}
