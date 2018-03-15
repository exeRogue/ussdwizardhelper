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

        void changeFab(String state);
    }

    interface Presenter{
        void setView(View View);
        void fabClicked();

        void changeState();
    }

    interface Model{
        Observable<User> getUser();
        void saveUser(String uID, String uDate);

        String getSate();
    }

    interface Repository{
        Observable<User> getUser();

        void saveUser(String uid, String uDate);

        String getState();
    }
}
