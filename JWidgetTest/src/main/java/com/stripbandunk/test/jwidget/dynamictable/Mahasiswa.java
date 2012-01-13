package com.stripbandunk.test.jwidget.dynamictable;

import com.stripbandunk.jwidget.annotation.TableColumn;

/**
 *
 * @author Eko Kurniawan Khannedy
 */
public class Mahasiswa {

    @TableColumn(number = 1, name = "Nim", size = 10)
    private String nim;

    @TableColumn(number = 2, name = "Nama", size = 20)
    private String nama;

    @TableColumn(number = 3, name = "Universitas", size = 20)
    private String universitas;

    @TableColumn(number = 4, name = "Fakultas", size = 20)
    private String fakultas;

    @TableColumn(number = 5, name = "Jurusan", size = 20)
    private String jurusan;

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getUniversitas() {
        return universitas;
    }

    public void setUniversitas(String universitas) {
        this.universitas = universitas;
    }
}
