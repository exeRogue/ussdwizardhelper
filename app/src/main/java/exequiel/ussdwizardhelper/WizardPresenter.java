package exequiel.ussdwizardhelper;

import android.support.annotation.Nullable;
import android.util.Log;

import exequiel.ussdwizardhelper.data.User;
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
            try {
                model.getUser()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<User>() {
                            @Override
                            public void call(User user) {

                                Log.d(TAG, user.getDate()+" "+user.getUid());
                                model.saveUser(user.getUid(), user.getDate());
                                mView.callUSSDService();
                            }

                        });
            }catch (NullPointerException e){
                mView.showMessage(R.string.register_error);

            }
        }
    }


}
