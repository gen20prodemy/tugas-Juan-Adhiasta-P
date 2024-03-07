package Main;

import Interface.DatabaseInterface;
import Map.Database;
import POJO.Siswa;
import java.util.Scanner;

public class DeleteDatabase {
    static DatabaseInterface<Integer, Siswa> database = new Database();
    public static void deleteDatabase(){
        Scanner s = new Scanner(System.in);
        System.out.println("Masukkan no id yang ingin dihapus: ");
        Integer x = s.nextInt();
        database.delete(x);
        System.out.println();
        MapClass map = new MapClass();
        map.switchCase();
    }
}
