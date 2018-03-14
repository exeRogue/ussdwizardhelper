package exequiel.ussdwizardhelper.http;


import java.util.List;

import exequiel.ussdwizardhelper.data.User;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by egonzalez on 14/03/18.
 */

public interface CRMApi {
    @GET("/getUser")
    Observable<User> getUser(
            @Query("serial") String serial,
            @Query("model") String model
    );
}
