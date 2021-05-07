package be.bxl.formation;

import be.bxl.formation.Model.Aquarium;
import be.bxl.formation.Model.Herbivore.Merou;
import be.bxl.formation.enumerations.EspecePoisson;
import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.outils.Hasard;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
Aquarium a = new Aquarium("Aquarium Belique", 20);
        System.out.println(a.allPoisson());
        System.out.println(a.allAlgue());



    }
}
