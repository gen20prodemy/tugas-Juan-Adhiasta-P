import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CustomException{
        start();
        //methodBaru();
    }
    public static void start() throws CustomException{
        try {
            System.out.println("Contoh exception: ");
            System.out.println("1. Custom Exception");
            System.out.println("2. Try Catch Finally");
            System.out.println("3. Throw");
            System.out.println("4. Throws");
            System.out.println("5. Keluar");
            System.out.println();
            System.out.print("Silahkah pilih: ");
            Scanner s = new Scanner(System.in);
            int a = s.nextInt(); //inputMismatchException

            switch(a){
                case 1:
                    numberBetween();
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    sum();
                    System.out.println();
                    System.out.println();
                    break;
                case 3:
                    array();
                    System.out.println();
                    System.out.println();
                    break;
                case 4:
                    exampleThrows();
                    System.out.println();
                    System.out.println();
                    break;
                case 5:
                    System.out.println();
                    System.out.println();
                    System.exit(0);
                    break;

            }

        } catch (InputMismatchException | NullPointerException e){
            System.out.println("Mohon masukkan angka");
            System.out.println();
            start();
        }
    }

    public static void numberBetween() throws CustomException{
        Scanner s = new Scanner(System.in);
        System.out.print("Masukkan angka bukan negatif: ");
        int x = s.nextInt();
        if (x < 0){
            throw new CustomException("Salah memasukkan angka");
        }
        System.out.println("Angka yang dimasukkan adalah: "+x);
        System.out.println();
        start();

    }

    public static void array() throws CustomException{
        try {
            Scanner scan = new Scanner(System.in);
            Scanner scan2 = new Scanner(System.in);
            System.out.print("Masukkan elemen dalam array (pisahkan dengan spasi): ");
            String input = scan.nextLine();
            System.out.println(Arrays.toString(input.split(" ")));
            int[] arr = convertToInt(input.split(" "));
            System.out.print("Masukkan indeks yang ingin dicek: ");
            int i = scan2.nextInt();
            if(i < 0 || i > arr.length){
                throw new ArrayIndexOutOfBoundsException("Error, salah indeks");
            } else {
                System.out.print(arr[i]);
            }
            //throw new ArrayIndexOutOfBoundsException("salah indeks");
           System.out.println();
           start();
        } catch (NumberFormatException e){
            System.out.println("Error, kembali ke menu");
            System.out.println();
            start();
        }
    }
    public static void exampleThrows(){
        Scanner s = new Scanner(System.in);
        System.out.print("Masukkan nilai integer: ");
        int a = s.nextInt();
        ThrowExample example = new ThrowExample();
        example.contoh(a);
    }
    public static void sum() throws CustomException{
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("Masukkan elemen dalam Array (pisahkan dengan spasi): ");
            String input = scan.nextLine();
            System.out.println(Arrays.toString(input.split(" ")));
            int[] arr = convertToInt(input.split(" "));

            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            System.out.print("Hasil jumlah elemen: " + sum);
            System.out.println();
            start();
        } catch (NumberFormatException e){
            System.out.println("Error, kembali ke menu");
        } finally {
            System.out.println();
            System.out.println();
            start();
        }
    }
    public static int[] convertToInt(String[] convert){
        int newArray[] = new int[convert.length];
        for(int i = 0; i< convert.length;i++){
            newArray[i] = Integer.parseInt(convert[i]);

        }
        return newArray;

    }
//    public static void methodBaru() throws NumberFormatException{
//        int x = 1;
//        Integer.parseInt("b");
//    }
}