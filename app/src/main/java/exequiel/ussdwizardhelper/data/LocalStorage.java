package exequiel.ussdwizardhelper.data;

import rx.Observable;

/**
 * Created by egonzalez on 13/03/18.
 */

public interface LocalStorage {
    void writeString(String key, String value);
    String readValue(String key);
    void clearStorage();
}
