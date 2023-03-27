public class Personaalkaart extends Kaart{
    private String kirjeldus;

    public Personaalkaart(String nimi, String email, String telefoniNumber, String kirjeldus) {
        super(nimi, email, telefoniNumber);
        this.kirjeldus = kirjeldus;
    }

    public String getKirjeldus() {
        return kirjeldus;
    }

    public void setKirjeldus(String kirjeldus) {
        this.kirjeldus = kirjeldus;
    }
}