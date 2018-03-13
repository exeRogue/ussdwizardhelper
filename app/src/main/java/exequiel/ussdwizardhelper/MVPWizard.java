package exequiel.ussdwizardhelper;

import exequiel.ussdwizardhelper.data.User;
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
        void callUSSDService();

    }

    interface Presenter{
        void setView(View View);
        void fabClicked();
    }

    interface Model{
        Observable<User> getUser();
        void saveUser(String uID, String uDate);
    }

    interface Repository{
        Observable<User> getUser();

        void saveUser(String uid, String uDate);
    }
}
