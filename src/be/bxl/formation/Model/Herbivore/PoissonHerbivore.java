package be.bxl.formation.Model.Herbivore;

import be.bxl.formation.Model.Poisson;
import be.bxl.formation.enumerations.Nourriture;
import be.bxl.formation.enumerations.Sexe;

public class PoissonHerbivore extends Poisson {
    public PoissonHerbivore(String nom, Sexe sexe) {
        super(nom, sexe);
        super.setNourriture(Nourriture.Herbivore);
    }
}
