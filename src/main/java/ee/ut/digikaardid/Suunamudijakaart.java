package ee.ut.digikaardid;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Map;

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

    public static Map<String, TextField> getSisestusväljad() {
        TextField instagramiSisend = new TextField();
        TextField facebookiSisend = new TextField();
        TextField youtubeiSisend = new TextField();
        TextField tiktokiSisend = new TextField();
        TextField twitteriSisend = new TextField();

        return Map.of(
                Silt.INSTAGRAM, instagramiSisend,
                Silt.FACEBOOK, facebookiSisend,
                Silt.YOUTUBE, youtubeiSisend,
                Silt.TIKTOK, tiktokiSisend,
                Silt.TWITTER, twitteriSisend
        );
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
