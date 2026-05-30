package BookManager;

public class StockNotEnoughException extends Exception {
   public StockNotEnoughException(){
        super();
    }
    public StockNotEnoughException(String message){
        super(message);
    }
}
