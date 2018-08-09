package controller;

import model.LibraryClientModel;
import model.webservice.User;
import view.LibraryClientView;

public class LibraryClientController {
    private LibraryClientView view;
    private LibraryClientModel model;

    public LibraryClientController(LibraryClientView view, LibraryClientModel model) {
        this.view = view;
        this.model = model;
    }

    public void connect(String login, String password) {
        User user = model.connect(login, password);

        if (user != null) {
            view.report("Udało się zalogować.");
            view.report(user.getFirstName());
            view.report(user.getSurname());
            view.report(user.getLogin());
            view.report(user.getPassword());
        } else {
            view.report("NIe udało się zalogować.");
        }
    }
}
