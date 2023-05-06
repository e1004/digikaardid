package ee.ut.digikaardid;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    private static void lisaValikuKuulaja(RadioButton valija, GridPane sisenditeRuudustik, Map<String, TextField> sildidSisendid) {
        valija.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                int i = 1;
                for (Map.Entry<String, TextField> siltSisend : sildidSisendid.entrySet()) {
                    sisenditeRuudustik.add(new Label(siltSisend.getKey() + ": "), 0, i);
                    sisenditeRuudustik.add(siltSisend.getValue(), 1, i++);
                }
            } else {
                sisenditeRuudustik.getChildren().clear();
            }
        });
    }

    private static void kirjutaFaili(String failinimi, Kaart kaart) {
        try (FileOutputStream f = new FileOutputStream(failinimi);
             ObjectOutputStream o = new ObjectOutputStream(f)) {
            o.writeObject(kaart);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Object loeKaardiObjekt(String failinimi) {
        try (FileInputStream fi = new FileInputStream(failinimi);
             ObjectInputStream oi = new ObjectInputStream(fi)) {
            return oi.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, TextField> ühendaVäljad(Map<String, TextField> väljad1, Map<String, TextField> väljad2) {
        return Stream.of(väljad2, väljad1)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue));
    }

    @Override
    public void start(Stage lava) throws IOException {
        lava.setTitle("Digitaalsed visiitkaardid");
        GridPane ruudustik = looRuudustik();
        ToggleGroup valijad = lisaKaarditüübiValija(ruudustik);
        Map<String, Map<String, TextField>> kaardiSildiSisendid = lisaKaardiSisestusväljad(ruudustik, valijad.getToggles());
        lisaSaatmisnupp(ruudustik, kaardiSildiSisendid, valijad);
        lisaVaatamisnupp(ruudustik, valijad);
        Scene stseen = new Scene(ruudustik, 900, 500);
        lava.setScene(stseen);
        lava.show();
    }

    private void lisaSaatmisnupp(GridPane ruudustik, Map<String, Map<String, TextField>> kaardiSildiSisendid, ToggleGroup valijad) {
        Button loomisnupp = new Button("Loo kaart");
        ruudustik.add(loomisnupp, 0, 4);

        loomisnupp.setOnAction(event -> {
            RadioButton valitudValik = (RadioButton) valijad.getSelectedToggle();
            switch (valitudValik.getText()) {
                case Töökaart.NIMI -> {
                    Map<String, TextField> sisendid = kaardiSildiSisendid.get(Töökaart.NIMI);
                    String nimi = sisendid.get(Silt.NIMI).getText();
                    String email = sisendid.get(Silt.EMAIL).getText();
                    String telefon = sisendid.get(Silt.TELEFON).getText();
                    String töökoht = sisendid.get(Silt.TÖÖKOHT).getText();
                    String aadress = sisendid.get(Silt.AADRESS).getText();
                    String whatsapp = sisendid.get(Silt.WHATSAPP).getText();
                    String koduleht = sisendid.get(Silt.KODULEHT).getText();

                    if (!kasSisendOK(ruudustik, nimi, email, telefon)) return;
                    Töökaart töökaart = new Töökaart(nimi, email, telefon, töökoht, aadress, koduleht, whatsapp);
                    kirjutaFaili("töökaart.txt", töökaart);

                }
                case Tudengikaart.NIMI -> {
                    Map<String, TextField> sisendid = kaardiSildiSisendid.get(Tudengikaart.NIMI);
                    String nimi = sisendid.get(Silt.NIMI).getText();
                    String email = sisendid.get(Silt.EMAIL).getText();
                    String telefon = sisendid.get(Silt.TELEFON).getText();
                    String ülikool = sisendid.get(Silt.ÜLIKOOL).getText();
                    String isickaart = sisendid.get(Silt.ISIC).getText();

                    if (!kasSisendOK(ruudustik, nimi, email, telefon)) return;
                    Tudengikaart tudengikaart = new Tudengikaart(nimi, email, telefon, ülikool, isickaart);
                    kirjutaFaili("tudengikaart.txt", tudengikaart);
                }
                case ArendajaKaart.NIMI -> {
                    Map<String, TextField> sisendid = kaardiSildiSisendid.get(ArendajaKaart.NIMI);
                    String nimi = sisendid.get(Silt.NIMI).getText();
                    String email = sisendid.get(Silt.EMAIL).getText();
                    String telefon = sisendid.get(Silt.TELEFON).getText();
                    String linkedIn = sisendid.get(Silt.LINKEDIN).getText();
                    String programmeerimiskeeled = sisendid.get(Silt.PROGRAMMEERIMISKEELED).getText();
                    String tudeng = sisendid.get(Silt.TUDENG).getText();

                    if (!kasSisendOK(ruudustik, nimi, email, telefon)) return;
                    ArendajaKaart arendajaKaart = new ArendajaKaart(nimi, email, telefon, linkedIn, programmeerimiskeeled, tudeng);
                    kirjutaFaili("arendajakaart.txt", arendajaKaart);
                }
                case Suunamudijakaart.NIMI -> {
                    Map<String, TextField> sisendid = kaardiSildiSisendid.get(Suunamudijakaart.NIMI);
                    String nimi = sisendid.get(Silt.NIMI).getText();
                    String email = sisendid.get(Silt.EMAIL).getText();
                    String telefon = sisendid.get(Silt.TELEFON).getText();
                    String instagram = sisendid.get(Silt.INSTAGRAM).getText();
                    String facebook = sisendid.get(Silt.FACEBOOK).getText();
                    String youtube = sisendid.get(Silt.YOUTUBE).getText();
                    String tiktok = sisendid.get(Silt.TIKTOK).getText();
                    String twitter = sisendid.get(Silt.TWITTER).getText();

                    if (!kasSisendOK(ruudustik, nimi, email, telefon)) return;
                    Suunamudijakaart suunamudijakaart = new Suunamudijakaart(nimi, email, telefon, instagram, facebook, youtube, tiktok, twitter);
                    kirjutaFaili("suunamudijakaart.txt", suunamudijakaart);
                }
                case Personaalkaart.NIMI -> {
                    Map<String, TextField> sisendid = kaardiSildiSisendid.get(Personaalkaart.NIMI);
                    String nimi = sisendid.get(Silt.NIMI).getText();
                    String email = sisendid.get(Silt.EMAIL).getText();
                    String telefon = sisendid.get(Silt.TELEFON).getText();
                    String kirjedus = sisendid.get(Silt.KIRJELDUS).getText();

                    if (!kasSisendOK(ruudustik, nimi, email, telefon)) return;
                    Personaalkaart personaalkaart = new Personaalkaart(nimi, email, telefon, kirjedus);
                    kirjutaFaili("personaalkaart.txt", personaalkaart);
                }
            }
            näitaTeavitust(Alert.AlertType.CONFIRMATION, ruudustik.getScene().getWindow(), "", "Kaart loodud");
        });
    }

    private boolean kasSisendOK(GridPane ruudustik, String nimi, String email, String telefon) {
        List<String> tühjadVäljad = valideeriVälju(nimi, email, telefon);
        if (tühjadVäljad.size() > 0) {
            näitaTeavitust(Alert.AlertType.ERROR, ruudustik.getScene().getWindow(), "Viga!", "Palun sisesta väljad:" + tühjadVäljad);
            return false;
        }
        return true;
    }

    private List<String> valideeriVälju(String nimi, String email, String telefon) {
        List<String> tühjadVäljad = new ArrayList<>();
        if (nimi.isEmpty()) {
            tühjadVäljad.add(Silt.NIMI);
        }
        if (email.isEmpty()) {
            tühjadVäljad.add(Silt.EMAIL);
        }
        if (telefon.isEmpty()) {
            tühjadVäljad.add(Silt.TELEFON);
        }
        return tühjadVäljad;
    }

    private void lisaVaatamisnupp(GridPane ruudustik, ToggleGroup valijad) {
        Button vaatamisnupp = new Button("Vaata kaarti");
        ruudustik.add(vaatamisnupp, 1, 4);

        vaatamisnupp.setOnAction(event -> {
            RadioButton valitudValik = (RadioButton) valijad.getSelectedToggle();
            switch (valitudValik.getText()) {
                case Töökaart.NIMI -> {
                    Töökaart töökaart = (Töökaart) loeKaardiObjekt("töökaart.txt");
                    näitaKaarti(ruudustik.getScene().getWindow(), töökaart);

                }
                case Tudengikaart.NIMI -> {
                    Tudengikaart tudengikaart = (Tudengikaart) loeKaardiObjekt("tudengikaart.txt");
                    näitaKaarti(ruudustik.getScene().getWindow(), tudengikaart);

                }
                case ArendajaKaart.NIMI -> {
                    ArendajaKaart arendajaKaart = (ArendajaKaart) loeKaardiObjekt("arendajakaart.txt");
                    näitaKaarti(ruudustik.getScene().getWindow(), arendajaKaart);

                }
                case Suunamudijakaart.NIMI -> {
                    Suunamudijakaart suunamudijakaart = (Suunamudijakaart) loeKaardiObjekt("suunamudijakaart.txt");
                    näitaKaarti(ruudustik.getScene().getWindow(), suunamudijakaart);

                }
                case Personaalkaart.NIMI -> {
                    Personaalkaart personaalkaart = (Personaalkaart) loeKaardiObjekt("personaalkaart.txt");
                    näitaKaarti(ruudustik.getScene().getWindow(), personaalkaart);
                }
            }
        });
    }

    private Map<String, Map<String, TextField>> lisaKaardiSisestusväljad(GridPane ruudustik, ObservableList<Toggle> valijad) {
        GridPane sisenditeRuudustik = new GridPane();
        ruudustik.add(sisenditeRuudustik, 0, 2, 2, 1);

        Map<String, TextField> ühisedSisestusväljad = Kaart.getSisestusväljad();

        Map<String, TextField> personaalsekaardiSiltSisend = ühendaVäljad(Personaalkaart.getSisestusväljad(), ühisedSisestusväljad);
        Map<String, TextField> suunamudijakaardiSiltSisend = ühendaVäljad(Suunamudijakaart.getSisestusväljad(), ühisedSisestusväljad);
        Map<String, TextField> arendajakaardiSiltSisend = ühendaVäljad(ArendajaKaart.getSisestusväljad(), ühisedSisestusväljad);
        Map<String, TextField> tudengikaardiSiltSisend = ühendaVäljad(Tudengikaart.getSisestusväljad(), ühisedSisestusväljad);
        Map<String, TextField> töökaardiSiltSisend = ühendaVäljad(Töökaart.getSisestusväljad(), ühisedSisestusväljad);

        for (Toggle nupp : valijad) {
            RadioButton nupuvalik = (RadioButton) nupp;
            switch (nupuvalik.getText()) {
                case Töökaart.NIMI -> lisaValikuKuulaja(nupuvalik, sisenditeRuudustik, töökaardiSiltSisend);
                case Tudengikaart.NIMI -> lisaValikuKuulaja(nupuvalik, sisenditeRuudustik, tudengikaardiSiltSisend);
                case Suunamudijakaart.NIMI ->
                        lisaValikuKuulaja(nupuvalik, sisenditeRuudustik, suunamudijakaardiSiltSisend);
                case Personaalkaart.NIMI ->
                        lisaValikuKuulaja(nupuvalik, sisenditeRuudustik, personaalsekaardiSiltSisend);
                case ArendajaKaart.NIMI -> lisaValikuKuulaja(nupuvalik, sisenditeRuudustik, arendajakaardiSiltSisend);
            }
        }


        return Map.of(
                Töökaart.NIMI, töökaardiSiltSisend,
                Tudengikaart.NIMI, tudengikaardiSiltSisend,
                Suunamudijakaart.NIMI, suunamudijakaardiSiltSisend,
                Personaalkaart.NIMI, personaalsekaardiSiltSisend,
                ArendajaKaart.NIMI, arendajakaardiSiltSisend);
    }

    private GridPane looRuudustik() {
        GridPane ruudustik = new GridPane();

        ruudustik.setAlignment(Pos.CENTER);
        return ruudustik;
    }

    private void näitaTeavitust(Alert.AlertType alertType, Window omanik, String pealkiri, String teavitus) {
        Alert alert = new Alert(alertType);
        alert.setTitle(pealkiri);
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.setContentText(teavitus);
        alert.initOwner(omanik);
        alert.show();
    }

    private void näitaKaarti(Window omanik, Kaart kaart) {
        Joonistaja joonistaja = new Joonistaja(kaart);
        String rida = kaart.toString();
        String[] osad = rida.trim().split(", ");
        int pikim = 0;
        for (String s : osad)
            if (pikim < s.length())
                pikim = s.length();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle(null);
        alert.setGraphic(null);
        alert.setResizable(true);

        String teavitus = joonistaja.joonista(pikim);
        TextArea kaardiala = new TextArea(teavitus);
        kaardiala.setStyle("-fx-font-family: monospace");
        kaardiala.setEditable(false);
        kaardiala.setWrapText(false);
        BorderPane kaardiRuudustik = new BorderPane();
        kaardiRuudustik.setMaxWidth(Double.MAX_VALUE);
        kaardiRuudustik.setCenter(kaardiala);
        alert.getDialogPane().setContent(kaardiRuudustik);
        alert.initOwner(omanik);
        alert.show();
    }

    private ToggleGroup lisaKaarditüübiValija(GridPane ruudustik) {
        Label headerLabel = new Label("Vali kaarditüüp");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        ruudustik.add(headerLabel, 0, 0, 2, 1);

        final VBox valikud = new VBox(5);
        final RadioButton töökaart = new RadioButton(Töökaart.NIMI);
        final RadioButton tudengikaart = new RadioButton(Tudengikaart.NIMI);
        final RadioButton suunamudijakaart = new RadioButton(Suunamudijakaart.NIMI);
        final RadioButton personaalkaart = new RadioButton(Personaalkaart.NIMI);
        final RadioButton arendajakaart = new RadioButton(ArendajaKaart.NIMI);
        final ToggleGroup valikuteGrupp = new ToggleGroup();
        valikuteGrupp.getToggles().addAll(töökaart, tudengikaart, suunamudijakaart, personaalkaart, arendajakaart);
        valikud.getChildren().addAll(töökaart, tudengikaart, suunamudijakaart, personaalkaart, arendajakaart);
        ruudustik.add(valikud, 0, 1, 2, 1);
        return valikuteGrupp;
    }
}