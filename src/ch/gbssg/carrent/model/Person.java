package ch.gbssg.carrent.model;

import javax.print.DocFlavor;
import java.util.Date;
import java.time.LocalDate;

/**
 * Created by jaquet on 19.04.2016.
 */
public class Person {
  private String benutzername;
  private String passwort;
  private String vorname;
  private String name;
  private LocalDate geburtsdatum;
  private String mail;
  private String konto;

  public Person(String user, String pw, String surename, String name, LocalDate birth){
    this.benutzername = user;
    this.passwort = pw;
    this.vorname = surename;
    this.name = name;
    this.geburtsdatum = birth;
  }

  public String getBenutzername() {
    return benutzername;
  }

  public String getPasswort() {
    return passwort;
  }

  public String getVorname() {
    return vorname;
  }
  public String getName() {
    return name;
  }
  public LocalDate getGeburtsdatum() {
    return geburtsdatum;
  }
  public String getMail() {
    return mail;
  }
  public String getKonto() {
    return konto;
  }

    public void setName(String name) {
        this.name = name;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public void setKonto(String konto) {
        this.konto = konto;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
}
