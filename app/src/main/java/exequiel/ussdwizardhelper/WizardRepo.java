package exequiel.ussdwizardhelper;

import javax.inject.Inject;

import exequiel.ussdwizardhelper.data.LocalStorage;
import exequiel.ussdwizardhelper.data.User;
import rx.Observable;

/**
 * Created by egonzalez on 08/03/18.
 */

public class WizardRepo implements MVPWizard.Repository {

    @Inject
    LocalStorage localStorage;

    public WizardRepo(){

    }

    @Override
    public Observable<User> getUser() {
        return null;
    }

    @Override
    public void saveUser(String uid, String uDate) {
        localStorage.writeString("uid", uid);
        localStorage.writeString("udate", uDate);
    }

}
