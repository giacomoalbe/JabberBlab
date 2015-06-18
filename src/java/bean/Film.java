/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Andrea
 */
public class Film {
    private int id_film;
    private String titolo;
    private int id_genere;
    private String url_trailer;
    private int durata;
    private String trama;
    private String uri_locandina;

    /**
     * @return the id_film
     */
    public int getId_film() {
        return id_film;
    }

    /**
     * @param id_film the id_film to set
     */
    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    /**
     * @return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * @param titolo the titolo to set
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * @return the id_genere
     */
    public int getId_genere() {
        return id_genere;
    }

    /**
     * @param id_genere the id_genere to set
     */
    public void setId_genere(int id_genere) {
        this.id_genere = id_genere;
    }

    /**
     * @return the url_trailer
     */
    public String getUrl_trailer() {
        return url_trailer;
    }

    /**
     * @param url_trailer the url_trailer to set
     */
    public void setUrl_trailer(String url_trailer) {
        this.url_trailer = url_trailer;
    }

    /**
     * @return the durata
     */
    public int getDurata() {
        return durata;
    }

    /**
     * @param durata the durata to set
     */
    public void setDurata(int durata) {
        this.durata = durata;
    }

    /**
     * @return the trama
     */
    public String getTrama() {
        return trama;
    }

    /**
     * @param trama the trama to set
     */
    public void setTrama(String trama) {
        this.trama = trama;
    }

    /**
     * @return the uri_locandina
     */
    public String getUri_locandina() {
        return uri_locandina;
    }

    /**
     * @param uri_locandina the uri_locandina to set
     */
    public void setUri_locandina(String uri_locandina) {
        this.uri_locandina = uri_locandina;
    }
    
    
}
