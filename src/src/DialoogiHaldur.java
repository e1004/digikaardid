import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DialoogiHaldur {

    private static final String failinimi = "visiitkaardiAndmed.txt";
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Kas soovid muuta, kustutada või lisada visiitkaarti?");
        String tegevus = in.nextLine();
        if (tegevus.equals("muuta")){
            //
        } else if (tegevus.equals("kustutada")){
            System.out.println("Milline");
            kustutaVisiitkaart();
        } else if (tegevus.equals("lisada")){
            küsiAndmeid();
            System.out.println("Kas soovid väljastada visiitkaarti?");
            String jahEi = in.nextLine();
            if (jahEi.equals("jah")){
                loeAndmedFailist(failinimi);
                // kutsu välja jooonistaja
            }
        }

    }

    public static void küsiAndmeid() {

        Scanner in = new Scanner(System.in);

        System.out.println("Visiitkaardi valikud:");
        System.out.println("Töökaart, Personaalkaart, Arendajakaart, Tudengikaart, Suunamudijakaart");
        String vastus = in.nextLine();
        if (vastus.equals("Töökaart")) {
            //
        } else if (vastus.equals("Personaalkaart")) {
            //
        } else if (vastus.equals("Arendajakaart")) {
            System.out.println("Nõutud andmed sisesta semikooloniga:");
            System.out.println("Nimi, email, telefoninumber, linkedIn, programmmeerimiskeeled, Kas tudeng?");
            String andmed = in.nextLine();
            sisestaAndmedFaili(andmed);
        } else if (vastus.equals("Tudengikaart")) {
            System.out.println("Nõutud andmed sisesta semikooloniga:");
            System.out.println("Nimi, email, telefoninumber, ülikool, Kas isic kaart olemas?");
            String andmed = in.nextLine();
            sisestaAndmedFaili(andmed);
        } else if (vastus.equals("Suunamudijakaart")) {
            //
        }
    }

    public static void sisestaAndmedFaili(String andmed) {
        try {
            File info = new File(failinimi);
            if (info.createNewFile()) {
                System.out.println("File created: " + info.getName());
                FileWriter kirjuta = new FileWriter(failinimi);
                kirjuta.write(andmed);
                kirjuta.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loeAndmedFailist(String failinimi) {
        try {
            File file = new File(failinimi);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] rida = scanner.nextLine().split(";");
                if (rida.length == 4) {
                    // personaalkaart
                } else if (rida.length == 5) {
                    Tudengikaart tudengikaart = new Tudengikaart(rida[0], rida[1].strip(), rida[2].strip(), rida[3].strip(), true);
                } else if (rida.length == 6) {
                    ArendajaKaart arendaja = new ArendajaKaart(rida[0], rida[1].strip(), rida[2].strip(), rida[3].strip(), rida[4].strip(), true);
                } else if (rida.length == 7) {
                    // töökaart
                } else if (rida.length == 8) {
                    // suunamudijakaart
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void kustutaVisiitkaart() {
        //
    }
}
