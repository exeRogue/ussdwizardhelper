package exequiel.ussdwizardhelper;

import exequiel.ussdwizardhelper.http.data.response.UserResponseEnvelop;
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

        void changeText(String state);
    }

    interface Presenter{
        void setView(View View);
        void fabClicked();

        void rxUnsubscribe();

        void changeState();
    }

    interface Model{
        Observable<UserResponseEnvelop> getUser();
        void saveUser(String uID, String uDate);

        String getSate();
    }

    interface Repository{
        Observable<UserResponseEnvelop> getUser();

        void saveUser(String uid, String uDate);

        String getState();
    }
}
