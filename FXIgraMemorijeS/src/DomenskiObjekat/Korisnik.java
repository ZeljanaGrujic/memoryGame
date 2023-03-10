/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomenskiObjekat;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author user
 */
public class Korisnik extends GeneralDObject implements Serializable {

    int idKorisnik;
    String korisnickoIme;
    String sifra;
    String ime;
    String prezime;
    java.sql.Date datumRegistracije;

    public Korisnik() {
        this.idKorisnik = 0;
        this.korisnickoIme = "";
        this.sifra = "";
        this.ime = "";
        this.prezime = "";
        this.datumRegistracije = datumRegistracije;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = new Date();
        datumRegistracije = java.sql.Date.valueOf(sm.format(dDatum));
    }

    public Korisnik(int idKorisnik, String korisnickoIme, String sifra, String ime, String prezime, java.sql.Date datumRegistracije) {
        this.idKorisnik = idKorisnik;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRegistracije = datumRegistracije;
    }

    public Korisnik(int idKorisnik, String korisnickoIme, String sifra, String ime, String prezime) {
        this.idKorisnik = idKorisnik;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRegistracije = datumRegistracije;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = new Date();
        datumRegistracije = java.sql.Date.valueOf(sm.format(dDatum));
    }

    public Korisnik(String korisnickoIme, String sifra, String ime, String prezime) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRegistracije = datumRegistracije;
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
        Date dDatum = new Date();
        datumRegistracije = java.sql.Date.valueOf(sm.format(dDatum));
    }

    public Korisnik(String korisnickoIme, String sifra, String ime, String prezime, java.sql.Date datumRegistracije) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRegistracije = datumRegistracije;
    }

    // alternativni primarni kljuc     
    public Korisnik(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    // primarni kljuc
    public Korisnik(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public int getIDKorisnik() {
        return this.idKorisnik;
    }

    public String getKorisnickoIme() {
        return this.korisnickoIme;
    }

    public String getSifra() {
        return this.sifra;
    }

    public String getIme() {
        return this.ime;
    }

    public String getPrezime() {
        return this.prezime;
    }

    public java.sql.Date getDatumRegistracije() {
        return datumRegistracije;
    }

    public void setIDKorisnika(int idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setDatumRegistracije(java.sql.Date datumRegistracije) {
        this.datumRegistracije = datumRegistracije;
    }

    @Override
    public String getAtrValue() {
        return idKorisnik + ", '" + korisnickoIme + "', '" + sifra + "', '" + ime + "', '" + prezime + "', '" + datumRegistracije + "'";
    }
    
     @Override
    public String getAtrValue2() {
        return "'"+ korisnickoIme + "', '" + sifra + "', '" + ime + "', '" + prezime + "', '" + datumRegistracije + "'";
    }

    @Override
    public String setAtrValue() {
        return "idKorisnik=" + idKorisnik + ", " + "korisnickoIme='" + korisnickoIme + "', " + "sifra='" + sifra + "', ime='" + ime + "', prezime='" + prezime + "', datumRodjenja='" + datumRegistracije + "'";
    }

    @Override
    public String getClassName() {
        return "Korisnik";
    }

    @Override
    public String getWhereCondition() {
        return "idKorisnik=" + idKorisnik;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"idKorisnik", "korisnickoIme", "sifra", "ime", "prezime", "datumRegistracije"};
        return names[column];
    }

    @Override
    public DomenskiObjekat.GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new DomenskiObjekat.Korisnik(rs.getInt("idKorisnik"), rs.getString("korisnickoIme"), rs.getString("sifra"), rs.getString("ime"), rs.getString("prezime"), rs.getDate("datumRegistracije"));
    }

    @Override
    public String columnsForInsert() {

        return " (korisnickoIme, sifra, ime, prezime, datumRegistracije) ";
    }
}