package ee.ut.digikaardid;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Map;

public class Tudengikaart extends Kaart {
    public static final String NIMI = "Tudengikaart";
    private String ülikool;
    private String isicKaart;


    public Tudengikaart(String nimi, String email, String telefoniNumber, String ülikool, String isicKaart) {
        super(nimi, email, telefoniNumber);
        this.ülikool = ülikool;
        this.isicKaart = isicKaart;
    }

    public String getÜlikool() {
        return ülikool;
    }

    public void setÜlikool(String ülikool) {
        this.ülikool = ülikool;
    }

    public String kasIsicKaart() {
        return isicKaart;
    }

    public void setIsicKaart(String isicKaart) {
        this.isicKaart = isicKaart;
    }

    public static Map<String, TextField> getSisestusväljad() {
        TextField ülikooliSisend = new TextField();
        TextField isicKaardiSisend = new TextField();

        return Map.of(
                Silt.ÜLIKOOL, ülikooliSisend,
                Silt.ISIC, isicKaardiSisend
        );
    }

    @Override
    public String toString() {
        return "ee.ut.digikaardid.Tudengikaart" + super.toString() +
                ", ülikool: " + ülikool +
                ", isicKaart: " + isicKaart;
    }
}