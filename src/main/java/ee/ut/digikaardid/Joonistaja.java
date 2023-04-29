package ee.ut.digikaardid;

import java.util.Random;

public class Joonistaja {

    private Kaart kaart;


    public Joonistaja(Kaart kaart) {
        this.kaart = kaart;
    }

    private String genereeriTähis() {
        Random juhuslik = new Random();
        String tähised = "*#-@!";
        return String.valueOf(tähised.charAt(juhuslik.nextInt(tähised.length())));
    }

    public void joonista(int kaardiKülg) {
        String tähis = genereeriTähis();
        String tähis2 = tähis + " ";
        System.out.println(tähis2.repeat(kaardiKülg));

        String rida = kaart.toString();
        String[] osad = rida.trim().split(", ");

        for (int i = 2; i < (kaardiKülg - osad.length) / 4; i++) {
            System.out.println(tähis + " ".repeat((kaardiKülg * 2) - 3) + tähis);
        }

        for (int i = 0; i < osad.length; i++) {
            int tühikuidEnne = (kaardiKülg * 2 - 3 - osad[i].length()) / 2;
            System.out.println(tähis + " ".repeat(((kaardiKülg * 2) - 3 - osad[i].length()) / 2) + osad[i] +
                    " ".repeat(((kaardiKülg * 2) - 3 - osad[i].length()) - tühikuidEnne) + tähis);
        }

        for (int i = 2; i < (kaardiKülg - osad.length) / 4; i++) {
            System.out.println(tähis + " ".repeat((kaardiKülg * 2) - 3) + tähis);
        }
        System.out.println(tähis2.repeat(kaardiKülg));
    }

}
