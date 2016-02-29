package mobi.fastcard.modules.login_register.login;

/**
 * Created by DELL on 2/15/2016.
 */
public interface iViewLogin {
    void onInvalidPassword();

    void onInvalidUsername();

    void onLoginSuccess();

    void onLoginFail();
}
