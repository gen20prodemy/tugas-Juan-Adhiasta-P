package Implement;
import Abstract.CRUD;
import POJO.Pelanggan;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class FileTxt extends CRUD{

    public FileTxt(String filePath){
        super(filePath);
    }
    @Override
    public void addRecord(Pelanggan person) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))){
            writer.write(person.getName() +","+person.getUsia());
            writer.newLine();
        } catch (IOException e){
            System.err.println(e);
        }
    }
    @Override
    public List<Pelanggan> getAllRecord() {
        List<Pelanggan> records = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Pelanggan pelanggan = new Pelanggan(data[0], Integer.parseInt(data[1]));
                records.add(pelanggan);
            }
        }catch (IOException e){
            System.err.println(e);
        }
            return records;
        }

    @Override
    public void updateRecord(String name, Pelanggan updatePerson) {
        List<Pelanggan> records = getAllRecord();
        List<Pelanggan> updatedRecords = new ArrayList<>();

        for (Pelanggan pelanggan : records){
            if(pelanggan.getName().equals(name)){
                updatedRecords.add(updatePerson);
            } else {
                updatedRecords.add(pelanggan);
            }
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for(Pelanggan pelanggan : updatedRecords){
                writer.write(pelanggan.getName() + "," + pelanggan.getUsia());
                writer.newLine();
            }
        } catch (IOException e){
            System.err.println(e);
        }
    }

    @Override
    public void deleteRecord(String name) {
        List<Pelanggan> records = getAllRecord();
        List<Pelanggan> updatedRecords = new ArrayList<>();

        for(Pelanggan pelanggan : records){
            if(!pelanggan.getName().equals(name)){
                updatedRecords.add(pelanggan);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for(Pelanggan pelanggan : updatedRecords){
                writer.write(pelanggan.getName() + "," + pelanggan.getUsia());
                writer.newLine();
            }
        } catch (IOException e){
            System.err.println(e);
        }
    }
    public void createFile(String filePath){
        File file = new File(filePath);
        if(!file.exists()){
            try{
                file.createNewFile();
            } catch (IOException e){
                System.err.println(e);
            }
        }
    }
}



