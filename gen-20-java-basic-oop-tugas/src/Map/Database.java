package Map;

import CustomError.DuplicateIdException;
import Interface.DatabaseInterface;
import POJO.Siswa;

import java.util.HashMap;
import java.util.Map;

public class Database implements DatabaseInterface<Integer, Siswa> {
    private Map<Integer, Siswa> database; //encapsulation

    public Database(){
        this.database = new HashMap<>();
    }
    @Override
    public void create(Integer no_id, Siswa value){
        database.put(no_id,value);
        System.out.println();
        System.out.println("Map berhasil dibuat");
        System.out.println();
    }
    @Override
    public Siswa read(Integer no_id){
        Siswa value = database.get(no_id);
        System.out.println("No id: "+no_id+" = "+value.toString());
        return value;
    }

    @Override
    public void add(Integer no_id, Siswa value) {
        try {
            if (database.containsKey(no_id)) {
                throw new DuplicateIdException("Data id "+no_id+" telah tersedia");
            } else {
                database.put(no_id, value);
                System.out.println("Data berhasil ditambahkan");
            }
        }catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }

    @Override
    public void update(Integer no_id, Siswa newValue){
        if(database.containsKey(no_id)){
            database.put(no_id, newValue);
            System.out.println("Update id: "+no_id+" = "+newValue.toString());
        } else {
            System.out.println("Id tidak ditemukan: "+no_id);
        }
    }
    @Override
    public void delete(Integer no_id) {
        if(database.containsKey(no_id)){
            database.remove(no_id);
            System.out.println("Id dihapus: "+no_id);
        } else {
            System.out.println("Id tidak ditemukan: "+no_id);
        }
    }
    @Override
    public void display() {
        System.out.println("Isi Map: ");
        for(Map.Entry<Integer, Siswa> entry : database.entrySet()){
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
    }
    public void clear(){
        database.clear();
    }
}
