package exequiel.ussdwizardhelper;

/**
 * Created by egonzalez on 08/03/18.
 */

public interface MVPWizard {
    interface View{
        void showMessage(String message);
        void changeFab(int imageId, int colorId);
        void changeFabLogic(int state);
    }

    interface Presenter{
        void setView(View View);
        void fabClicked();
    }

    interface Model{
        User getUser();
    }

    interface Repository{
        User getUser();
    }
}
