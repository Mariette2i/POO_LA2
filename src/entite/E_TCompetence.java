package entite;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_COMPETENCE", schema = "BDD_SEL_OK", catalog = "")
public class E_TCompetence {
    private int idCompetence;
    private String competence;
    private E_TCategorie tCategorieByIdCategorie;

    public E_TCompetence() {
    }

    public E_TCompetence(String competence, E_TCategorie tCategorieByIdCategorie) {
        this.competence = competence;
        this.tCategorieByIdCategorie = tCategorieByIdCategorie;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPETENCE", nullable = false)
    public int getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    @Basic
    @Column(name = "COMPETENCE", nullable = false, length = 45)
    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        E_TCompetence that = (E_TCompetence) o;
        return idCompetence == that.idCompetence &&
                Objects.equals(competence, that.competence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompetence, competence);
    }

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE", nullable = false)
    public E_TCategorie gettCategorieByIdCategorie() {
        return tCategorieByIdCategorie;
    }

    public void settCategorieByIdCategorie(E_TCategorie tCategorieByIdCategorie) {
        this.tCategorieByIdCategorie = tCategorieByIdCategorie;
    }
}
