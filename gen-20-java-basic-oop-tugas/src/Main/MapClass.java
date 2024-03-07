package Main;
import java.util.Scanner;
import Interface.DatabaseInterface;
import Map.Database;
import POJO.Siswa;

public class MapClass {
    DatabaseInterface<Integer, Siswa> database = new Database();

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
                MakeDatabase mk = new MakeDatabase();
                mk.makeDatabase();
                System.out.println();
                System.out.println();
                break;
            case 2:
                AddDatabase ad = new AddDatabase();
                ad.addDatabase();
                System.out.println();
                System.out.println();
                break;
            case 3:

                System.out.println();
                System.out.println();
                break;
            case 4:

                System.out.println();
                System.out.println();
            case 5:

                System.out.println();
                System.out.println();
            case 6:
                System.exit(0);
                break;
        }
    }
}
