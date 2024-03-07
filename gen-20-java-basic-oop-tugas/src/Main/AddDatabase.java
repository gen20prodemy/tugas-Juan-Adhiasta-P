package Main;

import Interface.DatabaseInterface;
import Map.Database;
import POJO.Siswa;

import java.util.Scanner;

public class AddDatabase {
    static DatabaseInterface<Integer, Siswa> database = new Database();
    public static void addDatabase(){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        System.out.print("Masukkan jumlah data siswa yang ingin dibuat: ");
        Integer jumlah = scan.nextInt();
        scan.nextLine();
        for (Integer i = 0; i< jumlah; i++){
            System.out.println("Masukkan nama siswa: ");
            String a = scan.nextLine();
            System.out.println("Masukkan usia siswa: ");
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
