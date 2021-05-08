package be.bxl.formation.Model.Carnivore;

import be.bxl.formation.Model.Interface.ISole;
import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.enumerations.TypeDeSexualite;

public class Sole extends PoissonCarnivore implements ISole {
    public Sole(String nom, Sexe sexe) {
        super(nom, sexe);
        super.setTypeSexe(TypeDeSexualite.hermaphroditeOpporuniste);
    }
}
