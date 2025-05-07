package fr.mallyance.crm.infrastructure.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "FACTURE")
public class FactureEntity {
    @Id
    @Column(name = "ID_FACTURE")
    @SequenceGenerator(name = "facture_seq", sequenceName = "facture_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facture_seq")
    private int idFacture;

    @Column(name = "REFERENCE")
    private String reference;

    @Column(name = "DATE_ETABLISSEMENT")
    private Date dateEtablissement;

    @Column(name = "DATE_ECHEANCE")
    private Date dateEcheance;

    @Column(name = "TJM")
    private BigDecimal tjm;

    @Column(name = "NBR_JOUR")
    private long nbJours;

    @Column(name = "MONTANT_HT")
    private long montantHT;

    @Column(name = "MONTANT_TTC")
    private long montantTTC;

    @Column(name = "NOM_FOURNISSEUR")
    private String nomFournisseur;

    @Column(name = "NOM_CLIENT")
    private String nomClient;

    @Column(name = "STATUT")
    private String statut;

    public int getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(int idFacture) {
        this.idFacture = idFacture;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateEtablissement() {
        return dateEtablissement;
    }

    public void setDateEtablissement(Date dateEtablissement) {
        this.dateEtablissement = dateEtablissement;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public BigDecimal getTjm() {
        return tjm;
    }

    public void setTjm(BigDecimal tjm) {
        this.tjm = tjm;
    }

    public long getNbJours() {
        return nbJours;
    }

    public void setNbJours(long nbJours) {
        this.nbJours = nbJours;
    }

    public long getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(long montantHT) {
        this.montantHT = montantHT;
    }

    public long getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(long montantTTC) {
        this.montantTTC = montantTTC;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
