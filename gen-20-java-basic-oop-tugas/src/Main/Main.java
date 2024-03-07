package Main;
import Interface.DatabaseInterface;
import Map.Database;
import POJO.Siswa;

public class Main {
    DatabaseInterface<Integer, Siswa> database = new Database();
    public static void main(String[] args) {
    MapClass map = new MapClass();
    map.switchCase();
    }
}