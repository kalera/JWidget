package com.stripbandunk.test.jwidget.dynamictable;

import com.stripbandunk.jwidget.annotation.TableColumn;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class Pengguna {

    @TableColumn(number = 1, name = "Kode", groups = {"private"})
    private String kode;

    @TableColumn(number = 2, name = "Kata Sandi", groups = {"private"})
    private String kataSandi;

    @TableColumn(number = 3, name = "Nama", size = 25, groups = {"private", "public"})
    private String nama;

    @TableColumn(number = 4, name = "Email", size = 20, groups = {"private", "public"})
    private String email;

    @TableColumn(number = 5, name = "Telepon", groups = {"private"})
    private String telepon;

    @TableColumn(number = 6, name = "Website", groups = {"private", "public"})
    private String website;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKataSandi() {
        return kataSandi;
    }

    public void setKataSandi(String kataSandi) {
        this.kataSandi = kataSandi;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
