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

    public String joonista(int kaardiKülg) {
        StringBuilder sõne = new StringBuilder(5000000);
        String tähis = genereeriTähis();
        String tähis2 = tähis + " ";
        sõne.append(tähis2.repeat(kaardiKülg)).append("\n");

        String rida = kaart.toString();
        String[] osad = rida.trim().split(", ");

        for (int i = 2; i < (kaardiKülg - osad.length) / 4; i++) {
            sõne.append(tähis).append(" ".repeat((kaardiKülg * 2) - 3)).append(tähis);
        }

        for (String s : osad) {
            int tühikuidEnne = (kaardiKülg * 2 - 3 - s.length()) / 2;
            sõne.append(tähis + " ".repeat(((kaardiKülg * 2) - 3 - s.length()) / 2) + s +
                    " ".repeat(((kaardiKülg * 2) - 3 - s.length()) - tühikuidEnne) + tähis).append("\n");
        }

        for (int i = 2; i < (kaardiKülg - osad.length) / 4; i++) {
            sõne.append(tähis + " ".repeat((kaardiKülg * 2) - 3) + tähis);
        }
        sõne.append(tähis2.repeat(kaardiKülg)).append("\n");
        return String.valueOf(sõne);
    }

}
