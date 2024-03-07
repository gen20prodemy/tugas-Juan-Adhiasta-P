package Interface;

public interface DatabaseInterface<Integer, String> {
    void create(Integer no_id, String namaSiswa);
    String read(Integer no_id);
    void update(Integer no_id, String namaBaru);
    void delete(Integer no_id);
    abstract void display();
    void clear();
}
