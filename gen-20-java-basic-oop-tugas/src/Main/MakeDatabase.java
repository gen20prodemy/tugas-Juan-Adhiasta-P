package Main;
import Map.Database;
import Interface.DatabaseInterface;
import POJO.Siswa;
import java.util.Scanner;

public class MakeDatabase {
    static DatabaseInterface<Integer, Siswa> database = new Database();
    public static void makeDatabase(){
        database.clear();
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        System.out.print("Masukkan jumlah data siswa yang ingin dibuat: ");
        Integer jumlah = scan.nextInt();
        scan.nextLine();
        for (Integer i = 0; i< jumlah; i++){
            System.out.print("Masukkan nama siswa: ");
            String a = scan.nextLine();
            System.out.print("Masukkan usia siswa: ");
            int b = scan1.nextInt();
            Siswa data = new Siswa(a, b);
            database.create(i, data);
        }
        System.out.println("Isi Map adalah: "+database);
        System.out.println();
        MapClass map = new MapClass();
        map.switchCase();
    }
}
