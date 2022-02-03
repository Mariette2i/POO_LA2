package entite;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "T_MEMBRE", schema = "BDD_SEL_OK", catalog = "")
public class E_TMembre {
    private int idMembre;
    private String nomMembre;
    private String prenomMembre;
    private String mailMembre;
    private String statut;
    private int soldeHeure;
    private int soldeEcu;
    private String typeMembre;
    private Integer habitant;
    private String raisonSociale;
    private int clientCompteEcu;

    /*
    //TEST : liaisons avec transactions
    @OneToMany(mappedBy= "membreBeneficiaire",cascade = {CascadeType.PERSIST})
    private Collection<E_TTransaction> transactionCollection;*/

    @Id
    @Column(name = "ID_MEMBRE", nullable = false)
    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    @Basic
    @Column(name = "NOM_MEMBRE", nullable = false, length = 45)
    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    @Basic
    @Column(name = "PRENOM_MEMBRE", nullable = false, length = 45)
    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    @Basic
    @Column(name = "MAIL_MEMBRE", nullable = true, length = 45)
    public String getMailMembre() {
        return mailMembre;
    }

    public void setMailMembre(String mailMembre) {
        this.mailMembre = mailMembre;
    }

    @Basic
    @Column(name = "STATUT", nullable = false, length = 1)
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Basic
    @Column(name = "SOLDE_HEURE", nullable = false)
    public int getSoldeHeure() {
        return soldeHeure;
    }

    public void setSoldeHeure(int soldeHeure) {
        this.soldeHeure = soldeHeure;
    }

    @Basic
    @Column(name = "SOLDE_ECU", nullable = false)
    public int getSoldeEcu() {
        return soldeEcu;
    }

    public void setSoldeEcu(int soldeEcu) {
        this.soldeEcu = soldeEcu;
    }

    @Basic
    @Column(name = "TYPE_MEMBRE", nullable = true, length = 3)
    public String getTypeMembre() {
        return typeMembre;
    }

    public void setTypeMembre(String typeMembre) {
        this.typeMembre = typeMembre;
    }

    @Basic
    @Column(name = "HABITANT", nullable = true)
    public Integer getHabitant() {
        return habitant;
    }

    public void setHabitant(Integer habitant) {
        this.habitant = habitant;
    }

    @Basic
    @Column(name = "RAISON_SOCIALE", nullable = true, length = 45)
    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    @Basic
    @Column(name = "CLIENT_COMPTE_ECU", nullable = false)
    public int getClientCompteEcu() {
        return clientCompteEcu;
    }

    public void setClientCompteEcu(int clientCompteEcu) {
        this.clientCompteEcu = clientCompteEcu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        E_TMembre e_tMembre = (E_TMembre) o;
        return idMembre == e_tMembre.idMembre &&
                soldeHeure == e_tMembre.soldeHeure &&
                soldeEcu == e_tMembre.soldeEcu &&
                clientCompteEcu == e_tMembre.clientCompteEcu &&
                Objects.equals(nomMembre, e_tMembre.nomMembre) &&
                Objects.equals(prenomMembre, e_tMembre.prenomMembre) &&
                Objects.equals(mailMembre, e_tMembre.mailMembre) &&
                Objects.equals(statut, e_tMembre.statut) &&
                Objects.equals(typeMembre, e_tMembre.typeMembre) &&
                Objects.equals(habitant, e_tMembre.habitant) &&
                Objects.equals(raisonSociale, e_tMembre.raisonSociale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMembre, nomMembre, prenomMembre, mailMembre, statut, soldeHeure, soldeEcu, typeMembre, habitant, raisonSociale, clientCompteEcu);
    }

    @Override
    public String toString() {
        return "E_TMembre{" +
                "idMembre=" + idMembre +
                ", nomMembre='" + nomMembre + '\'' +
                ", prenomMembre='" + prenomMembre + '\'' +
                ", mailMembre='" + mailMembre + '\'' +
                ", statut='" + statut + '\'' +
                ", soldeHeure=" + soldeHeure +
                ", soldeEcu=" + soldeEcu +
                ", typeMembre='" + typeMembre + '\'' +
                ", habitant=" + habitant +
                ", raisonSociale='" + raisonSociale + '\'' +
                ", clientCompteEcu=" + clientCompteEcu +
                '}';
    }
}
