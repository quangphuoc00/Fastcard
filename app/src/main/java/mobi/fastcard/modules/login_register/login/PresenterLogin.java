package mobi.fastcard.modules.login_register.login;

import mobi.fastcard.constants.ReturnCode;
import mobi.fastcard.database.API.ApiConnector;
import mobi.fastcard.database.entities.BaseResponse;
import mobi.fastcard.database.entities.UserPOJO;
import mobi.fastcard.helpers.DataEntitiesHelper;
import mobi.fastcard.modules.BasePresenter;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by DELL on 2/15/2016.
 */
public class PresenterLogin extends BasePresenter<iViewLogin> {
    private Subscription loginSubscription;
    private DataEntitiesHelper dataEntitiesHelper;
    public PresenterLogin()
    {
        dataEntitiesHelper = new DataEntitiesHelper();
    }
    @Override
    public void unSubscribeSubscription() {
        if(loginSubscription != null)
            loginSubscription.unsubscribe();
    }

    public void Login(String username, String password)
    {
        if(dataEntitiesHelper.isValidPassword(password))
        {
            iView.onInvalidPassword();
            return;
        }
        if(dataEntitiesHelper.isValidUsername(username))
        {
            iView.onInvalidUsername();
            return;
        }
        ApiConnector.getInstance().Login(username, password)
                                    .compose(this.<BaseResponse<UserPOJO>>applySchedulers())
                                    .subscribe(new Action1<BaseResponse<UserPOJO>>() {
                                        @Override
                                        public void call(BaseResponse<UserPOJO> response) {
                                            if(response.returnCode == ReturnCode.SUCCESS)
                                                iView.onLoginSuccess();
                                            else
                                                iView.onLoginFail();
                                        }
                                    });

    }
}
