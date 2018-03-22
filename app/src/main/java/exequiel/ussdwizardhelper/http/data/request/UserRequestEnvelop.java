package exequiel.ussdwizardhelper.http.data.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by egonzalez on 21/03/18.
 */
@Root(name = "soapenv:Envelope")
@NamespaceList({
        @Namespace(prefix = "soapenv", reference = "http://schemas.xmlsoap.org/soap/envelope/"),
        @Namespace(prefix = "k2b", reference="K2BImplantacion")
})
public class UserRequestEnvelop {
    @Element(name = "soapenv:Body", required = false)
    private UserRequestBody body;

    public UserRequestBody getBody() {
        return body;
    }

    public void setBody(UserRequestBody body) {
        this.body = body;
    }
}
