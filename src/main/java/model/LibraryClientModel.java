package model;

import model.webservice.Book;
import model.webservice.LibraryImpl;
import model.webservice.LibraryImplService;
import model.webservice.User;

import java.util.List;

public class LibraryClientModel  {
    LibraryImplService service = new LibraryImplService();
    LibraryImpl library = service.getLibraryImplPort();

    public User connect(String login, String password) throws RuntimeException {
        return library.logIn(login, password);
    }

    public List<Book> search(String title, String author) {
        return library.search(title, author);
    }

    public List<Book> showUserRentals(String login) {
        return library.showRentals(login);
    }

    public List<Book> showReservations(String login) {
        return library.showReservations(login);
    }
}
