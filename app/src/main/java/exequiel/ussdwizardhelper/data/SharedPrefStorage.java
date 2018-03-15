package exequiel.ussdwizardhelper.data;

import android.content.Context;

import java.util.concurrent.Callable;

import rx.Observable;

/**
 * Created by egonzalez on 13/03/18.
 */

public class SharedPrefStorage implements  LocalStorage{
    private Context mContext;

    public SharedPrefStorage(Context context) {
            mContext = context;
    }

    @Override
    public void writeString(String key, String value) {
        mContext.getSharedPreferences("mySharedPrefDB", Context.MODE_PRIVATE).edit().putString(key, value).apply();
    }

    @Override
    public String readValue(final String key) {
                return mContext.getSharedPreferences("mySharedPrefDB", Context.MODE_PRIVATE).getString(key, "");
         }
}
