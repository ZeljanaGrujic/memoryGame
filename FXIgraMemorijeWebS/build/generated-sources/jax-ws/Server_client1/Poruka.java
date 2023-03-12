
package Server_client1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for poruka complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="poruka"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idKorisnika" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="poruka" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ulogovaniKorisnik" type="{http://Server/}korisnik" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "poruka", propOrder = {
    "idKorisnika",
    "poruka",
    "ulogovaniKorisnik"
})
public class Poruka {

    protected Long idKorisnika;
    protected String poruka;
    protected Korisnik ulogovaniKorisnik;

    /**
     * Gets the value of the idKorisnika property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdKorisnika() {
        return idKorisnika;
    }

    /**
     * Sets the value of the idKorisnika property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdKorisnika(Long value) {
        this.idKorisnika = value;
    }

    /**
     * Gets the value of the poruka property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoruka() {
        return poruka;
    }

    /**
     * Sets the value of the poruka property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoruka(String value) {
        this.poruka = value;
    }

    /**
     * Gets the value of the ulogovaniKorisnik property.
     * 
     * @return
     *     possible object is
     *     {@link Korisnik }
     *     
     */
    public Korisnik getUlogovaniKorisnik() {
        return ulogovaniKorisnik;
    }

    /**
     * Sets the value of the ulogovaniKorisnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Korisnik }
     *     
     */
    public void setUlogovaniKorisnik(Korisnik value) {
        this.ulogovaniKorisnik = value;
    }

}
