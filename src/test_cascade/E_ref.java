package test_cascade;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

public class E_ref {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_REF",nullable = false)
    private int idRef;

    @Basic
    @Column(name = "LIB_REF", length = 45)
    private String libRef;

    @OneToMany(mappedBy="ref",cascade = {CascadeType.PERSIST})
    private Collection<E_fk> refCollection;

    public E_ref() {
    }

    public E_ref(String libRef) {
        this.libRef = libRef;
    }

    public String getLibRef() {
        return libRef;
    }
}
