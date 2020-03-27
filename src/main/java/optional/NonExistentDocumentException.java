package optional;

public class NonExistentDocumentException extends Exception{

    public NonExistentDocumentException() {
        super("No such document exists!");
    }
}
