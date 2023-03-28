import java.io.*;
import java.util.Scanner;
//Mari Mets;Mari@gmail.com;563497;-;Liiva 5;-;Mari Mets
public class DialoogiHaldur {

    private static final String failinimi = "visiitkaardiAndmed.csv";
    private static final String samadIsendiväljad = "Nimi, email, telefoninumber, ";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Kas soovid lisada visiitkaarti?");
        String tegevus = in.nextLine();
        if (tegevus.equals("jah")) {
            küsiAndmeid();
            System.out.println("Kas soovid väljastada visiitkaarti?");
            String jahEi = in.nextLine();

            if (jahEi.equals("jah")) {
                Kaart kaart = loeAndmedFailist(failinimi);
                Joonistaja joonistaja = new Joonistaja(kaart);
                String rida = kaart.toString();
                String[] osad = rida.trim().split(", ");
                int pikim = 0;
                for (int i = 0; i < osad.length; i++) {
                    if (pikim < osad[i].length())
                        pikim = osad[i].length();
                }
                joonistaja.joonista(pikim + 6);
            }
        }
    }

    public static void küsiAndmeid() {

        Scanner in = new Scanner(System.in);

        System.out.println("Visiitkaardi valikud:");
        System.out.println("Töökaart, Personaalkaart, Arendajakaart, Tudengikaart, Suunamudijakaart");
        String vastus = in.nextLine();
        switch (vastus) {
            case "Töökaart" -> {
                System.out.println("Nõutud andmed sisesta semikooloniga (info puudumisel, sisesta \"-\"):");
                System.out.println("Nimi, email, telefoninumber, töökoht, aadress, koduleht, WhatsApp");
                String andmed = in.nextLine();
                sisestaAndmedFaili(andmed);
            }
            case "Personaalkaart" -> {
                System.out.println("Nõutud andmed sisesta semikooloniga (info puudumisel, sisesta \"-\"):");
                System.out.println("Nimi, email, telefoninumber, kirjeldus endast");
                String andmed = in.nextLine();
                sisestaAndmedFaili(andmed);
            }
            case "Arendajakaart" -> {
                System.out.println("Nõutud andmed sisesta semikooloniga (info puudumisel, sisesta \"-\"):");
                System.out.println(samadIsendiväljad + "linkedIn, programmmeerimiskeeled, Kas tudeng?");
                String andmed = in.nextLine();
                sisestaAndmedFaili(andmed);
            }
            case "Tudengikaart" -> {
                System.out.println("Nõutud andmed sisesta semikooloniga (info puudumisel, sisesta \"-\"):");
                System.out.println(samadIsendiväljad + "ülikool, Kas isic kaart olemas?");
                String andmed = in.nextLine();
                sisestaAndmedFaili(andmed);
            }
            case "Suunamudijakaart" -> {
                System.out.println("Nõutud andmed sisesta semikooloniga (info puudumisel, sisesta \"-\"):");
                System.out.println("Nimi, email, telefoninumber, Instagram, Facebook, YouTube, TikTok, Twitter");
                String andmed = in.nextLine();
                sisestaAndmedFaili(andmed);
            }
        }
    }

    public static void sisestaAndmedFaili(String andmed) {
        try {
            File fail = new File(failinimi);
            if (fail.exists()) {
                System.out.println("Fail olemas: " + fail.getName());
                FileWriter kirjuta = new FileWriter(failinimi, true);
                BufferedWriter bw = new BufferedWriter(kirjuta);
                bw.newLine();
                bw.append(andmed);
                bw.close();
                kirjuta.close();
            } else {
                System.out.println("Fail loodud: " + fail.getName());
                FileWriter kirjuta = new FileWriter(failinimi);
                kirjuta.write(andmed);
                kirjuta.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Kaart loeAndmedFailist(String failinimi) {
        try {
            File file = new File(failinimi);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] rida = scanner.nextLine().split(";");
                if (rida.length == 4) {
                    return new Personaalkaart(rida[0], rida[1].strip(), rida[2].strip(), rida[3].strip());
                } else if (rida.length == 5) {
                    return new Tudengikaart(rida[0], rida[1].strip(), rida[2].strip(), rida[3].strip(), true);
                } else if (rida.length == 6) {
                    return new ArendajaKaart(rida[0], rida[1].strip(), rida[2].strip(), rida[3].strip(), rida[4].strip(), true);
                } else if (rida.length == 7) {
                    return new Töökaart(rida[0], rida[1].strip(), rida[2].strip(), rida[3].strip(), rida[4].strip(), rida[5].strip(), rida[6].strip());
                } else if (rida.length == 8) {
                    return new Suunamudijakaart(rida[0], rida[1].strip(), rida[2].strip(), rida[3].strip(), rida[4].strip(), rida[5].strip(), rida[6].strip(), rida[7].strip());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
