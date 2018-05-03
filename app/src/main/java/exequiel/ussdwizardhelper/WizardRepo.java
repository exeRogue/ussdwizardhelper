package exequiel.ussdwizardhelper;

import android.os.Build;

import exequiel.ussdwizardhelper.data.LocalStorage;
import exequiel.ussdwizardhelper.http.CRMApi;
import exequiel.ussdwizardhelper.http.data.request.K2bExecute;
import exequiel.ussdwizardhelper.http.data.request.UserRequestBody;
import exequiel.ussdwizardhelper.http.data.request.UserRequestEnvelop;
import exequiel.ussdwizardhelper.http.data.response.UserResponseEnvelop;
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
    public Observable<UserResponseEnvelop> getUser() {
        K2bExecute k2bExecute = new K2bExecute();
        k2bExecute.setSerieinterna(Build.SERIAL);
        k2bExecute.setImpceibalprodexternocodigo(Build.MODEL);
        k2bExecute.setImpceibalplanparm(BuildConfig.PLANPARAM);
        k2bExecute.setPsw(BuildConfig.PSW);
        UserRequestBody body = new UserRequestBody();
        body.setK2bExecute(k2bExecute);
        UserRequestEnvelop envelop = new UserRequestEnvelop();
        envelop.setBody(body);
        return mCRMApi.getUser(envelop);
    }

    @Override
    public void saveUser(String uid, String uDate) {
        mlocalStorage.writeString("uid", uid);
        mlocalStorage.writeString("udate", uDate);
    }

    @Override
    public String getState() {
        return mlocalStorage.readValue("state");
    }

    @Override
    public String getNumber() {
        return mlocalStorage.readValue("number");
    }

}
