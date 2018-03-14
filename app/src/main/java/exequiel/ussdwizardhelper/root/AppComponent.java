package exequiel.ussdwizardhelper.root;

import javax.inject.Singleton;

import dagger.Component;
import exequiel.ussdwizardhelper.MainActivity;
import exequiel.ussdwizardhelper.WizardModule;
import exequiel.ussdwizardhelper.data.LocalStorage;
import exequiel.ussdwizardhelper.http.CRMApiModule;

/**
 * Created by egonzalez on 08/03/18.
 */

@Singleton
@Component(modules={WizardModule.class, AppModule.class, CRMApiModule.class})
public interface AppComponent {
    void inject(MainActivity target);
}
