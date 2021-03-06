
package model.webservice;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "LibraryImpl", targetNamespace = "http://web/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface LibraryImpl {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<model.webservice.Book>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "search", targetNamespace = "http://web/", className = "model.webservice.Search")
    @ResponseWrapper(localName = "searchResponse", targetNamespace = "http://web/", className = "model.webservice.SearchResponse")
    @Action(input = "http://web/LibraryImpl/searchRequest", output = "http://web/LibraryImpl/searchResponse")
    public List<Book> search(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns model.webservice.User
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "logIn", targetNamespace = "http://web/", className = "model.webservice.LogIn")
    @ResponseWrapper(localName = "logInResponse", targetNamespace = "http://web/", className = "model.webservice.LogInResponse")
    @Action(input = "http://web/LibraryImpl/logInRequest", output = "http://web/LibraryImpl/logInResponse")
    public User logIn(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<model.webservice.Book>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "showReservations", targetNamespace = "http://web/", className = "model.webservice.ShowReservations")
    @ResponseWrapper(localName = "showReservationsResponse", targetNamespace = "http://web/", className = "model.webservice.ShowReservationsResponse")
    @Action(input = "http://web/LibraryImpl/showReservationsRequest", output = "http://web/LibraryImpl/showReservationsResponse")
    public List<Book> showReservations(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<model.webservice.Book>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "showRentals", targetNamespace = "http://web/", className = "model.webservice.ShowRentals")
    @ResponseWrapper(localName = "showRentalsResponse", targetNamespace = "http://web/", className = "model.webservice.ShowRentalsResponse")
    @Action(input = "http://web/LibraryImpl/showRentalsRequest", output = "http://web/LibraryImpl/showRentalsResponse")
    public List<Book> showRentals(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addReservation", targetNamespace = "http://web/", className = "model.webservice.AddReservation")
    @ResponseWrapper(localName = "addReservationResponse", targetNamespace = "http://web/", className = "model.webservice.AddReservationResponse")
    @Action(input = "http://web/LibraryImpl/addReservationRequest", output = "http://web/LibraryImpl/addReservationResponse")
    public void addReservation(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    int arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "cancelReservation", targetNamespace = "http://web/", className = "model.webservice.CancelReservation")
    @ResponseWrapper(localName = "cancelReservationResponse", targetNamespace = "http://web/", className = "model.webservice.CancelReservationResponse")
    @Action(input = "http://web/LibraryImpl/cancelReservationRequest", output = "http://web/LibraryImpl/cancelReservationResponse")
    public void cancelReservation(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0,
            @WebParam(name = "arg1", targetNamespace = "")
                    int arg1);

}
