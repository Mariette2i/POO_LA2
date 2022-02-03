package entite;

import test_cascade.E_ref;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "T_EX_CASCADE_FK", schema = "BDD_SEL_OK")
public class E_TExCascadeFk {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_FK",nullable = false)
    private int idFk;

    @Basic
    @Column(name="LIB_FK",length = 45)
    private String libFk;

    @ManyToOne
    @JoinColumn(name="ID_REF", referencedColumnName = "ID_REF", nullable = false)
    private E_TExCascadeRef uneRef;

    public E_TExCascadeFk() {
    }

    public void setUneRef(E_TExCascadeRef uneRef) {
        this.uneRef = uneRef;
    }

    public E_TExCascadeFk(String libFk) {
        this.libFk = libFk;
    }

    public String getLibFk() {
        return libFk;
    }
}
