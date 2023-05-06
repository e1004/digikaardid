package ee.ut.digikaardid;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.util.Map;

public class Kaart implements Visiitkaart, Serializable {

    private String nimi;
    private String email;
    private String telefoniNumber;

    public Kaart(String nimi, String email, String telefoniNumber) {
        this.nimi = nimi;
        this.email = email;
        this.telefoniNumber = telefoniNumber;
    }

    @Override
    public String getNimi() {
        return nimi;
    }

    @Override
    public void setNimi(String uusNimi) {
        this.nimi = uusNimi;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String uusEmail) {
        this.email = uusEmail;
    }

    @Override
    public String getTelefoniNumber() {
        return telefoniNumber;
    }

    @Override
    public void setTelefoniNumber(String uusTelefoniNumber) {
        this.telefoniNumber = uusTelefoniNumber;
    }

    public static Map<String, TextField> getSisestusväljad() {
        TextField nimeSisend = new TextField();
        TextField emailiSisend = new TextField();
        TextField telefoniSisend = new TextField();

        return Map.of(
                Silt.NIMI, nimeSisend,
                Silt.EMAIL, emailiSisend,
                Silt.TELEFON, telefoniSisend
        );
    }

    @Override
    public String toString() {
        return ", nimi: " + nimi +
                ", email: " + email +
                ", telefoniNumber: " + telefoniNumber;
    }
}
