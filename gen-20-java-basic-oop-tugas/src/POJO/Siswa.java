package POJO;

public class Siswa {
    private int usia;
    private String namaSiswa;

    public Siswa(String namaSiswa, int usia){
        this.namaSiswa = namaSiswa;
        this.usia = usia;
    }
    /*public void setUsia(){
        this.usia = usia;
    }*/
    public void setNamaSiswa(){
        this.namaSiswa = namaSiswa;
    }
    public int getUsia(){
        return usia;
    }
    public String getNamaSiswa(){
        return namaSiswa;
    }

    @Override
    public String toString() {
        return namaSiswa+" : "+usia;
    }
}
