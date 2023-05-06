package ee.ut.digikaardid;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Map;

public class Personaalkaart extends Kaart {

    public static final String NIMI = "Personaalkaart";
    private String kirjeldus;

    public Personaalkaart(String nimi, String email, String telefoniNumber, String kirjeldus) {
        super(nimi, email, telefoniNumber);
        this.kirjeldus = kirjeldus;
    }

    public static Map<String, TextField> getSisestusväljad() {
        return Map.of(Silt.KIRJELDUS, new TextField());
    }

    public String getKirjeldus() {
        return kirjeldus;
    }

    public void setKirjeldus(String kirjeldus) {
        this.kirjeldus = kirjeldus;
    }

    @Override
    public String toString() {
        return "ee.ut.digikaardid.Personaalkaart" + super.toString() +
                ", kirjeldus: " + kirjeldus;
    }
}
