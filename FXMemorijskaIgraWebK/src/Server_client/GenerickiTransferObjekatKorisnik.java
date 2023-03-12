
package Server_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for generickiTransferObjekatKorisnik complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="generickiTransferObjekatKorisnik"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="gdo" type="{http://Server/}korisnik" minOccurs="0"/&gt;
 *         &lt;element name="tekst" type="{http://Server/}poruka" minOccurs="0"/&gt;
 *         &lt;element name="signal" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="nazivOperacije" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "generickiTransferObjekatKorisnik", propOrder = {
    "gdo",
    "tekst",
    "signal",
    "nazivOperacije"
})
public class GenerickiTransferObjekatKorisnik {

    protected Korisnik gdo;
    protected Poruka tekst;
    protected boolean signal;
    protected String nazivOperacije;

    /**
     * Gets the value of the gdo property.
     * 
     * @return
     *     possible object is
     *     {@link Korisnik }
     *     
     */
    public Korisnik getGdo() {
        return gdo;
    }

    /**
     * Sets the value of the gdo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Korisnik }
     *     
     */
    public void setGdo(Korisnik value) {
        this.gdo = value;
    }

    /**
     * Gets the value of the tekst property.
     * 
     * @return
     *     possible object is
     *     {@link Poruka }
     *     
     */
    public Poruka getTekst() {
        return tekst;
    }

    /**
     * Sets the value of the tekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link Poruka }
     *     
     */
    public void setTekst(Poruka value) {
        this.tekst = value;
    }

    /**
     * Gets the value of the signal property.
     * 
     */
    public boolean isSignal() {
        return signal;
    }

    /**
     * Sets the value of the signal property.
     * 
     */
    public void setSignal(boolean value) {
        this.signal = value;
    }

    /**
     * Gets the value of the nazivOperacije property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivOperacije() {
        return nazivOperacije;
    }

    /**
     * Sets the value of the nazivOperacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivOperacije(String value) {
        this.nazivOperacije = value;
    }

}
