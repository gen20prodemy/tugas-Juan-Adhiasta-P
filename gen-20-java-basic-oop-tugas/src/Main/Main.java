package Main;
import Interface.DatabaseInterface;
import Map.Database;
import POJO.Siswa;

public class Main {
    DatabaseInterface<Integer, Siswa> database = new Database();
    public static void main(String[] args) {
    try {
        MapClass map = new MapClass();
        map.switchCase();
    } catch (Exception e){
        System.err.print(e);
        e.printStackTrace();
    }
    }
}