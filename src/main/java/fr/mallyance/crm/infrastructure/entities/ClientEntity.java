package fr.mallyance.crm.infrastructure.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENT")
public class ClientEntity {

    @Id
    @Column (name="ID_CLIENT")
    @SequenceGenerator(name = "client_seq", sequenceName = "client_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    private int idClient;

    @Column (name="RAISON_SOCIALE")
    private String raisonSociale;

    @Column (name="TELEPHONE")
    private String telephone;

    @Column (name="EMAIL")
    String email;

    @Column (name="ADRESSE")
    String adresse;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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
