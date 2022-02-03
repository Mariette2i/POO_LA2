package entite;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "T_EX_CASCADE_REF", schema = "BDD_SEL_OK")
public class E_TExCascadeRef {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_REF",nullable = false)
    private int idRef;

    @Basic
    @Column(name = "LIB_REF", length = 45)
    private String libRef;

    //@OneToMany(mappedBy= "uneRef",cascade = {CascadeType.REMOVE})
    //@OneToMany(mappedBy= "uneRef")
    //@OneToMany(mappedBy= "uneRef",cascade = {CascadeType.REFRESH})
    @OneToMany(mappedBy= "uneRef",cascade = {CascadeType.PERSIST})
    private Collection<E_TExCascadeFk> refCollection;

    public String getLibRef() {
        return libRef;
    }

    public E_TExCascadeRef(String libRef) {
        this.libRef = libRef;
    }

    public void setLibRef(String libRef) {
        this.libRef = libRef;
    }

    public E_TExCascadeRef() {

    }

}
