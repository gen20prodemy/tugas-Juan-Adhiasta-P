package Map;

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
    }
    @Override
    public Siswa read(Integer no_id){
        Siswa value = database.get(no_id);
        System.out.println("No id: "+no_id+" = "+value.toString());
        return value;
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
