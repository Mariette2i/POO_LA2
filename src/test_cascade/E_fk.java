package test_cascade;

import javax.persistence.*;

public class E_fk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FK",nullable = false)
    private int idFk;

    @Basic
    @Column(name="LIB_FK",length = 45)
    private String libFk;

    @ManyToOne
    @JoinColumn(name="ID_REF", referencedColumnName = "ID_REF", nullable = false)
    private E_ref ref;


    public E_fk(String libFk, E_ref ref) {
        this.libFk = libFk;
        this.ref = ref;
    }

    public E_fk() {
    }

    public void setRef(E_ref ref) {
        this.ref = ref;
    }

    public E_fk(String libFk) {
        this.libFk = libFk;
    }

    public String getLibFk() {
        return libFk;
    }
}
