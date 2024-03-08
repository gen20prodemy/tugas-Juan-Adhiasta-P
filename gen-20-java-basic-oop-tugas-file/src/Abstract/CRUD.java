package Abstract;

import POJO.Pelanggan;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public abstract class CRUD {
    public String filePath; //Coba dibuat private
    public CRUD(String filePath){
        this.filePath = filePath;
    }
    public abstract void addRecord(Pelanggan person);
    public abstract List<Pelanggan> getAllRecord();
    public abstract void updateRecord(String name, Pelanggan updatePerson);
    public abstract void deleteRecord(String name);

}
