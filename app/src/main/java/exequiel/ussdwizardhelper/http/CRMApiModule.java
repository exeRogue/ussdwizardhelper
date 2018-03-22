package exequiel.ussdwizardhelper.http;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import exequiel.ussdwizardhelper.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by egonzalez on 14/03/18.
 */

@Module
public class CRMApiModule {
    public final String BASE_URL = BuildConfig.BASE_URL;


    @Provides
    public OkHttpClient provideClient(){
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();
    }

    @Provides
    public Retrofit providesRetrofit(String baseUrl, OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create(new Persister(new AnnotationStrategy())))
                .build();
    }

    @Provides
    public CRMApi providesCRMApi(){
        return providesRetrofit(BASE_URL, provideClient()).create(CRMApi.class);
    }
}
