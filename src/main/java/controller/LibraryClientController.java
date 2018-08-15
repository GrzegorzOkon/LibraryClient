package controller;

import model.LibraryClientModel;
import model.webservice.Book;
import model.webservice.User;
import view.LibraryClientView;

import java.util.ArrayList;

public class LibraryClientController {
    private LibraryClientView view;
    private LibraryClientModel model;

    public LibraryClientController(LibraryClientView view, LibraryClientModel model) {
        this.view = view;
        this.model = model;
    }

    public void connect(String login, String password) {
        User user = null;

        try {
            user = model.connect(login, password);

            if (user != null) {
                view.hideLoggingWindow();
                view.openSecondWindow(user);
            }
        } catch (RuntimeException ex) {
            view.report("Niepoprawny login lub hasło.");
        }
    }

    public void search(String title, String author) {
        ArrayList<Book> books = new ArrayList(model.search(title, author));

        view.showBooks(books);
    }
}
