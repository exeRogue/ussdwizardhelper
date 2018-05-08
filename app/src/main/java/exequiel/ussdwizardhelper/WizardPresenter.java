package exequiel.ussdwizardhelper;

import android.support.annotation.Nullable;
import android.util.Log;

import exequiel.ussdwizardhelper.http.data.response.Nwspersonans;
import exequiel.ussdwizardhelper.http.data.response.UserResponseEnvelop;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by egonzalez on 08/03/18.
 */

public class WizardPresenter implements MVPWizard.Presenter {


    @Nullable
    private MVPWizard.View mView;
    private final MVPWizard.Model model;
    private String TAG = WizardPresenter.class.getCanonicalName();
    private Subscription subscription;

    public WizardPresenter(MVPWizard.Model model) {
        this.model = model;
    }

    @Override
    public void setView(MVPWizard.View view) {
        mView = view;
    }

    @Override
    public void fabClicked() {
        if (!mView.checkInternet()) {
            mView.showMessage(R.string.internet_error);
        } else if (!mView.checkSIM()) {
            mView.showMessage(R.string.sim_error);
        } else if (!mView.checkCall()) {
            mView.showMessage(R.string.call_error);
        } else if (!mView.checkAccesibility()) {
            mView.showMessage(R.string.accesibility_error);
        } else {
            boolean bRegistered = model.getSate().equals("registered") ;
            boolean bSucces = model.getSate().equals("succes");
            boolean bRegisteredSucces = model.getSate().equals("register_succes");
            boolean bGetNumber = bRegistered || bSucces || bRegisteredSucces;
            Log.d(TAG, bRegistered + "" + bSucces);
            if (!bGetNumber) {
                subscription = model.getUser()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<UserResponseEnvelop>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.showMessage(R.string.api_error);
                            }

                            @Override
                            public void onNext(UserResponseEnvelop user) {
                                String suceso = user.getBody().getExecuteResponse().getResultado2Ns().getSuceso();
                                Log.d(TAG, suceso);
                                if (suceso.equals("1")) {
                                    Nwspersonans nwspersonans = user.getBody().getExecuteResponse().getNwspersonans();
                                    Log.d(TAG, nwspersonans.toString());
                                    String uId = nwspersonans.getNPer00NroDoc();
                                    String uDate = nwspersonans.getNPer00FecNac();
                                    model.saveUser(uId, uDate);
                                    mView.callUSSDToRegister();
                                } else {
                                    mView.showMessage(R.string.register_error);
                                }
                            }
                        });
            } else {
                String state = model.getSate();
                String number = model.getNumber();
                boolean bNumber = !number.equals("");
                boolean bRegisterSucces = state.equals("register_succes");
                if (!bNumber && bRegisterSucces) {
                    if (mView.checkSIM()) {
                        mView.callUSSDForNumber();
                    } else {
                        mView.showMessage(R.string.sim_error);
                    }
                }
            }
        }
    }

    @Override
    public void changeState() {
        String state = model.getSate();
        if (state.equals("register_succes"))
        {
            mView.changeFab("register_succes");
            mView.changeText("register_succes");

        }
        if (state.equals("succes")) {
            mView.changeFab("succes");
            mView.changeText("succes");

        }
        if (state.equals("registered")) {
            mView.changeFab("registered");
            mView.changeText("registered");
        }

        String number = model.getNumber();
        boolean bNumber = !number.equals("");
        if (bNumber){
            mView.showTextYorNumberIs();
            mView.showTextNumber(number);

        }
    }


    @Override
    public void rxUnsubscribe() {
        if (subscription != null) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }


}
