
package Server_client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Server_client package. 
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

    private final static QName _KreirajDK_QNAME = new QName("http://Server/", "kreirajDK");
    private final static QName _KreirajDKResponse_QNAME = new QName("http://Server/", "kreirajDKResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Server_client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link KreirajDK }
     * 
     */
    public KreirajDK createKreirajDK() {
        return new KreirajDK();
    }

    /**
     * Create an instance of {@link KreirajDKResponse }
     * 
     */
    public KreirajDKResponse createKreirajDKResponse() {
        return new KreirajDKResponse();
    }

    /**
     * Create an instance of {@link GenerickiTransferObjekatKorisnik }
     * 
     */
    public GenerickiTransferObjekatKorisnik createGenerickiTransferObjekatKorisnik() {
        return new GenerickiTransferObjekatKorisnik();
    }

    /**
     * Create an instance of {@link Korisnik }
     * 
     */
    public Korisnik createKorisnik() {
        return new Korisnik();
    }

    /**
     * Create an instance of {@link Date }
     * 
     */
    public Date createDate() {
        return new Date();
    }

    /**
     * Create an instance of {@link Poruka }
     * 
     */
    public Poruka createPoruka() {
        return new Poruka();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KreirajDK }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link KreirajDK }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "kreirajDK")
    public JAXBElement<KreirajDK> createKreirajDK(KreirajDK value) {
        return new JAXBElement<KreirajDK>(_KreirajDK_QNAME, KreirajDK.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link KreirajDKResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link KreirajDKResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "kreirajDKResponse")
    public JAXBElement<KreirajDKResponse> createKreirajDKResponse(KreirajDKResponse value) {
        return new JAXBElement<KreirajDKResponse>(_KreirajDKResponse_QNAME, KreirajDKResponse.class, null, value);
    }

}
