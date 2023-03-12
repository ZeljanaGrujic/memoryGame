/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Server;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author user
 */
@Path("generickikontrolerserverprijavljivanjeport")
public class GenerickiKontrolerServerPrijavljivanjePort {

    private Server_client1.GenerickiKontrolerServerPrijavljivanje port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenerickiKontrolerServerPrijavljivanjePort
     */
    public GenerickiKontrolerServerPrijavljivanjePort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method proveraPrijavljivanja
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client1.GenerickiTransferObjekatKorisnik>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("proveraprijavljivanja/")
    public JAXBElement<Server_client1.GenerickiTransferObjekatKorisnik> postProveraPrijavljivanja(JAXBElement<Server_client1.GenerickiTransferObjekatKorisnik> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client1.GenerickiTransferObjekatKorisnik result = port.proveraPrijavljivanja(arg0.getValue());
                return new JAXBElement<Server_client1.GenerickiTransferObjekatKorisnik>(new QName("http//Server_client1/", "generickitransferobjekatkorisnik"), Server_client1.GenerickiTransferObjekatKorisnik.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private Server_client1.GenerickiKontrolerServerPrijavljivanje getPort() {
        try {
            // Call Web Service Operation
            Server_client1.GenerickiKontrolerServerPrijavljivanje_Service service = new Server_client1.GenerickiKontrolerServerPrijavljivanje_Service();
            Server_client1.GenerickiKontrolerServerPrijavljivanje p = service.getGenerickiKontrolerServerPrijavljivanjePort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
