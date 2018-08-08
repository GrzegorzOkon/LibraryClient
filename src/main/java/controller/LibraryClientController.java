package controller;

import model.LibraryClientModel;
import view.LibraryClientView;

public class LibraryClientController {
    private LibraryClientView view;
    private LibraryClientModel model;

    public LibraryClientController(LibraryClientView view, LibraryClientModel model) {
        this.view = view;
        this.model = model;
    }

    public void connect(String login, String password) {
        if (model.connect(login, password)) {
            view.report("Udało się zalogować.");
        } else {
            view.report("NIe udało się zalogować.");
        }
    }
}
