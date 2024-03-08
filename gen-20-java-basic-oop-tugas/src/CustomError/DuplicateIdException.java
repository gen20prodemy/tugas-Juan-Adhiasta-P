package CustomError;

public class DuplicateIdException extends RuntimeException{
    public DuplicateIdException(String msg){
        super (msg);
    }
}
