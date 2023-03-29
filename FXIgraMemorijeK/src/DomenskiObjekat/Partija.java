/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import sun.security.x509.GeneralNameInterface;

/**
 *
 * @author user
 */
public class Partija extends GeneralDObject {

    Long idPartija;
    Long idKorisnik;
    int idIgrica;
    java.sql.Date datumIgranja;

    public Partija() {
        this.idPartija = 0L;
        this.idKorisnik = 0L;
        this.idIgrica = 0;
        this.datumIgranja = datumIgranja;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = new Date();
        datumIgranja = java.sql.Date.valueOf(sm.format(dDatum));
    }

    public Partija(Long idKorisnik, int idIgrica, Date datumIgranja) {

        this.idPartija = 0L;
        this.idKorisnik = idKorisnik;
        this.idIgrica = idIgrica;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = new Date();
        this.datumIgranja = java.sql.Date.valueOf(sm.format(dDatum));
    }

    public Partija(Long idPartija, Long idKorisnik, int idIgrica, Date datumIgranja) {

        this.idPartija = idPartija;
        this.idKorisnik = idKorisnik;
        this.idIgrica = 0;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = new Date();
        datumIgranja = java.sql.Date.valueOf(sm.format(dDatum));
    }

    public Partija(Long idPartija, Long idKorisnik, int idIgrica, java.sql.Date datumIgranja) {

        this.idPartija = idPartija;
        this.idKorisnik = idKorisnik;
        this.idIgrica = 0;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        this.datumIgranja = java.sql.Date.valueOf(sm.format(datumIgranja));
    }

    public Long getIdPartija() {
        return idPartija;
    }

    public void setIdPartija(Long idPartija) {
        this.idPartija = idPartija;
    }

    public Long getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(Long idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public int getIdIgrica() {
        return idIgrica;
    }

    public void setIdIgrica(int idIgrica) {
        this.idIgrica = idIgrica;
    }

    public java.sql.Date getDatumIgranja() {
        return datumIgranja;
    }

    public void setDatumIgranja(java.sql.Date datumIgranja) {
        this.datumIgranja = datumIgranja;
    }

    @Override
    public String getAtrValue() {

        return idPartija + ", " + idKorisnik + ", " + idIgrica + ", '" + datumIgranja + "'";
    }

    @Override
    public String getAtrValue2() {

        return idKorisnik + ", " + idIgrica + ", '" + datumIgranja + "'";
    }

    @Override
    public String setAtrValue() {

        return "idPartija=" + idPartija + ", " + "idKorisnik=" + idKorisnik + ", idIgrica=" + idIgrica + ", datumIgranja='" + datumIgranja + "'";

    }

    @Override
    public String getClassName() {

        return "Partija";
    }

    @Override
    public String getWhereCondition() {

        //  return "idKorisnik=" + idKorisnik; mada cu ja pretrazivati po idkorisnik i id igra
        return "idPartija=" + idPartija;

    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"idPartija", "idKorisnik", "idIgrica", "datumIgranja"};
        return names[column];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new DomenskiObjekat.Partija(rs.getLong("idPartija"), rs.getLong("idKorisnik"), rs.getInt("idIgrica"), rs.getDate("datumIgranja"));
    }

    @Override
    public String columnsForInsert() {
        return " (idKorisnik, idIgrica, datumIgranja) ";
    }

}
