package entite;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PRT")
public class E_TParticulier_TEST extends E_TMembre_TEST{


    @Override
    public String toString() {
        return "E_TParticulier_TEST{}"+
                super.toString();
    }
}
