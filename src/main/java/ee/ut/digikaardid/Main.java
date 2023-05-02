package ee.ut.digikaardid;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Map;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    private static void lisaValikuKuulaja(RadioButton valija, GridPane sisenditeRuudustik, Map<Label, TextField> sildidSisendid) {
        valija.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                int i = 1;
                for (Map.Entry<Label, TextField> siltSisend : sildidSisendid.entrySet()) {
                    sisenditeRuudustik.add(siltSisend.getKey(), 0, i);
                    sisenditeRuudustik.add(siltSisend.getValue(), 1, i++);
                }
            } else {
                sisenditeRuudustik.getChildren().clear();
            }
        });
    }

    @Override
    public void start(Stage lava) throws IOException {
        lava.setTitle("Digitaalsed visiitkaardid");
        GridPane ruudustik = looRuudustik();
        ToggleGroup valijad = lisaKaarditüübiValija(ruudustik);
        Map<String, Map<String, TextField>> kaardiSildiSisendid = lisaKaardiSisestusväljad(ruudustik, valijad.getToggles());
        lisaSaatmisnupp(ruudustik, kaardiSildiSisendid, valijad);
        Scene stseen = new Scene(ruudustik, 900, 500);
        lava.setScene(stseen);
        lava.show();
    }

    private void lisaSaatmisnupp(GridPane ruudustik, Map<String, Map<String, TextField>> kaardiSildiSisendid, ToggleGroup valijad) {
        Button submitButton = new Button("Loo kaart");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        ruudustik.add(submitButton, 0, 4, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0, 20, 0));

        submitButton.setOnAction(event -> {
            RadioButton valitudValik = (RadioButton) valijad.getSelectedToggle();
            switch (valitudValik.getText()) {
                case Töökaart.NIMI -> {
                    String nimi = kaardiSildiSisendid.get(Töökaart.NIMI).get(Silt.NIMI).getText();

                    if (nimi.isEmpty()) {
                        näitaTeavitust(Alert.AlertType.ERROR, ruudustik.getScene().getWindow(), "Viga!", "Palun sisesta nimi");
                        return;
                    }
                } case Tudengikaart.NIMI -> {
                    String nimi = kaardiSildiSisendid.get(Tudengikaart.NIMI).get(Silt.NIMI).getText();

                    if (nimi.isEmpty()) {
                        näitaTeavitust(Alert.AlertType.ERROR, ruudustik.getScene().getWindow(), "Viga!", "Palun sisesta nimi");
                        return;
                    }
                }
            }
            näitaTeavitust(Alert.AlertType.CONFIRMATION, ruudustik.getScene().getWindow(), "Kaart loodud!", "Welcome ");
        });
    }

    private Map<String, Map<String, TextField>> lisaKaardiSisestusväljad(GridPane ruudustik, ObservableList<Toggle> valijad) {
        GridPane sisenditeRuudustik = new GridPane();
        ruudustik.add(sisenditeRuudustik, 0, 2, 2, 1);

        Label nimeSilt = new Label("Nimi: ");
        Label emailiSilt = new Label("Email: ");
        Label telefoniSilt = new Label("Telefoninumber: ");
        TextField nimeSisend = new TextField();
        TextField emailiSisend = new TextField();
        TextField telefoniSisend = new TextField();

        // Personaalkaardi väljad
        Label kirjelduseSilt = new Label("Kirjeldus: ");
        TextField kirjelduseSisend = new TextField();

        Map<Label, TextField> personaalsekaardiSiltSisend = Map.of(
                nimeSilt, nimeSisend,
                emailiSilt, emailiSisend,
                telefoniSilt, telefoniSisend,
                kirjelduseSilt, kirjelduseSisend
        );

        // Suunamudijakaardi väljad
        Label instagramiSilt = new Label("Instagram: ");
        Label facebookiSilt = new Label("Facebook: ");
        Label youtubeiSilt = new Label("Youtube: ");
        Label tiktokiSilt = new Label("Tiktok: ");
        Label twitteriSilt = new Label("Twitter: ");
        TextField instagramiSisend = new TextField();
        TextField facebookiSisend = new TextField();
        TextField youtubeiSisend = new TextField();
        TextField tiktokiSisend = new TextField();
        TextField twitteriSisend = new TextField();

        Map<Label, TextField> suunamudijakaardiSiltSisend = Map.of(
                nimeSilt, nimeSisend,
                emailiSilt, emailiSisend,
                telefoniSilt, telefoniSisend,
                instagramiSilt, instagramiSisend,
                facebookiSilt, facebookiSisend,
                youtubeiSilt, youtubeiSisend,
                tiktokiSilt, tiktokiSisend,
                twitteriSilt, twitteriSisend
        );

        // Arendajakaardi väljad
        Label linkedInSilt = new Label("LinkedIn: ");
        Label programmeerimiskeelteSilt = new Label("Programmeerimiskeeled: ");
        Label tudengiSilt = new Label("Tudeng: ");
        TextField linkedInSisend = new TextField();
        TextField programmeerimiskeelteSisend = new TextField();
        TextField tudengiSisend = new TextField();

        Map<Label, TextField> arendajakaardiSiltSisend = Map.of(
                nimeSilt, nimeSisend,
                emailiSilt, emailiSisend,
                telefoniSilt, telefoniSisend,
                linkedInSilt, linkedInSisend,
                programmeerimiskeelteSilt, programmeerimiskeelteSisend,
                tudengiSilt, tudengiSisend
        );

        // Töökaardi väljad
        Label töökohaSilt = new Label("Töökoht: ");
        Label aadressiSilt = new Label("Aadress: ");
        Label koduleheSilt = new Label("Koduleht: ");
        Label whatsappiSilt = new Label("WhatsApp: ");
        TextField töökohaSisend = new TextField();
        TextField aadressiSisend = new TextField();
        TextField koduleheSisend = new TextField();
        TextField whatsappiSisend = new TextField();

        Map<Label, TextField> töökaardiSiltSisend = Map.of(
                nimeSilt, nimeSisend,
                emailiSilt, emailiSisend,
                telefoniSilt, telefoniSisend,
                töökohaSilt, töökohaSisend,
                aadressiSilt, aadressiSisend,
                koduleheSilt, koduleheSisend,
                whatsappiSilt, whatsappiSisend
        );

        // Tudengikaardi väljad
        Label ülikooliSilt = new Label("Ülikool: ");
        Label isicKaardiSilt = new Label("ISIC-kaart: ");
        TextField ülikooliSisend = new TextField();
        TextField isicKaardiSisend = new TextField();

        Map<Label, TextField> tudengikaardiSiltSisend = Map.of(
                nimeSilt, nimeSisend,
                emailiSilt, emailiSisend,
                telefoniSilt, telefoniSisend,
                ülikooliSilt, ülikooliSisend,
                isicKaardiSilt, isicKaardiSisend
        );

        for (Toggle nupp : valijad) {
            RadioButton nupuvalik = (RadioButton) nupp;
            switch (nupuvalik.getText()) {
                case Töökaart.NIMI -> lisaValikuKuulaja(nupuvalik, sisenditeRuudustik, töökaardiSiltSisend);
                case Tudengikaart.NIMI -> lisaValikuKuulaja(nupuvalik, sisenditeRuudustik, tudengikaardiSiltSisend);
                case Suunamudijakaart.NIMI -> lisaValikuKuulaja(nupuvalik, sisenditeRuudustik, suunamudijakaardiSiltSisend);
                case Personaalkaart.NIMI -> lisaValikuKuulaja(nupuvalik, sisenditeRuudustik, personaalsekaardiSiltSisend);
                case ArendajaKaart.NIMI -> lisaValikuKuulaja(nupuvalik, sisenditeRuudustik, arendajakaardiSiltSisend);
            }
        }


        return Map.of(
                Töökaart.NIMI, Map.of(Silt.NIMI, nimeSisend, Silt.EMAIL, emailiSisend, Silt.TELEFON, telefoniSisend, Silt.TÖÖKOHT, töökohaSisend, Silt.AADRESS, aadressiSisend, Silt.KODULEHT, koduleheSisend, Silt.WHATSAPP, whatsappiSisend),
                Tudengikaart.NIMI, Map.of(Silt.NIMI, nimeSisend, Silt.EMAIL, emailiSisend, Silt.TELEFON, telefoniSisend),
                Suunamudijakaart.NIMI, Map.of(Silt.NIMI, nimeSisend, Silt.EMAIL, emailiSisend, Silt.TELEFON, telefoniSisend, Silt.INSTAGRAM, instagramiSisend, Silt.FACEBOOK, facebookiSisend, Silt.YOUTUBE, youtubeiSisend, Silt.TIKTOK, tiktokiSisend, Silt.TWITTER, twitteriSisend),
                Personaalkaart.NIMI, Map.of(Silt.NIMI, nimeSisend, Silt.EMAIL, emailiSisend, Silt.TELEFON, telefoniSisend, Silt.KIRJELDUS, kirjelduseSisend),
                ArendajaKaart.NIMI, Map.of(Silt.NIMI, nimeSisend, Silt.EMAIL, emailiSisend, Silt.TELEFON, telefoniSisend, Silt.LINKEDIN, linkedInSisend, Silt.PROGRAMMEERIMISKEELED, programmeerimiskeelteSisend, Silt.TUDENG, tudengiSisend));

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
        alert.setContentText(teavitus);
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