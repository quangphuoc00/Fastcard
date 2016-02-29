package mobi.fastcard.modules;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;
import mobi.fastcard.R;

/**
 * Created by DELL on 2/15/2016.
 */
public class BaseActivity extends AppCompatActivity implements iBaseView
{
    protected SweetAlertDialog pDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText(getString(R.string.MSGPleaseWait));
        pDialog.setCancelable(false);
    }

    @Override
    public void onShowProgress() {
        pDialog.show();
    }

    @Override
    public void onHideProgress() {
        pDialog.dismiss();
    }
}
