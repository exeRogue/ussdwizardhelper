package exequiel.ussdwizardhelper;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import exequiel.ussdwizardhelper.root.App;
import exequiel.ussdwizardhelper.service.USSDAntelPrePayAccesibilityService;

public class MainActivity extends AppCompatActivity implements MVPWizard.View, View.OnClickListener {

    @BindView(R.id.fabAction)
    FloatingActionButton fabAction;

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
        fabAction.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.changeState();
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
        if (checkPermission != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkSIM() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        int state = telephonyManager.getSimState();
        if (state == TelephonyManager.SIM_STATE_READY) {
            return true;
        }
        return false;
    }

    /**
     * Based on https://stackoverflow.com/a/18095283
     * @return
     */
    @Override
    public boolean checkAccesibility() {

        int accessibilityEnabled = 0;
        final String service = getPackageName() + "/" + USSDAntelPrePayAccesibilityService.class.getCanonicalName();
        try {
            accessibilityEnabled = Settings.Secure.getInt(
                    MainActivity.this.getApplicationContext().getContentResolver(),
                    android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException e) {
        }
        TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');

        if (accessibilityEnabled == 1) {
            String settingValue = Settings.Secure.getString(
                    MainActivity.this.getApplicationContext().getContentResolver(),
                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (settingValue != null) {
                mStringColonSplitter.setString(settingValue);
                while (mStringColonSplitter.hasNext()) {
                    String accessibilityService = mStringColonSplitter.next();

                    if (accessibilityService.equalsIgnoreCase(service)) {
                        return true;
                    }
                }
            }
        } else {
        }

        return false;
    }

    @Override
    public void callUSSDService() {

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(ussdToCallableUri("*611#"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        startActivity(callIntent);

    }

    @Override
    public void changeFab(String state) {
        if (state.equals("succes")){
            fabAction.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_done_white_24dp));
            fabAction.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.succes)));
            fabAction.setEnabled(false);
        }
        if (state.equals("registered")){
            fabAction.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.ic_error_outline_white_24dp));
            fabAction.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.error)));
            fabAction.setEnabled(false);
        }
    }

    private Uri ussdToCallableUri(String ussd) {

        String uriString = "";

        if(!ussd.startsWith("tel:"))
            uriString += "tel:";

        for(char c : ussd.toCharArray()) {

            if(c == '#')
                uriString += Uri.encode("#");
            else
                uriString += c;
        }

        return Uri.parse(uriString);
    }

}
