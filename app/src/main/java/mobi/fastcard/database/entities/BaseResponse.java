package mobi.fastcard.database.entities;

/**
 * Created by DELL on 2/15/2016.
 */
public class BaseResponse<T> {
    public String message;
    public int returnCode;
    public T Data;
}
