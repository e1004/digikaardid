package ee.ut.digikaardid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Label silt = new Label("Tere!");
        Scene stseen = new Scene(new StackPane(silt), 600, 400);
        stage.setScene(stseen);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}