package exequiel.ussdwizardhelper.http.data.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by egonzalez on 21/03/18.
 */
@Root(name = "SOAP-ENV:Envelope")
@NamespaceList({
        @Namespace(prefix = "SOAP-ENV", reference="http://schemas.xmlsoap.org/soap/envelope/"),
        @Namespace(prefix = "xsd", reference="http://www.w3.org/2001/XMLSchema"),
        @Namespace(prefix = "SOAP-ENC", reference="http://schemas.xmlsoap.org/soap/encoding/"),
        @Namespace(prefix = "xsi", reference="http://www.w3.org/2001/XMLSchema-instance")
})
public class UserResponseEnvelop {
    @Element(name = "Body", required = false)
    private UserResponseBody body;

    public UserResponseBody getBody() {
        return body;
    }

    public void setBody(UserResponseBody body) {
        this.body = body;
    }
}
