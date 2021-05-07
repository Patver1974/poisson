package be.bxl.formation.Model.Herbivore;

import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.enumerations.TypeDeSexualite;

public class Merou extends PoissonHerbivore{
    public Merou(String nom, Sexe sexe) {
        super(nom, sexe);
        super.setTypeSexe(TypeDeSexualite.hermaphroditeAvecLAge);
    }
}

