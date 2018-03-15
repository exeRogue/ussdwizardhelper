package exequiel.ussdwizardhelper;

import android.support.annotation.Nullable;
import android.util.Log;

import exequiel.ussdwizardhelper.data.User;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by egonzalez on 08/03/18.
 */

public class WizardPresenter implements MVPWizard.Presenter {


    @Nullable
    private MVPWizard.View mView;
    private final MVPWizard.Model model;
    private String TAG = WizardPresenter.class.getCanonicalName();

    public WizardPresenter(MVPWizard.Model model){
        this.model = model;
    }

    @Override
    public void setView(MVPWizard.View view) {
        mView = view;
    }

    @Override
    public void fabClicked() {
        if (!mView.checkInternet()){
            mView.showMessage(R.string.internet_error);
        }else if (!mView.checkSIM()){
            mView.showMessage(R.string.sim_error);
        }else if (!mView.checkCall()){
            mView.showMessage(R.string.call_error);
        }else if (!mView.checkAccesibility()){
            mView.showMessage(R.string.accesibility_error);
        }else {

            /**
             * Improve these yet i need the ws
             */
                model.getUser()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<User>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                mView.showMessage(R.string.register_error);
                            }

                            @Override
                            public void onNext(User user) {
                                model.saveUser(user.getUid(), user.getDate());
                                mView.callUSSDService();
                            }
                        });
        }
    }

    @Override
    public void changeState() {
        if (model.getSate().equals("registered")){
            mView.changeFab("succes");
        }
        if (model.getSate().equals("registered")){
            mView.changeFab("registered");
        }
    }


}
