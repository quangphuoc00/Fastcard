package mobi.fastcard.database.DAO;

import android.content.Context;
import android.content.SharedPreferences;

import mobi.fastcard.database.entities.UserPOJO;

/**
 * Created by DELL on 2/15/2016.
 */
public class UserDAO {
    private static UserDAO instance = null;
    private UserPOJO userInfo;
    private SharedPreferences preferences;
    private UserDAO(Context context){
        preferences = context.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
    }

    public static UserDAO getInstance(Context context) {
        if (instance == null)
            instance = new UserDAO(context);
        return instance;
    }

    public void SaveLocal(UserPOJO userPOJO){
        this.userInfo = userPOJO;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("Id", userInfo.Id);
        //TODO add more.
        editor.apply();
    }

    public UserPOJO GetUserInfo()
    {
        if(userInfo == null) {
            userInfo = new UserPOJO();
            userInfo.Id = preferences.getInt("Id", -1);
        }
        return userInfo;
    }

    public void Login()
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("IsLogin", true);
        editor.commit();
    }

    public void Logout()
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("IsLogin", false);
        editor.clear();
        editor.commit();
    }

    public boolean isLogin()
    {
       return preferences.getBoolean("isLogin", false);
    }
}
