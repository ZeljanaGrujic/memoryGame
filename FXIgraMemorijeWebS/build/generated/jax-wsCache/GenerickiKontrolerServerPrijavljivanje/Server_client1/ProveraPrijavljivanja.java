
package Server_client1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for proveraPrijavljivanja complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="proveraPrijavljivanja"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arg0" type="{http://Server/}generickiTransferObjekatKorisnik" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "proveraPrijavljivanja", propOrder = {
    "arg0"
})
public class ProveraPrijavljivanja {

    protected GenerickiTransferObjekatKorisnik arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link GenerickiTransferObjekatKorisnik }
     *     
     */
    public GenerickiTransferObjekatKorisnik getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenerickiTransferObjekatKorisnik }
     *     
     */
    public void setArg0(GenerickiTransferObjekatKorisnik value) {
        this.arg0 = value;
    }

}
