import java.util.*;

public class KelasMap {
    public static Map <String,String> listMap = new HashMap<>();

    public KelasMap(){

    }
    public static void switchCase(){
        System.out.println("Program Collection Map");
        System.out.println("1. Membuat Map");
        System.out.println("2. Menambahkan elemen dalam Map");
        System.out.println("3. Mengecek isi elemen pada indeks tertentu");
        System.out.println("4. Konversi Map");
        System.out.println("5. Kembali ke menu sebelumnya");
        System.out.print("Masukkan menu yang diinginkan: ");
        Scanner sw = new Scanner(System.in);
        int input = sw.nextInt();

        switch (input){
            case 1:
                makeMap();
                System.out.println();
                System.out.println();
                break;
            case 2:
                addMap();
                System.out.println();
                System.out.println();
                break;
            case 3:
                checkMap();
                System.out.println();
                System.out.println();
                break;
            case 4:
                konversiMap();
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
    public static void makeMap(){
        listMap.clear();
        int jumlah = 0;
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        System.out.print("Masukkan jumlah barang yang ingin dimasukkan dalam Map: ");
        jumlah = s.nextInt();
        s.nextLine();
        for(int i=0;i<jumlah;i++){
            System.out.print("Masukkan nama Barang: ");
            String barang = s.nextLine();
            System.out.print("Masukkan nama Brand: ");
            String brand = s1.nextLine();
            listMap.put(barang,brand);
        }
        System.out.println("Isi Map adalah: "+listMap);
        System.out.println("Ukuran list saat ini: "+listMap.size());
        System.out.println();
        switchCase();
    }
    public static void addMap(){
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.println("Isi Map saat ini: "+listMap);
        System.out.print("Masukkan jumlah barang yang ingin ditambahkan: ");
        int jumlah = in.nextInt();
        in.nextLine();
        for(int i=0;i<jumlah;i++){
            System.out.print("Masukkan nama Barang: ");
            String barang1 = in.nextLine();
            System.out.print("Masukkan nama Brand: ");
            String barang2 = in2.nextLine();
            listMap.put(barang1,barang2);
        }
        System.out.println("Isi Map sekarang: "+listMap);
        System.out.println("Ukuran list saat ini: "+listMap.size());
        System.out.println();
        switchCase();
    }
    public static void checkMap(){
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan indeks yang ingin dicek: ");
        int index = in.nextInt();
        int current = 0;
        System.out.println("Isi Map saat ini adalah: "+listMap);
        Set<Map.Entry<String,String>> entries = listMap.entrySet(); //get the entry set of the LinkedHashMap kenapa pake Entry?
        //Iterate over the entries
        for (Map.Entry<String,String> entry : entries){
            //check current Index apakah sama dengan index yang diinginkan
            if(current == index) {
                System.out.println("Nilai pada index ke-" + index + " adalah: " + entry.getValue());
            }
            current++;
        }
        System.out.println();
        switchCase();;
    }
    public static void konversiMap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Pilihan konversi list");
        System.out.println("1. Map menjadi list");
        System.out.println("2. Map menjadi Set");
        System.out.println("3. Kembali ke menu sebelumnya");
        System.out.print("Masukkan pilihan: ");
        int k = in.nextInt();
        System.out.println();
        System.out.println();

        switch (k){
            case 1:
                List<MapSetter> list = new ArrayList<>();
                for(Map.Entry<String,String>entry:listMap.entrySet()){
                    MapSetter mapSet = new MapSetter(entry.getKey(), entry.getValue());
                    list.add(mapSet);
                }
                System.out.println("Isi List adalah: "+list);
                System.out.println();
                System.out.println();
                switchCase();
                break;
            case 2:
                Set<MapSetter> set = new HashSet<>();
                for(Map.Entry<String,String> entry: listMap.entrySet()){
                    MapSetter mapSet = new MapSetter(entry.getKey(), entry.getValue());
                    set.add(mapSet);
                }
                System.out.println("Isi Set adalah: ");
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
                switchCase();
                break;
        }
    }
}
