package be.bxl.formation.outils;

import java.util.Random;

public class Hasard {

    public static Integer HasardInteger ( Integer NbrMax) {
    NbrMax=NbrMax-1;
     Integer resultat = (int) Math.round(Math.random() * (NbrMax));

        return resultat+1;

    }
    public static int genererInt(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf+random.nextInt(borneSup-borneInf);
        return nb;
    }

}
