import java.util.*;
public class KelasSet {

    public static Set<SetSetter> listSet = new HashSet<>();

    public KelasSet(){

    }
    public static void switchCase(){
        System.out.println("Program Collection Set");
        System.out.println("1. Membuat set");
        System.out.println("2. Menambahkan elemen dalam set");
        System.out.println("3. Mengecek isi elemen pada indeks tertentu");
        System.out.println("4. Konversi set");
        System.out.println("5. Kembali ke menu sebelumnya");
        System.out.print("Masukkan menu yang diinginkan: ");
        Scanner sw = new Scanner(System.in);
        int input = sw.nextInt();

        switch (input){
            case 1:
                makeSet();
                System.out.println();
                System.out.println();
                break;
            case 2:
                addSet();
                System.out.println();
                System.out.println();
                break;
            case 3:
                checkSet();
                System.out.println();
                System.out.println();
                break;
            case 4:
                konversiSet();
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
    public static void makeSet(){
        listSet.clear();
        Scanner s = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        System.out.print("Masukkan jumlah barang dalam Set: ");
        int jumlah = s.nextInt();
        s.nextLine();
        for (int i=0; i<jumlah;i++){
            System.out.print("Masukkan nama barang: ");
            String barang = s.nextLine();
            System.out.print("Masukkan nama brand: ");
            String brand = s2.nextLine();
            listSet.add(new SetSetter(barang,brand));
        }
        System.out.println("Isi set adalah: "+listSet);
        System.out.println("Ukuran set saat ini: "+listSet.size());
        System.out.println();
        switchCase();
    }
    public static void addSet(){
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.println("Isi List saat ini: "+listSet.toString());
        System.out.print("Masukkan jumlah barang yang ingin ditambahkan: ");
        int jumlah = in.nextInt();
        in.nextLine();
        for(int i=0; i<jumlah;i++){
            System.out.print("Masukkan nama barang: ");
            String barang = in.nextLine();
            System.out.print("Masukkan nama brand: ");
            String brand = in2.nextLine();
            listSet.add(new SetSetter(barang,brand));
        }
        System.out.println("Isi list sekarang: "+listSet);
        System.out.println("Ukuran list saat ini: "+listSet.size());
        System.out.println();
        switchCase();
    }
    public static void checkSet(){ //btw Set tidak memiliki index karena set unordered
        Scanner in = new Scanner(System.in);
        List<SetSetter> list2 = new ArrayList<>();
        list2.addAll(listSet);
        System.out.println("Masukkan index yang ingin dicek: ");
        int a = in.nextInt();
        System.out.print("Elemen pada index ke-"+a+" adalah: "+list2.get(a));
        System.out.println();
        switchCase();
    }
    public static void konversiSet(){
        Scanner in = new Scanner(System.in);
        System.out.println("Pilihan konversi list");
        System.out.println("1. Set menjadi list");
        System.out.println("2. Set menjadi Map");
        System.out.println("3. Kembali ke menu seblumnya");
        System.out.print("Masukkan pilihan: ");
        int k = in.nextInt();
        System.out.println();
        System.out.println();

        switch (k){
            case 1:
                List<SetSetter> list = new ArrayList<>();
                list.addAll(listSet);
                System.out.println(list);
//                for(SetSetter ob:listSet){
//                    list.add(ob.getBarang(),ob.getBrand());
//                }
                System.out.println();
                System.out.println();
                switchCase();
                break;
            case 2:
                Map<String,String> barangMap = new HashMap<>();
                for(SetSetter ob: listSet){
                    barangMap.put(ob.getBarang(), ob.getBrand());
                }
                System.out.println("Set: "+listSet);
                System.out.println("Map: "+barangMap);
                //Map<String,String> map = new HashMap<>();
                //for(String s : listSet){
                // map.puIfAbsent(s,s);
                //}
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
                break;
        }
    }
}
