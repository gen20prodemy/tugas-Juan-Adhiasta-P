public class MapSetter {
    private String namaBarang;
    private String namaBrand;

    public MapSetter(String namaBarang, String namaBrand){
        this.namaBarang = namaBarang;
        this.namaBrand = namaBrand;
    }

    @Override
    public String toString(){
        return namaBarang + "=" + namaBrand;
    }
}
