package ch.gbssg.carrent;

import ch.gbssg.carrent.model.Person;
import ch.gbssg.carrent.view.RootLayoutController;
import ch.gbssg.carrent.view.loginController;
import ch.gbssg.carrent.view.meinKontoController;
import ch.gbssg.carrent.view.menucontroller;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Main extends Application{

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ArrayList<Person> personen = new ArrayList<Person>();
    private Person aktivePerson;


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Autovermietung");


        initRootLayout();

        showStart();
    }

    public Person getAktivePerson(){
        return aktivePerson;
    }
    public void setAktivePerson(Person aktivePerson){
        this.aktivePerson=aktivePerson;
    }

    public void initRootLayout(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            RootLayoutController controller = loader.getController();
            //controller.setMain(this, Dozenten);
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            controller.setMain(this);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<Person> getpersonen(){
        return personen;
    }

    public void showStart() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/login.fxml"));
            AnchorPane start = (AnchorPane) loader.load();

            rootLayout.setCenter(start);

            loginController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void showMenu() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/menu.fxml"));
            AnchorPane start = (AnchorPane) loader.load();

            rootLayout.setCenter(start);

            menucontroller controller = loader.getController();
            controller.setMain(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void showMeinKonto() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/meinKonto.fxml"));
            AnchorPane start = (AnchorPane) loader.load();

            rootLayout.setCenter(start);

            meinKontoController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}