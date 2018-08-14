package model;

import model.webservice.LibraryImpl;
import model.webservice.LibraryImplService;
import model.webservice.User;

public class LibraryClientModel  {
    public User connect(String login, String password) throws RuntimeException {
        LibraryImplService service = new LibraryImplService();
        LibraryImpl library = service.getLibraryImplPort();

        return library.logIn(login, password);
    }
}
