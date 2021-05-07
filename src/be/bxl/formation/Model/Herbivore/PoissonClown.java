package be.bxl.formation.Model.Herbivore;

import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.enumerations.TypeDeSexualite;

public class PoissonClown extends PoissonHerbivore{
    public PoissonClown(String nom, Sexe sexe) {
        super(nom, sexe);
        super.setTypeSexe(TypeDeSexualite.hermaphroditeOpporuniste);
    }
}
