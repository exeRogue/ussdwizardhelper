package exequiel.ussdwizardhelper.http.data.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by egonzalez on 21/03/18.
 */

@Root(name = "Mensajescolns:Mensajes")
@NamespaceList({
        @Namespace(prefix = "Mensajescolns", reference = "K2B"),
        @Namespace(prefix = "Genexus")
})
public class Mensajescolns {

    @Element(name = "Messages.Message", required = false)
    public MenssagesMessage menssagesMessage;

    public MenssagesMessage getMenssagesMessage() {
        return menssagesMessage;
    }

    public void setMenssagesMessage(MenssagesMessage menssagesMessage) {
        this.menssagesMessage = menssagesMessage;
    }
}
