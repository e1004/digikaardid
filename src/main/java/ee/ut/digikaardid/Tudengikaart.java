package ee.ut.digikaardid;

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

    @Override
    public String toString() {
        return "ee.ut.digikaardid.Tudengikaart" + super.toString() +
                ", ülikool: " + ülikool +
                ", isicKaart: " + isicKaart;
    }
}