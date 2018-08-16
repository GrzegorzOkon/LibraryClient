
package model.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the model.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LogIn_QNAME = new QName("http://web/", "logIn");
    private final static QName _ShowRentalsResponse_QNAME = new QName("http://web/", "showRentalsResponse");
    private final static QName _ShowRentals_QNAME = new QName("http://web/", "showRentals");
    private final static QName _SearchResponse_QNAME = new QName("http://web/", "searchResponse");
    private final static QName _LogInResponse_QNAME = new QName("http://web/", "logInResponse");
    private final static QName _Search_QNAME = new QName("http://web/", "search");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: model.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LogInResponse }
     * 
     */
    public LogInResponse createLogInResponse() {
        return new LogInResponse();
    }

    /**
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link ShowRentals }
     * 
     */
    public ShowRentals createShowRentals() {
        return new ShowRentals();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link ShowRentalsResponse }
     * 
     */
    public ShowRentalsResponse createShowRentalsResponse() {
        return new ShowRentalsResponse();
    }

    /**
     * Create an instance of {@link LogIn }
     * 
     */
    public LogIn createLogIn() {
        return new LogIn();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "logIn")
    public JAXBElement<LogIn> createLogIn(LogIn value) {
        return new JAXBElement<LogIn>(_LogIn_QNAME, LogIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowRentalsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "showRentalsResponse")
    public JAXBElement<ShowRentalsResponse> createShowRentalsResponse(ShowRentalsResponse value) {
        return new JAXBElement<ShowRentalsResponse>(_ShowRentalsResponse_QNAME, ShowRentalsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowRentals }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "showRentals")
    public JAXBElement<ShowRentals> createShowRentals(ShowRentals value) {
        return new JAXBElement<ShowRentals>(_ShowRentals_QNAME, ShowRentals.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "searchResponse")
    public JAXBElement<SearchResponse> createSearchResponse(SearchResponse value) {
        return new JAXBElement<SearchResponse>(_SearchResponse_QNAME, SearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogInResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "logInResponse")
    public JAXBElement<LogInResponse> createLogInResponse(LogInResponse value) {
        return new JAXBElement<LogInResponse>(_LogInResponse_QNAME, LogInResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://web/", name = "search")
    public JAXBElement<Search> createSearch(Search value) {
        return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
    }

}
