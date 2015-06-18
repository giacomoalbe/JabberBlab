/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import java.io.Serializable;

/**
 *
 * @author Andrea
 */
public class User implements Serializable{
     private int id_utente;
    private String email;
    private String password;
    private double credito;
    private int id_ruolo;

    /**
     * @return the id_utente
     */
    public int getId_utente() {
        return id_utente;
    }

    /**
     * @param id_utente the id_utente to set
     */
    public void setId_utente(int id_utente) {
        this.id_utente = id_utente;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the credito
     */
    public double getCredito() {
        return credito;
    }

    /**
     * @param credito the credito to set
     */
    public void setCredito(double credito) {
        this.credito = credito;
    }

    /**
     * @return the id_ruolo
     */
    public int getId_ruolo() {
        return id_ruolo;
    }

    /**
     * @param id_ruolo the id_ruolo to set
     */
    public void setId_ruolo(int id_ruolo) {
        this.id_ruolo = id_ruolo;
    }
}
