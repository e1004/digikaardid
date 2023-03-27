import java.util.Random;

public class Joonistaja{

    private Kaart kaart;
    private int külg;


    public Joonistaja(Kaart kaart) {
        this.kaart = kaart;
    }

    private String genereeriTähis(){
        Random juhuslik = new Random();
        String tähised = "*#-@!";
        return String.valueOf(tähised.charAt(juhuslik.nextInt(tähised.length())));
    }

    public void joonista(int ruuduKülg) {
        String tähis = genereeriTähis();
        System.out.println(tähis.repeat(ruuduKülg));

        for (int i = 2; i < ruuduKülg; i++) {
            System.out.println(tähis + " ".repeat((ruuduKülg * 2) - 3) + tähis);
        }

        System.out.println(kaart.toString());

        System.out.println(tähis.repeat(ruuduKülg));
    }



}
