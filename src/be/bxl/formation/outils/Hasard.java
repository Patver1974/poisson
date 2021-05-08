package be.bxl.formation.outils;

import java.util.Random;

public class Hasard {

    public static Integer HasardInteger ( Integer NbrMax) {
    NbrMax=NbrMax-1;
     Integer resultat = (int) Math.round(Math.random() * (NbrMax));

        return resultat+1;

    }
    public static int genererInt(int borneInf, int borneSup){
        int nb = 0;
if (borneInf<borneSup) {
    Random random = new Random();

    nb = borneInf + random.nextInt(borneSup - borneInf);
}
else
{ nb=borneInf;}
        return nb;

}
    /**
     * Cette méthode permet d'obtenir une valeur aleatoire entre 2 entier
     * @param valeurMin La valeur minimum
     * @param valeurMax La valeur maximum
     * @return La valeur aleatoire
     */
    public static int obtenirEntier(int valeurMin, int valeurMax) {
        if(valeurMin > valeurMax) {
            throw new IllegalArgumentException("Les valeurs ne sont pas correct !");
        }

        return (int)Math.round(Math.random() * (valeurMax - valeurMin)) + valeurMin;
    }




}
