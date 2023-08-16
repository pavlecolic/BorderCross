package exceptions;

public class InvalidIDException extends Exception {
    public InvalidIDException() {
        super("Invalid ID");
    }
    public InvalidIDException(String messg){
        super(messg);
    }
}
