package entite;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_CATEGORIE", schema = "BDD_SEL_OK", catalog = "")
public class E_TCategorie {
    private int idCategorie;
    private String categorie;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIE", nullable = false)
    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public E_TCategorie() {
    }

    public E_TCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Basic
    @Column(name = "CATEGORIE", nullable = false, length = 45)
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        E_TCategorie that = (E_TCategorie) o;
        return idCategorie == that.idCategorie &&
                Objects.equals(categorie, that.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategorie, categorie);
    }
}
