package ee.ut.digikaardid;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.util.Map;

public class Töökaart extends Kaart implements Serializable {
    public static final String NIMI = "Töökaart";
    private String töökoht;
    private String aadress;
    private String koduleht;
    private String whatsapp;


    public Töökaart(String nimi, String email, String telefoniNumber, String töökoht, String aadress, String koduleht, String whatsapp) {
        super(nimi, email, telefoniNumber);
        this.töökoht = töökoht;
        this.aadress = aadress;
        this.koduleht = koduleht;
        this.whatsapp = whatsapp;
    }

    public String getTöökoht() {
        return töökoht;
    }

    public void setTöökoht(String töökoht) {
        this.töökoht = töökoht;
    }

    public String getAadress() {
        return aadress;
    }

    public void setAadress(String aadress) {
        this.aadress = aadress;
    }

    public String getKoduleht() {
        return koduleht;
    }

    public void setKoduleht(String koduleht) {
        this.koduleht = koduleht;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public static Map<String, TextField> getSisestusväljad() {
        TextField töökohaSisend = new TextField();
        TextField aadressiSisend = new TextField();
        TextField koduleheSisend = new TextField();
        TextField whatsappiSisend = new TextField();

        return Map.of(
                Silt.TÖÖKOHT, töökohaSisend,
                Silt.AADRESS, aadressiSisend,
                Silt.KODULEHT, koduleheSisend,
                Silt.WHATSAPP, whatsappiSisend
        );
    }

    @Override
    public String toString() {
        return "Töökaart" + super.toString() +
                ", töökoht: " + töökoht +
                ", aadress: " + aadress +
                ", koduleht: " + koduleht +
                ", WhatsApp: " + whatsapp;
    }
}
