package Main;
import java.util.Scanner;
import Interface.DatabaseInterface;
import Map.Database;
import POJO.Siswa;

public class MapClass {
    static DatabaseInterface<Integer, Siswa> database = new Database();

    public MapClass(){

    }
    public static void switchCase(){
        System.out.println("Program Database berbasis Map");
        System.out.println("1. Membuat map");
        System.out.println("2. Menambahkan elemen pada Map");
        System.out.println("3. Update Map");
        System.out.println("4. Membaca Map");
        System.out.println("5. Delete isi Map");
        System.out.println("6. Keluar");
        System.out.print("Masukkan pilihan: ");
        Scanner s = new Scanner(System.in);
        int p = s.nextInt();

        switch (p){
            case 1:
                makeDatabase();
                System.out.println();
                System.out.println();
                break;
            case 2:
                addDatabase();
                System.out.println();
                System.out.println();
                break;
            case 3:
                updateDatabase();
                System.out.println();
                System.out.println();
                break;
            case 4:
                checkDatabase();
                System.out.println();
                System.out.println();
            case 5:
                deleteDatabase();
                System.out.println();
                System.out.println();
            case 6:
                System.exit(0);
                break;
        }
    }
    public static void makeDatabase(){
        database.clear();
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        System.out.print("Masukkan jumlah data siswa yang ingin dibuat: ");
        Integer jumlah = scan.nextInt();
        scan.nextLine();
        for (Integer i = 0; i< jumlah; i++){
            System.out.println("Masukkan no id siswa: ");
            Integer c = scan2.nextInt();
            System.out.print("Masukkan nama siswa: ");
            String a = scan.nextLine();
            System.out.print("Masukkan usia siswa: ");
            int b = scan1.nextInt();
            Siswa data = new Siswa(a, b);
            database.create(c, data);
        }
        System.out.println("Isi Map adalah:");
        database.display();
        System.out.println();
        switchCase();
    }
    public static void addDatabase(){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        System.out.print("Masukkan jumlah data siswa yang ingin dibuat: ");
        Integer jumlah = scan.nextInt();
        scan.nextLine();
        for (Integer i = 0; i< jumlah; i++){
            System.out.println("Masukkan no id siswa: ");
            Integer c = scan2.nextInt();
            System.out.println("Masukkan nama siswa: ");
            String a = scan.nextLine();
            System.out.println("Masukkan usia siswa: ");
            int b = scan1.nextInt();
            Siswa data = new Siswa(a, b);
            database.create(c, data);
        }
        System.out.println("Isi Map adalah: ");
        database.display();
        System.out.println();
        switchCase();
    }
    public static void updateDatabase(){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        System.out.print("Masukkan no id siswa: ");
        Integer a = scan.nextInt();
        System.out.print("Masukkan nama baru: ");
        String b = scan1.nextLine();
        System.out.print("Masukkan usia baru: ");
        int c = scan2.nextInt();
        Siswa data = new Siswa(b,c);
        database.update(a,data);
        database.display();
        System.out.println();
        switchCase();
    }
    public static void checkDatabase(){
        Scanner s = new Scanner(System.in);
        System.out.print("Masukkan no id siswa untuk dicek: ");
        Integer x = s.nextInt();
        database.read(x);
        System.out.println();
        switchCase();
    }
    public static void deleteDatabase(){
        Scanner s = new Scanner(System.in);
        System.out.println("Masukkan no id yang ingin dihapus: ");
        Integer x = s.nextInt();
        database.delete(x);
        System.out.println();
        switchCase();
    }
}
