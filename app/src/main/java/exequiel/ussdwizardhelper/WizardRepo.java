package exequiel.ussdwizardhelper;

import rx.Observable;

/**
 * Created by egonzalez on 08/03/18.
 */

public class WizardRepo implements MVPWizard.Repository {

    public WizardRepo(){

    }

    @Override
    public Observable<User> getUser() {
        return null;
    }
}
