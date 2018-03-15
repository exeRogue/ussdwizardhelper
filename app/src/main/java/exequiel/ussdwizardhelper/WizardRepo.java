package exequiel.ussdwizardhelper;

import android.os.Build;

import javax.inject.Inject;

import exequiel.ussdwizardhelper.data.LocalStorage;
import exequiel.ussdwizardhelper.data.User;
import exequiel.ussdwizardhelper.http.CRMApi;
import rx.Observable;

/**
 * Created by egonzalez on 08/03/18.
 */

public class WizardRepo implements MVPWizard.Repository {

    private final CRMApi mCRMApi;
    private final LocalStorage mlocalStorage;


    public WizardRepo(CRMApi crmApi, LocalStorage localStorage) {
        mCRMApi = crmApi;
        mlocalStorage = localStorage;
    }

    @Override
    public Observable<User> getUser() {
        String serial = Build.SERIAL;
        String model = Build.MODEL;

        return mCRMApi.getUser(serial, model);
    }

    @Override
    public void saveUser(String uid, String uDate) {
        mlocalStorage.writeString("uid", uid);
        mlocalStorage.writeString("udate", uDate);
    }

}
