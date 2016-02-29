package mobi.fastcard.database.API;

import mobi.fastcard.database.entities.BaseResponse;
import mobi.fastcard.database.entities.UserPOJO;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by My-PC on 11/5/2015.
 */
public interface ApiService {
    @FormUrlEncoded
    @POST("/EmployeeLogin")
    Observable<BaseResponse<UserPOJO>> Login(@Field("Username") String Username,
                                             @Field("Password") String Password);
//
//    @POST("/GetAllCategory")
//    void GetAllCategory(@Body String fieldEmpty, Callback<BaseResponse<List<categories>>> callback);
//
//    @GET("/GetAllProduct")
//    void GetAllProduct(Callback<BaseResponse<List<product>>> callback);
//
//    @GET("/GetListTelephonist")
//    void GetAllSwitchboard(Callback<BaseResponse<List<SwitchboardPOJO>>> callback);
//
//    @POST("/UpdateListBillSaled")
//    Observable<BaseResponse<SaleOnFeetResponse>> SaleOnFeet(@Body List<SaleOnFeetRequest> lstBill);
//
//    @FormUrlEncoded
//    @POST("/ChangeBillStatusFromEmployee")
//    void ChangeStatusBill(@Field("BillId") int BillId,
//                          @Field("Status") int Status,
//                          @Field("Modified") long Modified,
//                          Callback<BaseResponse> callback);
}
