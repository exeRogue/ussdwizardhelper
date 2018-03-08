package exequiel.ussdwizardhelper.root;

import javax.inject.Singleton;

import dagger.Component;
import exequiel.ussdwizardhelper.MainActivity;
import exequiel.ussdwizardhelper.WizardModel;
import exequiel.ussdwizardhelper.WizardModule;

/**
 * Created by egonzalez on 08/03/18.
 */

@Singleton
@Component(modules={WizardModule.class, AppModule.class})
public interface AppComponent {
    void inject(MainActivity target);
}
