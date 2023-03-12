/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import DomenskiObjekat.GeneralDObject;
import SO.KreirajDKRegistracija;
import TransferObjekat.GenerickiTransferObjekat;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class GenerickiKontrolerServer {

    static ServerSocket ss;
    static List<Klijent> lkl = new ArrayList<>();
    static int brojKlijenta;

    public GenerickiKontrolerServer() {
    }

    public static void main(String arg[]) throws Exception {
        GenerickiKontrolerServer gks = new GenerickiKontrolerServer();
        gks.izvrsiGenerickiKontroler();
    }

    void izvrsiGenerickiKontroler() throws Exception {
        ss = new ServerSocket(8189);
        System.out.println("Podignut je serverski program:");
        while (true) {
            Socket soketS = ss.accept();
            Klijent kl = new Klijent(soketS, ++brojKlijenta);
            lkl.add(kl);
        }
    }
}

class Klijent extends Thread {

    public Klijent(Socket soketS1, int brojKlijenta) {
        soketS = soketS1;
        this.brojKlijenta = brojKlijenta;
        System.out.println("Klijent:" + brojKlijenta + " je uspostavio konekciju!!!");
        start();
    }

    public void run() {
        try {

            GenerickiTransferObjekat tok;

            while (true) {
                out = new ObjectOutputStream(soketS.getOutputStream());
                in = new ObjectInputStream(soketS.getInputStream());

                tok = (GenerickiTransferObjekat) in.readObject();
                System.out.println("Dobijeni TOK objekat je" + tok.toString());

                if (tok.nazivOperacije.equals("kreirajDK")) {
                    kreirajDK(tok);

                }

                System.out.println("TOK objekat koji se salje je: " + tok.toString());
                out.writeObject(tok);
            }
        } catch (Exception e) {
            System.out.println("Greska prilikom slanja objekta sa servera");
        }
    }

    private Socket soketS;
    ObjectOutputStream out;
    ObjectInputStream in;

    int brojKlijenta;

    private GenerickiTransferObjekat kreirajDK(GenerickiTransferObjekat gto) {

        new KreirajDKRegistracija().kreirajDK(gto);

        return gto;
    }
}
