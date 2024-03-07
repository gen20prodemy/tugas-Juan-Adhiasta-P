package Main;

import Interface.DatabaseInterface;
import Map.Database;
import POJO.Siswa;
import java.util.Scanner;

public class UpdateDatabase {
    static DatabaseInterface<Integer, Siswa> database = new Database();
    public static void updateDatabase(){
        Scanner scan = new Scanner(System.in);
        //Scanner scan1 = new Scanner(System.in);
        System.out.print("Masukkan no id siswa: ");
        Integer a = scan.nextInt();
        scan.nextLine();
        System.out.print("Masukkan nama baru: ");
        String b = scan.nextLine();
        scan.nextLine();
        System.out.print("Masukkan usia baru: ");
        int c = scan.nextInt();
        scan.nextLine();
        Siswa data = new Siswa(b,c);
        database.update(a,data);
        System.out.println();
        MapClass map = new MapClass();
        map.switchCase();
    }
}
