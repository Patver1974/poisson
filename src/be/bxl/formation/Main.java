package be.bxl.formation;

import be.bxl.formation.Model.Aquarium;
import be.bxl.formation.Model.Herbivore.Merou;
import be.bxl.formation.enumerations.EspecePoisson;
import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.outils.Hasard;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean quitter = false;
        Scanner sc = new Scanner(System.in);
        Integer jour =1;
        Integer InitNbrpoisson = 3;
        Integer InitNbrAlgues = 2;
Aquarium a = new Aquarium("Aquarium Belique", InitNbrpoisson,InitNbrAlgues);
        System.out.print("Initialise le jour \n" );
        System.out.println("---------------");
        System.out.println("Nombre poisson : "+ InitNbrpoisson + "Nombre Algue "+ a.getNbrAlgue());
        System.out.println(a.allAlgue());
        System.out.println(a.allPoisson());

        do {
            System.out.print("Jour " + jour +"\n" );
            System.out.println("-----------");
            System.out.println(a.grandir());

            if (a.getNbrAlgue()>0){ System.out.println(a.allAlgue());}
            if (a.getNbrPoisson()>0){ System.out.println(a.allPoisson());}

            jour ++;

        }while (!quitter && jour<20);
    }
}
