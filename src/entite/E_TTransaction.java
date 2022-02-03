package entite;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "T_TRANSACTION", schema = "BDD_SEL_OK", catalog = "")
public class E_TTransaction {
    private int idTransaction;
    private Date dateCreation;
    private String etat;
    private Date dateValidation;
    private int montantTransaction;
    private int montantEcu;

    //many to One vers les membres
    /*@ManyToOne
    @JoinColumn(name="ID_MEMBRE", referencedColumnName = "ID_MEMBRE", nullable = false)
    private E_TMembre membreBeneficiaire;*/

    @Id
    @Column(name = "ID_TRANSACTION", nullable = false)
    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    @Basic
    @Column(name = "DATE_CREATION", nullable = false)
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Basic
    @Column(name = "ETAT", nullable = false, length = 1)
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Basic
    @Column(name = "DATE_VALIDATION", nullable = true)
    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    @Basic
    @Column(name = "MONTANT_TRANSACTION", nullable = false)
    public int getMontantTransaction() {
        return montantTransaction;
    }

    public void setMontantTransaction(int montantTransaction) {
        this.montantTransaction = montantTransaction;
    }

    @Basic
    @Column(name = "MONTANT_ECU", nullable = false)
    public int getMontantEcu() {
        return montantEcu;
    }

    public void setMontantEcu(int montantEcu) {
        this.montantEcu = montantEcu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        E_TTransaction that = (E_TTransaction) o;
        return idTransaction == that.idTransaction &&
                montantTransaction == that.montantTransaction &&
                montantEcu == that.montantEcu &&
                Objects.equals(dateCreation, that.dateCreation) &&
                Objects.equals(etat, that.etat) &&
                Objects.equals(dateValidation, that.dateValidation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransaction, dateCreation, etat, dateValidation, montantTransaction, montantEcu);
    }

    @Override
    public String toString() {
        return "E_TTransaction{" +
                "idTransaction=" + idTransaction +
                ", dateCreation=" + dateCreation +
                ", etat='" + etat + '\'' +
                ", dateValidation=" + dateValidation +
                ", montantTransaction=" + montantTransaction +
                ", montantEcu=" + montantEcu +
                //", membreBeneficiaire=" + membreBeneficiaire +
                '}';
    }

   /* public E_TMembre getMembreBeneficiaire() {
        return membreBeneficiaire;
    }*/
}
