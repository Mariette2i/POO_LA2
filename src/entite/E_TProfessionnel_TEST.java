package entite;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PRO")
public class E_TProfessionnel_TEST extends E_TMembre_TEST {
    private String raisonSociale;

    @Basic
    @Column(name = "RAISON_SOCIALE", nullable = true, length = 45)
    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    @Override
    public String toString() {
        return "E_TProfessionnel_TEST{" +
                super.toString()+
                "raisonSociale='" + raisonSociale + '\'' +
                '}';
    }


}


