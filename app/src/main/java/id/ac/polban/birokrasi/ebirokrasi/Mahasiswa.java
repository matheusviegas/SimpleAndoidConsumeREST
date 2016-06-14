package id.ac.polban.birokrasi.ebirokrasi;

/**
 * Created by hanifibram on 14/06/16.
 */
public class Mahasiswa {

    String nim;
    String nama;
    String umur;

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    @Override
    public String toString() {
        return nama;
    }
}
