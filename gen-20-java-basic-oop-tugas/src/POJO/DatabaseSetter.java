package POJO;

public class DatabaseSetter {
    private Integer no_id;
    private String namaSiswa;

    public DatabaseSetter(Integer no_id, String namaSiswa){
        this.no_id = no_id;
        this.namaSiswa = namaSiswa;
    }
    public void setNo_id(){
        this.no_id = no_id;
    }
    public void setNamaSiswa(){
        this.namaSiswa = namaSiswa;
    }
    public Integer getNo_id(){
        return no_id;
    }
    public String getNamaSiswa(){
        return namaSiswa;
    }
}
