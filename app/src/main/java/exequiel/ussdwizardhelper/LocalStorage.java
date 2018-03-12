package exequiel.ussdwizardhelper;

import rx.Observable;

/**
 * Created by egonzalez on 12/03/18.
 */

public interface LocalStorage {
    void writeState(State sate);
    Observable<State> readState();
}
