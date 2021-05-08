package be.bxl.formation.Model.Herbivore;

import be.bxl.formation.Model.Interface.IMerou;
import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.enumerations.TypeDeSexualite;

public class Merou extends PoissonHerbivore  {
    public Merou(String nom) {
        super(nom, Sexe.M);
        super.setTypeSexe(TypeDeSexualite.hermaphroditeAvecLAge);
    }
}

