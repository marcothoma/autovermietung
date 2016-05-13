package ch.gbssg.carrent.view;

import ch.gbssg.carrent.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by vmadmin on 29.04.2016.
 */
public class menucontroller {
    private Main main;
    @FXML
    private Button konto;
    @FXML
    private Button abmelden;

    public menucontroller(){}

    public void setMain(Main main){
        this.main = main;
    }

    public void handleMeinKonto(){
        main.showMeinKonto();
    }

    public void handleAbmelden(){
        main.showStart();
        main.setAktivePerson(null);
    }

}


