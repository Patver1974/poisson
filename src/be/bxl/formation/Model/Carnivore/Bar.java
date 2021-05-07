package be.bxl.formation.Model.Carnivore;

import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.enumerations.TypeDeSexualite;

public class Bar extends PoissonCarnivore{
    public Bar(String nom, Sexe sexe) {
        super(nom, sexe);
        super.setTypeSexe(TypeDeSexualite.hermaphroditeAvecLAge);
    }
}
