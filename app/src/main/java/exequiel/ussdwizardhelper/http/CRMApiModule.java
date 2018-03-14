package exequiel.ussdwizardhelper.http;

import dagger.Module;
import dagger.Provides;
import exequiel.ussdwizardhelper.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by egonzalez on 14/03/18.
 */

@Module
public class CRMApiModule {
    public final String BASE_URL = BuildConfig.BASE_URL;


    @Provides
    public Retrofit providesRetrofit(String baseUrl) {
        return new Retrofit.Builder().baseUrl(BASE_URL).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Provides
    public CRMApi providesCRMApi(){
        return providesRetrofit(BASE_URL).create(CRMApi.class);
    }
}
