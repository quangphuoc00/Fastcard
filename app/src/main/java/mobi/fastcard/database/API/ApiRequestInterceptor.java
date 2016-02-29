package mobi.fastcard.database.API;


import retrofit.RequestInterceptor;

/**
 * Created by My-PC on 11/5/2015.
 */
public class ApiRequestInterceptor implements RequestInterceptor
{
    @Override
    public void intercept(RequestFacade request)
    {
        //TODO add header Interceptor
//        request.addHeader("SessionID", UserDAO.getInstance(Global.context).LoadToLocal().SessionId);
//        request.addHeader("EmployeeId", String.valueOf(UserDAO.getInstance(Global.context).LoadToLocal().Id));
    }
}