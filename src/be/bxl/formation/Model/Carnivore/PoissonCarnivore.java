package be.bxl.formation.Model.Carnivore;

import be.bxl.formation.Model.Poisson;
import be.bxl.formation.enumerations.Nourriture;
import be.bxl.formation.enumerations.Sexe;

public class PoissonCarnivore extends Poisson {
    public PoissonCarnivore(String nom, Sexe sexe) {
        super(nom, sexe);
        super.setNourriture(Nourriture.Carnivore);
    }
}
