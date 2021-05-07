package be.bxl.formation.Model.Carnivore;

import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.enumerations.TypeDeSexualite;

public class Sole extends PoissonCarnivore{
    public Sole(String nom, Sexe sexe) {
        super(nom, sexe);
        super.setTypeSexe(TypeDeSexualite.hermaphroditeOpporuniste);
    }
}
