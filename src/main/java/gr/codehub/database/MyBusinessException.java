package gr.codehub.database;

public class MyBusinessException extends Exception {
    public MyBusinessException(){
        super();
    }

    public MyBusinessException(String message){
        super(message);
    }
}
