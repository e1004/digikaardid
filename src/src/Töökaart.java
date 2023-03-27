public class Töökaart extends Kaart{
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
}
