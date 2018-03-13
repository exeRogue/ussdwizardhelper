package exequiel.ussdwizardhelper;

import rx.Observable;

/**
 * Created by egonzalez on 08/03/18.
 */

public interface MVPWizard {
    interface View{
        void showMessage(int messageId);
        boolean checkInternet();
        boolean checkCall();
        boolean checkSIM();
        boolean checkAccesibility();

    }

    interface Presenter{
        void setView(View View);
        void fabClicked();
    }

    interface Model{
        Observable<User> getUser();
    }

    interface Repository{
        Observable<User> getUser();
    }
}
