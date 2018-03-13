package exequiel.ussdwizardhelper;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import exequiel.ussdwizardhelper.root.App;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity  implements MVPWizard.View, View.OnClickListener{

    @BindView(R.id.fabAction)
    FloatingActionButton fabAction;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    MVPWizard.Presenter presenter;

    private String TAG = "MainActivity";

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        fabAction.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        presenter.fabClicked();
    }

    @Override
    public void showMessage(int messageId) {
        Snackbar.make(findViewById(R.id.myCoordinatorLayout), messageId, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean checkInternet() {
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (mWifi.isConnected()) {
        return true;
        }

        return false;
    }

    @Override
    public boolean checkCall() {
        int checkPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (checkPermission != PackageManager.PERMISSION_GRANTED)
        {
            return false;
        }
            return true;
    }

    @Override
    public boolean checkSIM() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        int state = telephonyManager.getSimState();
        if (state == TelephonyManager.SIM_STATE_READY){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkAccesibility() {
        return false;
    }


}
