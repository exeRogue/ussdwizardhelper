package exequiel.ussdwizardhelper.http;


import exequiel.ussdwizardhelper.http.data.request.UserRequestEnvelop;
import exequiel.ussdwizardhelper.http.data.response.UserResponseEnvelop;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by egonzalez on 14/03/18.
 */

public interface CRMApi {
    @Headers({
            "Content-Type: text/xml",
            "Accept-Charset: utf-8"
    })
    @POST("/k2b/servlet/aimpceibalwsgetbenefcrm?wsdl")
    Observable<UserResponseEnvelop> getUser(@Body UserRequestEnvelop body);
}
