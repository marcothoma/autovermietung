package ch.gbssg.carrent.view;

import ch.gbssg.carrent.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Created by vmadmin on 13.05.2016.
 */
public class meinKontoController {
    private Main main;
    @FXML
    private Button speichern;
    @FXML
    private Button abbrechen;
    @FXML
    private TextField vorname;
    @FXML
    private TextField nachname;
    @FXML
    private TextField benutzername;
    @FXML
    private DatePicker regGeburtsdatum;
    @FXML
    private PasswordField passwort1;
    @FXML
    private PasswordField passwort2;
    @FXML
    private TextField email;
    @FXML
    private TextField kontoInfo;

    public meinKontoController(){}

    public void setMain(Main main){
        this.main = main;
        vorname.setText(main.getAktivePerson().getVorname());
        nachname.setText(main.getAktivePerson().getName());
        benutzername.setText(main.getAktivePerson().getBenutzername());
        benutzername.setDisable(true);
        regGeburtsdatum.setValue(main.getAktivePerson().getGeburtsdatum());
        passwort1.setText(main.getAktivePerson().getPasswort());
        passwort2.setText(main.getAktivePerson().getPasswort());
        email.setText(main.getAktivePerson().getMail());
        kontoInfo.setText(main.getAktivePerson().getKonto());
    }

    public void handleAbbrechen(){
        main.showMenu();
    }
    public void handleSpeichern(){
        main.getAktivePerson().setName(nachname.getText());
        main.getAktivePerson().setVorname(vorname.getText());
        main.getAktivePerson().setGeburtsdatum(regGeburtsdatum.getValue());
        main.getAktivePerson().setKonto(kontoInfo.getText());
        main.getAktivePerson().setMail(email.getText());
        if (passwort1.getText().matches(passwort2.getText())){
            main.getAktivePerson().setPasswort(passwort1.getText());
        }
        main.showMenu();
    }
}
