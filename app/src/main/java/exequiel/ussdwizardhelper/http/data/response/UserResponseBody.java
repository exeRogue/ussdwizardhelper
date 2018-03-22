package exequiel.ussdwizardhelper.http.data.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by egonzalez on 21/03/18.
 */
@Root(name = "SOAP-ENV:Body", strict = false)
public class UserResponseBody {
    @Element(name = "impceibalwsgetbenefcrm.ExecuteResponse", required = false)
    public ExecuteResponse executeResponse;

    public ExecuteResponse getExecuteResponse() {
        return executeResponse;
    }

    public void setExecuteResponse(ExecuteResponse executeResponse) {
        this.executeResponse = executeResponse;
    }
}
