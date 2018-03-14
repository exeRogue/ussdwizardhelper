package exequiel.ussdwizardhelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import exequiel.ussdwizardhelper.data.LocalStorage;
import exequiel.ussdwizardhelper.http.CRMApi;

/**
 * Created by egonzalez on 08/03/18.
 */
@Module
public class WizardModule {

    @Provides
    public MVPWizard.Presenter provideWizarPresenter(MVPWizard.Model model){
        return new WizardPresenter(model);
    }

    @Provides
    public MVPWizard.Model provideModel(MVPWizard.Repository repo){
        return new WizardModel(repo);
    }

    @Singleton
    @Provides
    public MVPWizard.Repository provideRepo(CRMApi crmApi, LocalStorage localStorage){
        return new WizardRepo(crmApi, localStorage);
    }
}
