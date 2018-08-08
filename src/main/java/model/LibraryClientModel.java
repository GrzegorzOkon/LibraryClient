package model;

import model.webservice.LibraryImpl;
import model.webservice.LibraryImplService;

public class LibraryClientModel {
    public boolean connect(String l, String p) {
        LibraryImplService service = new LibraryImplService();
        LibraryImpl library = service.getLibraryImplPort();

        return library.logIn(l, p);
    }
}
