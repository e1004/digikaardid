module ee.ut.digikaardid{
    requires javafx.controls;
    requires javafx.fxml;


    opens ee.ut.digikaardid to javafx.fxml;
    exports ee.ut.digikaardid;
}