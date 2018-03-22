package exequiel.ussdwizardhelper.http.data.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by egonzalez on 21/03/18.
 */
@Root(name = "k2b:impceibalwsgetbenefcrm.Execute", strict = false)
public class K2bExecute {
    @Element(name = "k2b:Psw", required = false)
    public String psw;
    @Element(name = "k2b:Impceibalplanparm", required =  false)
    public String impceibalplanparm;
    @Element(name = "k2b:Impceibalprodexternocodigo", required = false)
    public String impceibalprodexternocodigo;
    @Element(name = "k2b:Serieinterna", required = false)
    public String serieinterna;

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getImpceibalplanparm() {
        return impceibalplanparm;
    }

    public void setImpceibalplanparm(String impceibalplanparm) {
        this.impceibalplanparm = impceibalplanparm;
    }

    public String getImpceibalprodexternocodigo() {
        return impceibalprodexternocodigo;
    }

    public void setImpceibalprodexternocodigo(String impceibalprodexternocodigo) {
        this.impceibalprodexternocodigo = impceibalprodexternocodigo;
    }

    public String getSerieinterna() {
        return serieinterna;
    }

    public void setSerieinterna(String serieinterna) {
        this.serieinterna = serieinterna;
    }
}

