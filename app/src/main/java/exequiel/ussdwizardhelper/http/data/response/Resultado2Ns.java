package exequiel.ussdwizardhelper.http.data.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by egonzalez on 21/03/18.
 */
@Root(name = "Resultado2ns:Resultado2")
@NamespaceList({
        @Namespace(prefix = "Resultado2ns", reference = "K2BImplantacion"),
        @Namespace(prefix = "K2B")
})
public class Resultado2Ns {

    @Element(name = "Suceso", required = false)
    public String suceso;

    @Element(name = "Mensajes")
    public Mensajescolns mensajescolns;

    public String getSuceso() {
        return suceso;
    }

    public void setSuceso(String suceso) {
        this.suceso = suceso;
    }

    public Mensajescolns getMensajescolns() {
        return mensajescolns;
    }

    public void setMensajescolns(Mensajescolns mensajescolns) {
        this.mensajescolns = mensajescolns;
    }
}
