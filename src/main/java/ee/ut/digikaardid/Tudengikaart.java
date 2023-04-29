public class Tudengikaart extends Kaart {
    private String ülikool;
    private String isicKaart;


    public Tudengikaart(String nimi, String email, String telefoniNumber, String ülikool, boolean isicKaart) {
        super(nimi, email, telefoniNumber);
        this.ülikool = ülikool;
        if (isicKaart){
            this.isicKaart = "Isic kaart olemas";
        } else {
            this.isicKaart = "Isic kaarti pole";
        }
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
        return "Tudengikaart" + super.toString() +
                ", ülikool: " + ülikool +
                ", isicKaart: " + isicKaart;
    }
}