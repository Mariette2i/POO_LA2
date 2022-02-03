package entite;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VAC")
public class E_TVacancier_TEST extends E_TMembre_TEST {
}
