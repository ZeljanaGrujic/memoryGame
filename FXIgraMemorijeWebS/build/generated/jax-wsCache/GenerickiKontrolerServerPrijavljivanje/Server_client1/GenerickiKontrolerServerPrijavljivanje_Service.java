
package Server_client1;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.5
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "GenerickiKontrolerServerPrijavljivanje", targetNamespace = "http://Server/", wsdlLocation = "http://localhost:8080/FXIgraMemorijeWebS/GenerickiKontrolerServerPrijavljivanje?wsdl")
public class GenerickiKontrolerServerPrijavljivanje_Service
    extends Service
{

    private final static URL GENERICKIKONTROLERSERVERPRIJAVLJIVANJE_WSDL_LOCATION;
    private final static WebServiceException GENERICKIKONTROLERSERVERPRIJAVLJIVANJE_EXCEPTION;
    private final static QName GENERICKIKONTROLERSERVERPRIJAVLJIVANJE_QNAME = new QName("http://Server/", "GenerickiKontrolerServerPrijavljivanje");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/FXIgraMemorijeWebS/GenerickiKontrolerServerPrijavljivanje?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GENERICKIKONTROLERSERVERPRIJAVLJIVANJE_WSDL_LOCATION = url;
        GENERICKIKONTROLERSERVERPRIJAVLJIVANJE_EXCEPTION = e;
    }

    public GenerickiKontrolerServerPrijavljivanje_Service() {
        super(__getWsdlLocation(), GENERICKIKONTROLERSERVERPRIJAVLJIVANJE_QNAME);
    }

    public GenerickiKontrolerServerPrijavljivanje_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), GENERICKIKONTROLERSERVERPRIJAVLJIVANJE_QNAME, features);
    }

    public GenerickiKontrolerServerPrijavljivanje_Service(URL wsdlLocation) {
        super(wsdlLocation, GENERICKIKONTROLERSERVERPRIJAVLJIVANJE_QNAME);
    }

    public GenerickiKontrolerServerPrijavljivanje_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GENERICKIKONTROLERSERVERPRIJAVLJIVANJE_QNAME, features);
    }

    public GenerickiKontrolerServerPrijavljivanje_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GenerickiKontrolerServerPrijavljivanje_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GenerickiKontrolerServerPrijavljivanje
     */
    @WebEndpoint(name = "GenerickiKontrolerServerPrijavljivanjePort")
    public GenerickiKontrolerServerPrijavljivanje getGenerickiKontrolerServerPrijavljivanjePort() {
        return super.getPort(new QName("http://Server/", "GenerickiKontrolerServerPrijavljivanjePort"), GenerickiKontrolerServerPrijavljivanje.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GenerickiKontrolerServerPrijavljivanje
     */
    @WebEndpoint(name = "GenerickiKontrolerServerPrijavljivanjePort")
    public GenerickiKontrolerServerPrijavljivanje getGenerickiKontrolerServerPrijavljivanjePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Server/", "GenerickiKontrolerServerPrijavljivanjePort"), GenerickiKontrolerServerPrijavljivanje.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GENERICKIKONTROLERSERVERPRIJAVLJIVANJE_EXCEPTION!= null) {
            throw GENERICKIKONTROLERSERVERPRIJAVLJIVANJE_EXCEPTION;
        }
        return GENERICKIKONTROLERSERVERPRIJAVLJIVANJE_WSDL_LOCATION;
    }

}
