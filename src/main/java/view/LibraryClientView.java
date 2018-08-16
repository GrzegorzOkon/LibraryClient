package view;

import controller.LibraryClientController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.LibraryClientModel;
import model.webservice.Book;
import model.webservice.User;

import java.util.ArrayList;

public class LibraryClientView extends Application {
    private LibraryClientController controller;

    private Stage primaryStage;
    private Scene primaryScene;
    private BorderPane primaryLayout, primaryBottomLayout;
    private GridPane primaryGrid;
    private HBox primaryButtons;
    private TextField primaryUserLogin, primaryUserPassword;
    private TextArea primaryReport;
    private Button primaryLogIn;

    private BorderPane secondaryLayout, secondaryBottomLayout;
    private GridPane secondaryGrid;
    private Label secondaryLabel;
    private TextField secondaryTitleInput, secondaryAuthorInput;
    private TableView secondaryResult;
    private TableColumn titleCol, authorCol, yearCol;
    private ObservableList<Book> data = FXCollections.observableArrayList();
    private HBox secondaryButtons;
    private Button secondarySearch, secondaryRentals, secondaryReservations, secondaryReserve, secondaryCancel;

    private void prepareScene(Stage primaryStage) {
        primaryLayout = new BorderPane();
        primaryLayout.setPadding(new Insets(15, 15, 15, 15));

        primaryUserLogin = new TextField();
        primaryUserLogin.setPrefSize(150, primaryUserLogin.getHeight());

        primaryUserPassword = new TextField();
        primaryUserPassword.setPrefSize(150, primaryUserPassword.getHeight());

        primaryGrid = new GridPane();
        primaryGrid.setVgap(4);
        primaryGrid.setHgap(8);
        primaryGrid.setPadding(new Insets(5, 5, 5, 5));
        primaryGrid.add(new Label("Login:"), 0, 0);
        primaryGrid.add(primaryUserLogin, 0, 1);
        primaryGrid.add(new Label("Haslo:"), 1, 0);
        primaryGrid.add(primaryUserPassword, 1, 1);
        primaryGrid.setPadding(new Insets(0, 0, 10, 0));

        primaryLayout.setTop(primaryGrid);

        primaryReport = new TextArea();
        primaryLayout.setCenter(primaryReport);

        primaryBottomLayout = new BorderPane();
        primaryBottomLayout.setPadding(new Insets(10, 0, 0, 0));

        primaryButtons = new HBox(16);

        primaryLogIn = new Button("Zaloguj");

        primaryButtons.getChildren().add(primaryLogIn);

        primaryLogIn.setOnAction((event) -> {
            controller.connect(primaryUserLogin.getText().toLowerCase(), primaryUserPassword.getText().toLowerCase());
        });

        primaryBottomLayout.setRight(primaryButtons);
        primaryLayout.setBottom(primaryBottomLayout);

        primaryScene = new Scene(primaryLayout, 300, 300);
    }

    @Override
    public void start(Stage primaryStage) {
        prepareScene(primaryStage);

        setMVCReference();
        this.primaryStage = primaryStage;

        primaryStage.setTitle("LibraryClient");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

    private void setMVCReference() {
        LibraryClientModel model = new LibraryClientModel();
        controller = new LibraryClientController(this, model);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void openSecondWindow(User user) {
        secondaryLayout = new BorderPane();
        secondaryLayout.setPadding(new Insets(5, 15, 15, 15));

        secondaryLabel = new Label("Witaj " + user.getFirstName() + " " + user.getSurname());
        secondaryTitleInput = new TextField();
        secondaryTitleInput.setPrefSize(150, secondaryTitleInput.getHeight());
        secondaryAuthorInput = new TextField();
        secondaryAuthorInput.setPrefSize(150, secondaryAuthorInput.getHeight());

        secondaryGrid = new GridPane();
        secondaryGrid.setVgap(4);
        secondaryGrid.setHgap(8);
        secondaryGrid.add(secondaryLabel, 0, 0);
        secondaryGrid.setPadding(new Insets(15, 5, 15, 5));
        secondaryGrid.add(new Label("Tytuł:"), 0, 1);
        secondaryGrid.add(secondaryTitleInput, 1, 1);
        secondaryGrid.add(new Label("Autor:"), 0, 2);
        secondaryGrid.add(secondaryAuthorInput, 1, 2);
        secondaryGrid.setPadding(new Insets(0, 0, 10, 0));
        secondaryLayout.setTop(secondaryGrid);

        secondaryResult = new TableView();

        titleCol = new TableColumn("Tytuł");
        titleCol.setMinWidth(300);
        titleCol.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));

        authorCol = new TableColumn("Autor");
        authorCol.setMinWidth(200);
        authorCol.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));

        yearCol = new TableColumn("Rok wydania");
        yearCol.setMinWidth(100);
        yearCol.setCellValueFactory(new PropertyValueFactory<Book,String>("year"));

        secondaryResult.getColumns().addAll(titleCol, authorCol, yearCol);
        secondaryResult.setItems(data);
        secondaryLayout.setCenter(secondaryResult);

        secondaryBottomLayout = new BorderPane();
        secondaryBottomLayout.setPadding(new Insets(10, 0, 0, 0));

        secondaryButtons = new HBox(10);
        secondarySearch = new Button("Wyszukaj");
        secondaryButtons.getChildren().add(secondarySearch);
        secondaryRentals = new Button("Moje wypożyczenia");
        secondaryButtons.getChildren().add(secondaryRentals);
        secondaryReservations = new Button("Moje rezerwacje");
        secondaryButtons.getChildren().add(secondaryReservations);
        secondaryReserve = new Button("Rezerwuj");
        secondaryButtons.getChildren().add(secondaryReserve);
        secondaryCancel = new Button("Anuluj rezerwację");
        secondaryButtons.getChildren().add(secondaryCancel);

        secondarySearch.setOnAction((event) -> {
            controller.search(validateEmptySpace(secondaryTitleInput), validateEmptySpace(secondaryAuthorInput));
        });

        secondaryRentals.setOnAction((event) -> {
            controller.showUserRentals(user.getLogin());
        });

        secondaryBottomLayout.setLeft(secondaryButtons);
        secondaryLayout.setBottom(secondaryBottomLayout);

        Scene secondScene = new Scene(secondaryLayout, 700, 400);

        Stage newWindow = new Stage();
        newWindow.setTitle("LibraryClient");
        newWindow.setScene(secondScene);

        newWindow.show();
    }

    public void hideLoggingWindow() {
        primaryStage.close();
    }

    public void report(String reportText) {
        primaryReport.appendText(reportText + "\n");
    }

    public void showBooks(ArrayList<Book> books) {
        data.clear();

        for (Book book : books) {
            data.add(book);
        }
    }

    private String validateEmptySpace(TextField input) {
        String text = input.getText();

        if (text != null) {
            return input.getText();
        } else {
            return "";
        }
    }
}