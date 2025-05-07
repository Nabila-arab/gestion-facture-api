package fr.mallyance.crm.exposition.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class ClientDto implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("raisonSociale")
    @NotNull
    private String raisonSociale;

    @JsonProperty("telephone")
    @NotNull
    private String telephone;

    @JsonProperty("email")
    @NotNull
    String email;

    @JsonProperty("adresse")
    String adresse;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
