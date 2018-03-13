package exequiel.ussdwizardhelper.root;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import exequiel.ussdwizardhelper.data.LocalStorage;
import exequiel.ussdwizardhelper.data.SharedPrefStorage;

/**
 * Created by egonzalez on 08/03/18.
 */

@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    public LocalStorage provideLocalStorage(Application application){
        return  new SharedPrefStorage(application);
    }
}
