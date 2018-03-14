package exequiel.ussdwizardhelper.root;

import android.app.Application;

import dagger.Component;
import exequiel.ussdwizardhelper.WizardModule;
import exequiel.ussdwizardhelper.http.CRMApiModule;

/**
 * Created by egonzalez on 08/03/18.
 */

public class App extends Application {
    private AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerAppComponent.builder().
                appModule(new AppModule(this))
                .wizardModule(new WizardModule())
                .cRMApiModule(new CRMApiModule()).build();
    }

    public AppComponent getComponent() {
        return mComponent;
    }
}
