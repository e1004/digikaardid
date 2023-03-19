public class Tudengikaart extends Kaart {
    private String ülikool;
    private boolean isicKaart;


    public Tudengikaart(String nimi, String email, String telefoniNumber, String ülikool, boolean isicKaart) {
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

    public boolean kasIsicKaart() {
        return isicKaart;
    }

    public void setIsicKaart(boolean isicKaart) {
        this.isicKaart = isicKaart;
    }
}