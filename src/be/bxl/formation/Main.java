package be.bxl.formation;

import be.bxl.formation.Model.Aquarium;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import be.bxl.formation.Model.Herbivore.Merou;
import be.bxl.formation.enumerations.EspecePoisson;
import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.outils.Hasard;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StringBuilder resume = new StringBuilder();
        boolean quitter = false;
        Scanner sc = new Scanner(System.in);
        Integer jour =1;
        Integer InitNbrpoisson = 3;
        Integer InitNbrAlgues = 2;
Aquarium a = new Aquarium("Aquarium Belique", InitNbrpoisson,InitNbrAlgues);
        resume.append("Initialise le jour \n" );
        resume.append("---------------\n");
        resume.append("Nombre poisson : "+ InitNbrpoisson + "Nombre Algue "+ a.getNbrAlgue()+"\n");
        resume.append(a.allAlgue());
        resume.append(a.allPoisson());

        do {
            resume.append("Jour " + jour +"\n" );
            resume.append("-----------");
            resume.append(a.grandir());

            if (a.getNbrAlgue()>0){ resume.append(a.allAlgue());}
            if (a.getNbrPoisson()>0){ resume.append(a.allPoisson());}

            jour ++;

        }while (!quitter && jour<20);
        System.out.println(resume.toString());
        CreerFichier(resume.toString());
    }

    private static void CreerFichier(String resume) {
        try {
            //toute la simulation
            FileWriter myWriter = new FileWriter("aquarium.txt");
            myWriter.write(resume);
            .
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
