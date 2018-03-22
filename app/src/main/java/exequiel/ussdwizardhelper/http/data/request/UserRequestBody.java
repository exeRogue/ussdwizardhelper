package exequiel.ussdwizardhelper.http.data.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by egonzalez on 21/03/18.
 */
@Root(name = "soapenv:Body", strict = false)
public class UserRequestBody {
    @Element(name = "k2b:impceibalwsgetbenefcrm.Execute", required = false)
    public K2bExecute k2bExecute;

    public K2bExecute getK2bExecute() {
        return k2bExecute;
    }

    public void setK2bExecute(K2bExecute k2bExecute) {
        this.k2bExecute = k2bExecute;
    }
}
