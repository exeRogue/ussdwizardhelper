package exequiel.ussdwizardhelper;

import android.support.annotation.Nullable;

/**
 * Created by egonzalez on 08/03/18.
 */

public class WizardPresenter implements MVPWizard.Presenter {


    @Nullable
    private MVPWizard.View mView;
    private final MVPWizard.Model model;

    public WizardPresenter(MVPWizard.Model model){
        this.model = model;
    }

    @Override
    public void setView(MVPWizard.View view) {
        this.mView = view;
    }

    @Override
    public void fabClicked() {

    }
}
