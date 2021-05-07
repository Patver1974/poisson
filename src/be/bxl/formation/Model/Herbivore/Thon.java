package be.bxl.formation.Model.Herbivore;

import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.enumerations.TypeDeSexualite;

public class Thon extends PoissonHerbivore{
    public Thon(String nom, Sexe sexe) {
        super(nom, sexe);
        super.setTypeSexe(TypeDeSexualite.monosexue);
    }
}
