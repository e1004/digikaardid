package ee.ut.digikaardid;

public class Suunamudijakaart extends Kaart {

    public static final String NIMI = "Suunamudijakaart";
    private String instagram;
    private String facebook;
    private String youtube;
    private String tiktok;
    private String twitter;

    public Suunamudijakaart(String nimi, String email, String telefoniNumber, String instagram, String facebook, String youtube, String tiktok, String twitter) {
        super(nimi, email, telefoniNumber);
        this.instagram = instagram;
        this.facebook = facebook;
        this.youtube = youtube;
        this.tiktok = tiktok;
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getTiktok() {
        return tiktok;
    }

    public void setTiktok(String tiktok) {
        this.tiktok = tiktok;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return "ee.ut.digikaardid.Suunamudijakaart" + super.toString() +
                ", instagram: " + instagram +
                ", facebook: " + facebook +
                ", youtube: " + youtube +
                ", tiktok: " + tiktok +
                ", twitter: " + twitter;
    }
}
