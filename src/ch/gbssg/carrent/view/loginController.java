package ch.gbssg.carrent.view;

import ch.gbssg.carrent.Main;
import ch.gbssg.carrent.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.Date;


public class loginController {
  @FXML
  private TextField benutzername;
  @FXML
  private PasswordField passwort;
  @FXML
  private TextField regVorname;
  @FXML
  private TextField regNachname;
  @FXML
  private TextField regBenutzername;
  @FXML
  private DatePicker regGeburtsdatum;
  @FXML
  private PasswordField regPasswort1;
  @FXML
  private PasswordField regPasswort2;
  @FXML
  private Button login;
  @FXML
  private Button regestrieren;

  private Main main;

  public loginController(){}

  public void setMain(Main main){
    //testdaten
    main.getpersonen().add(new Person("vjaquet", "asdf", "valentin", "jaquet", LocalDate.of(2016,04,10)));
    this.main = main;
  }

  public void handleRegistrieren(){
    boolean exist=false;
    if(regBenutzername.getText().isEmpty() || regVorname.getText().isEmpty() || regNachname.getText().isEmpty() || regGeburtsdatum.getValue()== null || regPasswort1.getText().isEmpty() || regPasswort2.getText().isEmpty()){
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("Felder leer");
      alert.setContentText("Bitte füllen Sie die Felder aus!");
      alert.showAndWait();
    }
    else {
      if (regPasswort1.getText().matches(regPasswort2.getText())) {
        if (main.getpersonen().size() > 0) {
          for (int i = 0; i < main.getpersonen().size(); i++) {
            Person person = main.getpersonen().get(i);
              if (person.getBenutzername().equals(benutzername.getText())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Benutzername existiert schon");
                alert.setContentText("Bitte verwenden sie einen anderen Benutzername!");
                alert.showAndWait();
                exist = true;
              }
            }
          if (exist==false){
            //TODO
            Person person = new Person(regBenutzername.getText(), regPasswort1.getText(), regVorname.getText(), regNachname.getText(), regGeburtsdatum.getValue());
            main.getpersonen().add(person);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Registration erfolgreich");
            alert.showAndWait();
            main.showMenu();
            main.setAktivePerson(person);
          }
          }else {
            //TODO
            Person person = new Person(regBenutzername.getText(), regPasswort1.getText(), regVorname.getText(), regNachname.getText(), regGeburtsdatum.getValue());
            main.getpersonen().add(person);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Registration erfolgreich");
            alert.showAndWait();
            main.showMenu();
            main.setAktivePerson(person);
          }
        }else{
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Passwörter stimmen nicht überrein");
        alert.setContentText("Bitte überprüfen Sie die Passwörter!");
        alert.showAndWait();
        }
    }
  }


  public void handleLogin() {
    boolean exist = false;
    if (!benutzername.getText().isEmpty() || !passwort.getText().isEmpty()) {
      if (main.getpersonen().size() > 0) {
        for (int i = 0; i < main.getpersonen().size(); i++) {
          Person person = main.getpersonen().get(i);
          if (person.getBenutzername().equals(benutzername.getText())) {
            exist = true;
            if (person.getPasswort().equals(passwort.getText())) {
              main.showMenu();
              main.setAktivePerson(person);
            } else {
              Alert alert = new Alert(Alert.AlertType.ERROR);
              alert.setTitle("Error Dialog");
              alert.setHeaderText("Ihr Passwort ist  nicht korrekt");
              alert.setContentText("Bitte geben Sie das korrekte Passwort ein");
              alert.showAndWait();
            }
          }
        }
        if (!exist){
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setTitle("Error Dialog");
          alert.setHeaderText("Benutzername existiert nicht oder ist nicht korrekt");
          alert.setContentText("Bitte registrieren Sie sich zuerst!");
          alert.showAndWait();
        }
      }
    } else{
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("Felder leer");
      alert.setContentText("Bitte füllen Sie die Felder aus!");
      alert.showAndWait();
    }
  }
}
