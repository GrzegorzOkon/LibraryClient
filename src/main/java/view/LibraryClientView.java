package view;

import controller.LibraryClientController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.LibraryClientModel;

public class LibraryClientView extends Application {
    private LibraryClientController controller;

    private Scene scena;
    private BorderPane mainContainer, konternerDolny;
    private GridPane kontenerSiatki;
    private HBox kontenerPrzyciskow;
    private TextField userLogin, userPassword;
    private TextArea logInReport;
    private Button logIn;

    private void prepareScene(Stage primaryStage) {
        mainContainer = new BorderPane();
        mainContainer.setPadding(new Insets(15, 15, 15, 15));  //tworzy odstęp wokół konteneru

        userLogin = new TextField();
        userLogin.setPrefSize(150, userLogin.getHeight());

        userPassword = new TextField();
        userPassword.setPrefSize(150, userPassword.getHeight());

        kontenerSiatki = new GridPane();
        kontenerSiatki.setVgap(4);
        kontenerSiatki.setHgap(8);
        kontenerSiatki.setPadding(new Insets(5, 5, 5, 5));
        kontenerSiatki.add(new Label("Login:"), 0, 0);
        kontenerSiatki.add(userLogin, 0, 1);
        kontenerSiatki.add(new Label("Haslo:"), 1, 0);
        kontenerSiatki.add(userPassword, 1, 1);
        kontenerSiatki.setPadding(new Insets(0, 0, 10, 0));

        mainContainer.setTop(kontenerSiatki);

        logInReport = new TextArea();
        mainContainer.setCenter(logInReport);

        konternerDolny = new BorderPane();
        konternerDolny.setPadding(new Insets(10, 0, 0, 0));

        kontenerPrzyciskow = new HBox(16);

        logIn = new Button("Zaloguj");

        kontenerPrzyciskow.getChildren().add(logIn);

        logIn.setOnAction((event) -> {
            controller.connect(userLogin.getText().toLowerCase(), userPassword.getText().toLowerCase());
        });

        konternerDolny.setRight(kontenerPrzyciskow);
        mainContainer.setBottom(konternerDolny);

        scena = new Scene(mainContainer, 300, 300);
    }

    private void setReference()
    {
        LibraryClientModel model = new LibraryClientModel();
        controller = new LibraryClientController(this, model);
    }

    @Override
    public void start(Stage primaryStage) {
        prepareScene(primaryStage);

        setReference();

        primaryStage.setTitle("LibraryClient");
        primaryStage.setScene(scena);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

    public void report(String reportText) {

        logInReport.appendText(reportText + "\n");
    }
}