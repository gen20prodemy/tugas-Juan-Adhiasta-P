import java.util.*;
public class KelasList {
    public static List<String> listBarang = new ArrayList<>();

    public KelasList(){

    }

    public static void switchCase(){
            System.out.println("Program Collection List");
            System.out.println("1. Membuat list");
            System.out.println("2. Menambahkan elemen dalam list");
            System.out.println("3. Mengecek isi elemen pada indeks tertentu");
            System.out.println("4. Konversi List");
            System.out.println("5. Kembali ke menu sebelumnya");
            System.out.print("Masukkan menu yang diinginkan: ");
            Scanner sw = new Scanner(System.in);
            int input = sw.nextInt();

            switch (input){
                case 1:
                    makeList();
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    addList();
                    System.out.println();
                    System.out.println();
                    break;
                case 3:
                    checkList();
                    System.out.println();
                    System.out.println();
                    break;
                case 4:
                    konversiList();
                    System.out.println();
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.println();
                    Main metode = new Main();
                    metode.start();
                    break;
                default:
                    System.out.println("Error");
                    System.out.println("Kembali ke menu utama");
                    System.out.println();
                    Main metode2 = new Main();
                    metode2.start();
            }
    }
    public static void makeList(){
        listBarang.clear();
        int jumlah = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Masukkan jumlah barang dalam List: ");

           jumlah = s.nextInt();

        s.nextLine();
        for(int i =0; i<jumlah;i++){
            System.out.print("Masukkan nama barang: ");
            String barang = s.nextLine();
            listBarang.add(new String(barang));
        }
        System.out.println("Isi list adalah: "+listBarang.toString());
        System.out.println("Ukuran list saat ini: "+listBarang.size());
        System.out.println();
        switchCase();
    }
    public static void addList(){
        Scanner in = new Scanner(System.in);
        int jumlah = 0;
        System.out.println("Isi List saat ini: "+listBarang.toString());
        System.out.print("Masukkan jumlah barang yang ingin ditambahkan: ");
        jumlah = in.nextInt();
        in.nextLine();
        for(int i=0; i<jumlah;i++){
            System.out.print("Masukkan nama barang: ");
            String barang = in.nextLine();
            listBarang.add(new String(barang));
        }
        System.out.println("Isi list sekarang: "+listBarang);
        System.out.println("Ukuran list saat ini: "+listBarang.size());
        System.out.println();
        switchCase();
    }
    public static void checkList(){
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan index yang ingin dicek: ");
        int a = in.nextInt();
        System.out.print("Elemen pada index ke-"+a+" adalah: "+listBarang.get(a));
        System.out.println();
        switchCase();
    }
    public static void konversiList(){
        Scanner in = new Scanner(System.in);
        System.out.println("Pilihan konversi list");
        System.out.println("1. List menjadi Set");
        System.out.println("2. List menjadi Map");
        System.out.println("3. Kembali ke menu sebelumnya");
        System.out.print("Masukkan pilihan: ");
        int k = in.nextInt();
        System.out.println();
        System.out.println();


        switch(k){
            case 1:
                Set<String> set = new HashSet<>();
                set.addAll(listBarang);
                System.out.println(set);
                for(String obj : set){
                    System.out.println(obj);
                }
                System.out.println();
                System.out.println();
                switchCase();
                break;
            case 2:
                int panjang = listBarang.size();
                Map<Integer,String> map = new HashMap<>();
                for (int i =0; i<panjang;i++){
                    map.put(i,listBarang.get(i));
                }
                System.out.println(map);
                System.out.println();
                System.out.println();
                switchCase();
                break;
            case 3:
                System.out.println();
                System.out.println();
                switchCase();
                break;
            default:
                System.out.println("Error");
                System.out.println("Kembali ke menu sebelumnya");
                System.out.println();
                switchCase();
        }
    }
}

