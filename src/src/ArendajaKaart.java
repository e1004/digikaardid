import java.util.ArrayList;

public class ArendajaKaart extends Kaart{

    private String linkedIn;
    private String programmeerimiskeeled;
    private boolean tudeng;

    public ArendajaKaart(String nimi, String email, String telefoniNumber, String linkedIn, String programmeerimiskeeled, boolean tudeng) {
        super(nimi, email, telefoniNumber);
        this.linkedIn = linkedIn;
        this.programmeerimiskeeled = programmeerimiskeeled;
        this.tudeng = tudeng;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getProgrammeerimiskeeled() {
        return programmeerimiskeeled;
    }

    public void setProgrammeerimiskeeled(String programmeerimiskeeled) {
        this.programmeerimiskeeled = programmeerimiskeeled;
    }

    public boolean kasTudeng() {
        return tudeng;
    }

    public void setTudeng(boolean tudeng) {
        this.tudeng = tudeng;
    }
}