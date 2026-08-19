package BookManager;

public class Result<T> {
    private boolean success;
    private String message;
    private T data;

    private Result(boolean success,String message,T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data){
        return new Result<T>(true, null, data);

    }

    public static <T> Result<T> failure(String message){
        return new Result<T>(false, message, null);

    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    

}
