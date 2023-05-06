package ee.ut.digikaardid;

import javafx.scene.control.TextField;

import java.util.Map;

public class ArendajaKaart extends Kaart {

    public static final String NIMI = "Arendajakaart";
    private String linkedIn;
    private String programmeerimiskeeled;
    private String tudeng;

    public ArendajaKaart(String nimi, String email, String telefoniNumber, String linkedIn, String programmeerimiskeeled, String tudeng) {
        super(nimi, email, telefoniNumber);
        this.linkedIn = linkedIn;
        this.programmeerimiskeeled = programmeerimiskeeled;
        this.tudeng = tudeng;
    }

    public static Map<String, TextField> getSisestusväljad() {
        TextField linkedInSisend = new TextField();
        TextField programmeerimiskeelteSisend = new TextField();
        TextField tudengiSisend = new TextField();

        return Map.of(
                Silt.LINKEDIN, linkedInSisend,
                Silt.PROGRAMMEERIMISKEELED, programmeerimiskeelteSisend,
                Silt.TUDENG, tudengiSisend
        );
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getProgrammeerimiskeeled() {
        return programmeerimiskeeled;
    }

    public void setProgrammeerimiskeeled(String programmeerimiskeeled) {
        this.programmeerimiskeeled = programmeerimiskeeled;
    }

    public String kasTudeng() {
        return tudeng;
    }

    public void setTudeng(String tudeng) {
        this.tudeng = tudeng;
    }

    @Override
    public String toString() {
        return "ee.ut.digikaardid.ArendajaKaart" + super.toString() +
                ", linkedIn: " + linkedIn +
                ", programmeerimiskeeled: " + programmeerimiskeeled +
                ", tudeng: " + tudeng;
    }
}