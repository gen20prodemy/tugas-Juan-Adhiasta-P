public class SetSetter {
    private String namaBarang;
    private String namaBrand;

    public SetSetter(String namaBarang, String namaBrand){
        this.namaBarang = namaBarang;
        this.namaBrand = namaBrand;
    }
    @Override
    public String toString(){
        return namaBarang + "=" + namaBrand;
    }
    public String getBrand(){
        return namaBrand;
    }
    public String getBarang(){
        return namaBarang;
    }
}
