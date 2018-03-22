package exequiel.ussdwizardhelper.http.data.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

/**
 * Created by egonzalez on 21/03/18.
 */
@Root(name = "Nwspersonans:Nwspersona")
@NamespaceList({
        @Namespace(prefix = "Nwspersonans", reference = "K2BImplantacion"),
        @Namespace(prefix = "MVDSuite")
})
public class Nwspersonans {
    @Element(name = "SIns00Id", required=false)
    public String SIns00Id;
    @Element(name = "NPer00Id", required=false)
    public String NPer00Id;
    @Element(name = "NPer00Nom", required=false)
    public String NPer00Nom;
    @Element(name = "NPer00Ape", required=false)
    public String NPer00Ape;
    @Element(name = "NTdp00Id", required=false)
    public String NTdp00Id;
    @Element(name = "NPer00NroDoc", required=false)
    public String NPer00NroDoc;
    @Element(name = "NPai00Id", required=false)
    public String NPai00Id;
    @Element(name = "NPer00FecNac", required=false)
    public String NPer00FecNac;
    @Element(name = "NPer00Sexo", required=false)
    public String NPer00Sexo;
    @Element(name = "NOri00Id", required=false)
    public String NOri00Id;
    @Element(name = "NPer00Obs", required=false)
    public String NPer00Obs;
    @Element(name = "SUsu00Id", required=false)
    public String SUsu00Id;
    @Element(name = "NPer00Activo", required=false)
    public String NPer00Activo;

    public String getSIns00Id() {
        return SIns00Id;
    }

    public void setSIns00Id(String SIns00Id) {
        this.SIns00Id = SIns00Id;
    }

    public String getNPer00Id() {
        return NPer00Id;
    }

    public void setNPer00Id(String NPer00Id) {
        this.NPer00Id = NPer00Id;
    }

    public String getNPer00Nom() {
        return NPer00Nom;
    }

    public void setNPer00Nom(String NPer00Nom) {
        this.NPer00Nom = NPer00Nom;
    }

    public String getNPer00Ape() {
        return NPer00Ape;
    }

    public void setNPer00Ape(String NPer00Ape) {
        this.NPer00Ape = NPer00Ape;
    }

    public String getNTdp00Id() {
        return NTdp00Id;
    }

    public void setNTdp00Id(String NTdp00Id) {
        this.NTdp00Id = NTdp00Id;
    }

    public String getNPer00NroDoc() {
        return NPer00NroDoc;
    }

    public void setNPer00NroDoc(String NPer00NroDoc) {
        this.NPer00NroDoc = NPer00NroDoc;
    }

    public String getNPai00Id() {
        return NPai00Id;
    }

    public void setNPai00Id(String NPai00Id) {
        this.NPai00Id = NPai00Id;
    }

    public String getNPer00FecNac() {
        return NPer00FecNac;
    }

    public void setNPer00FecNac(String NPer00FecNac) {
        this.NPer00FecNac = NPer00FecNac;
    }

    public String getNPer00Sexo() {
        return NPer00Sexo;
    }

    public void setNPer00Sexo(String NPer00Sexo) {
        this.NPer00Sexo = NPer00Sexo;
    }

    public String getNOri00Id() {
        return NOri00Id;
    }

    public void setNOri00Id(String NOri00Id) {
        this.NOri00Id = NOri00Id;
    }

    public String getNPer00Obs() {
        return NPer00Obs;
    }

    public void setNPer00Obs(String NPer00Obs) {
        this.NPer00Obs = NPer00Obs;
    }

    public String getSUsu00Id() {
        return SUsu00Id;
    }

    public void setSUsu00Id(String SUsu00Id) {
        this.SUsu00Id = SUsu00Id;
    }

    public String getNPer00Activo() {
        return NPer00Activo;
    }

    public void setNPer00Activo(String NPer00Activo) {
        this.NPer00Activo = NPer00Activo;
    }
}
