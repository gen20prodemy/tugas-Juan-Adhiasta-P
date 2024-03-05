import java.util.*;

public class Main {
    public static void main(String[] args) {
        start();
    }
    public static void start(){
        try{
            Scanner scan = new Scanner(System.in);
            System.out.println("Java Collection");
            System.out.println("1. Collection List");
            System.out.println("2. Collection Set");
            System.out.println("3. Collection Map");
            System.out.println("4. Keluar");
            System.out.print("Masukkan perintah program: ");
            int input = scan.nextInt();
            System.out.println();

            switch (input){
                case 1:
                    KelasList list = new KelasList();
                    list.switchCase();
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    KelasSet set = new KelasSet();
                    set.switchCase();
                    System.out.println();
                    System.out.println();
                    break;
                case 3:
                    KelasMap map = new KelasMap();
                    map.switchCase();
                    System.out.println();
                    System.out.println();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
                    System.out.println("Kembali ke start");
                    System.out.println();
                    start();
            }
        } catch (InputMismatchException e){
            System.out.println("Error: "+e);
            System.out.println("Mohon masukkan angka");
            System.out.println();
            start();
        }
    }
}