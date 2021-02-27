package warehouse;

public class DbReaderException extends Exception{
    String message;
    public DbReaderException (String msg) {
        super(msg);
        message = msg;
    }
    @Override
    public String getMessage(){
        return message;
    }
}
