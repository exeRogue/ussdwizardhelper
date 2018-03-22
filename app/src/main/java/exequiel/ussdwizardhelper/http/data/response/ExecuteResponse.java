package exequiel.ussdwizardhelper.http.data.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by egonzalez on 21/03/18.
 */
@Root(name = "impceibalwsgetbenefcrm.ExecuteResponse")
@NamespaceList({
        @Namespace(prefix = "impceibalwsgetbenefcrm.ExecuteResponse")
})
public class ExecuteResponse {
    @Element(name = "Resultado2", required = false)
    public Resultado2Ns resultado2Ns;

    @Element(name = "Nwspersona", required = false)
    public Nwspersonans nwspersonans;

    public Resultado2Ns getResultado2Ns() {
        return resultado2Ns;
    }

    public void setResultado2Ns(Resultado2Ns resultado2Ns) {
        this.resultado2Ns = resultado2Ns;
    }

    public Nwspersonans getNwspersonans() {
        return nwspersonans;
    }

    public void setNwspersonans(Nwspersonans nwspersonans) {
        this.nwspersonans = nwspersonans;
    }
}
