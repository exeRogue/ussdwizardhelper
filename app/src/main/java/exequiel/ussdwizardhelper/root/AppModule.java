package exequiel.ussdwizardhelper.root;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import exequiel.ussdwizardhelper.LocalStorage;
import exequiel.ussdwizardhelper.SharedPreferencesHelper;

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
    LocalStorage provideLocalStorage(Application context){
        return  new SharedPreferencesHelper(context);
    }
}
