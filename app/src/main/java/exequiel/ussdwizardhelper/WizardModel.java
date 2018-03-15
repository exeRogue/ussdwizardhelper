package exequiel.ussdwizardhelper;

import exequiel.ussdwizardhelper.data.User;
import rx.Observable;

/**
 * Created by egonzalez on 08/03/18.
 */

public class WizardModel implements MVPWizard.Model{

    private MVPWizard.Repository repo;

    public WizardModel(MVPWizard.Repository repo){
        this.repo = repo;
    }

    @Override
    public Observable<User> getUser() {
        return repo.getUser();
    }

    @Override
    public void saveUser(String uID, String uDate) {
        repo.saveUser(uID, uDate);
    }

    @Override
    public String getSate() {
        return repo.getState();
    }
}
