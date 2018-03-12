package exequiel.ussdwizardhelper;

import android.content.Context;

import java.util.concurrent.Callable;

import rx.Observable;

/**
 * Created by egonzalez on 12/03/18.
 */

public class SharedPreferencesHelper implements LocalStorage {
    private Context mContext;

    public SharedPreferencesHelper(Context context){
        this.mContext = context;
    }

    @Override
    public void writeState(State state) {
        mContext.getSharedPreferences("appStates",Context.MODE_PRIVATE).edit().putString("state", state.toString()).apply();

    }

    @Override
    public Observable<State> readState() {
        return Observable.fromCallable(new Callable<State>() {
            @Override
            public State call() throws Exception {
                String auxString = mContext.getSharedPreferences("appStates", Context.MODE_PRIVATE).getString("state", State.UNKNOWN_ERROR.toString());
                return State.toState(auxString);
            }
        });
    }
}
