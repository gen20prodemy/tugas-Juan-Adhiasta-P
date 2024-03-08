package Main;
import Abstract.CRUD;
import Implement.FileTxt;
import POJO.Pelanggan;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FileMain {
    String filePath = "output.txt";
    public FileMain(){

    }
    public void switchCase(){
        try{
            System.out.println("Input Output - Tugas");
            System.out.println("1. Membuat file");
            System.out.println("2. Mengisi file");
            System.out.println("3. Update file");
            System.out.println("4. Delete file");
            System.out.println("5. Ambil data file");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan: ");
            Scanner s = new Scanner(System.in);
            int p = s.nextInt();

            switch (p) {
                case 1:
                    makeFile();
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    addRecord();
                    System.out.println();
                    System.out.println();
                    break;
                case 3:
                    updateRecord();
                    System.out.println();
                    System.out.println();
                    break;
                case 4:
                    deleteRecord();
                    System.out.println();
                    System.out.println();
                case 5:
                    getRecord();
                    System.out.println();
                    System.out.println();
                case 6:
                    System.exit(0);
                    break;
            }
        } catch(InputMismatchException | NullPointerException e) {
            System.out.println(e);
            System.out.println();
            switchCase();
        }
    }
    public void makeFile(){
        CRUD crud = new FileTxt(filePath);
        FileTxt file = new FileTxt(filePath);
        Scanner s = new Scanner(System.in);
        System.out.print("Masukkan nama file: ");
        String a = s.nextLine();
        file.createFile(a+".txt");
        System.out.println();
        switchCase();
    }
    public void addRecord(){
        CRUD crud = new FileTxt(filePath);
        FileTxt file = new FileTxt(filePath);
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        System.out.print("Masukkan jumlah pelanggan yang ingin ditambah: ");
        int jumlah = s.nextInt();
        s.nextLine();
        for(int i=0;i<jumlah;i++){
            System.out.print("Masukkan nama pelanggan: ");
            String name = s.nextLine();
            System.out.print("Masukkan usia pelanggan: ");
            int usia = s1.nextInt();
            crud.addRecord(new Pelanggan(name,usia));
        }
        System.out.println();
        switchCase();
    }
    public void updateRecord(){
        CRUD crud = new FileTxt(filePath);
        FileTxt file = new FileTxt(filePath);
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner((System.in));
        System.out.print("Masukkan jumlah pelanggan yang ingin diupdate: ");
        int jumlah = s.nextInt();
        s.nextLine();
        for(int i = 0;i<jumlah;i++){
            System.out.print("Masukkan nama pelanggan: ");
            String name = s.nextLine();
            System.out.print("Masukkan usia pelanggan: ");
            int usia = s1.nextInt();
            Pelanggan p = new Pelanggan(name,usia);
            crud.updateRecord(name,p);
        }
        System.out.println();
        switchCase();
    }
    public void deleteRecord(){
        CRUD crud = new FileTxt(filePath);
        FileTxt file = new FileTxt(filePath);
        Scanner s = new Scanner(System.in);
        System.out.print("Masukkan nama yang ingin dihapus: ");
        String name = s.nextLine();
        crud.deleteRecord(name);
        System.out.println();
        switchCase();
    }
    public void getRecord(){
        CRUD crud = new FileTxt(filePath);
        FileTxt file = new FileTxt(filePath);
        System.out.println("Daftar pelanggan: ");
        for(Pelanggan data : crud.getAllRecord()){
            System.out.println(data);
        }
        System.out.println(crud.getAllRecord().toString());
        System.out.println();
        switchCase();
    }
}
