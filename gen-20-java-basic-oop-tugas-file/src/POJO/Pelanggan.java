package POJO;

public class Pelanggan {
    private String name;
    private int usia;

    public Pelanggan(String name, int usia){
        this.name = name;
        this.usia = usia;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getUsia(){
        return usia;
    }
    public void setUsia(int usia){
        this.usia = usia;
    }

    @Override
    public String toString() {
        return "Nama: "+name+ ", Alamat: "+usia;
    }
}
