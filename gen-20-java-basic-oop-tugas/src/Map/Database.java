package Map;

import Interface.DatabaseInterface;
import java.util.HashMap;
import java.util.Map;

public class Database implements DatabaseInterface<Integer,String> {
    private Map<Integer,String> database; //encapsulation

    public Database(){
        this.database = new HashMap<>();
    }
    @Override
    public void create(Integer no_id, String namaSiswa){
        database.put(no_id,namaSiswa);
    }
    @Override
    public String read(Integer no_id){
        String key = database.get(no_id);
        System.out.println("No id: "+no_id+" = "+key);
        return key;
    }
    @Override
    public void update(Integer no_id, String namaBaru){
        if(database.containsKey(no_id)){
            database.put(no_id, namaBaru);
            System.out.println("Update id: "+no_id+" = "+namaBaru);
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
}
