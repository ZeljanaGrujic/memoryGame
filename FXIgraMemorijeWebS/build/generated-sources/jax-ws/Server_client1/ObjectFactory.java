
package Server_client1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Server_client1 package. 
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

    private final static QName _ProveraPrijavljivanja_QNAME = new QName("http://Server/", "proveraPrijavljivanja");
    private final static QName _ProveraPrijavljivanjaResponse_QNAME = new QName("http://Server/", "proveraPrijavljivanjaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Server_client1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProveraPrijavljivanja }
     * 
     */
    public ProveraPrijavljivanja createProveraPrijavljivanja() {
        return new ProveraPrijavljivanja();
    }

    /**
     * Create an instance of {@link ProveraPrijavljivanjaResponse }
     * 
     */
    public ProveraPrijavljivanjaResponse createProveraPrijavljivanjaResponse() {
        return new ProveraPrijavljivanjaResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ProveraPrijavljivanja }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProveraPrijavljivanja }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "proveraPrijavljivanja")
    public JAXBElement<ProveraPrijavljivanja> createProveraPrijavljivanja(ProveraPrijavljivanja value) {
        return new JAXBElement<ProveraPrijavljivanja>(_ProveraPrijavljivanja_QNAME, ProveraPrijavljivanja.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProveraPrijavljivanjaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProveraPrijavljivanjaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://Server/", name = "proveraPrijavljivanjaResponse")
    public JAXBElement<ProveraPrijavljivanjaResponse> createProveraPrijavljivanjaResponse(ProveraPrijavljivanjaResponse value) {
        return new JAXBElement<ProveraPrijavljivanjaResponse>(_ProveraPrijavljivanjaResponse_QNAME, ProveraPrijavljivanjaResponse.class, null, value);
    }

}
