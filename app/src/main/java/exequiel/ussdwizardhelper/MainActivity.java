package exequiel.ussdwizardhelper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;



import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import exequiel.ussdwizardhelper.root.App;

public class MainActivity extends AppCompatActivity  implements MVPWizard.View, View.OnClickListener{

    @BindView(R.id.fabAction)
    FloatingActionButton fabAction;
    @BindView(R.id.textViewState)
    TextView textViewState;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    MVPWizard.Presenter presenter;
    @Inject
    LocalStorage localStorage;
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

    }

    @Override
    public void showMessage(String message) {
        textViewState.setText(message);

    }

    @Override
    public void changeFab(int imageId, int colorId) {

    }

    @Override
    public void changeFabLogic(int state) {

    }
}
