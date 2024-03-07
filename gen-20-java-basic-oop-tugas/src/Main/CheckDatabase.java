package Main;

import Interface.DatabaseInterface;
import Map.Database;
import POJO.Siswa;
import java.util.Scanner;

public class CheckDatabase {
    static DatabaseInterface<Integer, Siswa> database = new Database();
    public static void checkDatabase(){
        Scanner s = new Scanner(System.in);
        System.out.print("Masukkan no id siswa untuk dicek: ");
        Integer x = s.nextInt();
        database.read(x);
        System.out.println();
        MapClass map = new MapClass();
        map.switchCase();
    }
}
