package be.bxl.formation.Model;

import be.bxl.formation.Model.Carnivore.Bar;
import be.bxl.formation.Model.Carnivore.Carpe;
import be.bxl.formation.Model.Carnivore.Sole;
import be.bxl.formation.Model.Herbivore.Merou;
import be.bxl.formation.Model.Herbivore.PoissonClown;
import be.bxl.formation.Model.Herbivore.Thon;
import be.bxl.formation.enumerations.EspecePoisson;
import be.bxl.formation.enumerations.NomPoissonFemelle;
import be.bxl.formation.enumerations.NomPoissonMale;
import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.outils.Hasard;
import org.w3c.dom.ls.LSOutput;

import java.io.StringWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Aquarium {

    private String nom;

    private ArrayList<Poisson> poisson;
    private ArrayList<Algue> Algue;
    private Integer nbrEspecePoisson;


    public Aquarium(String nom, Integer nbrPoisson) {
        this.nom = nom;
        this.poisson = new ArrayList<>();
        this.Algue = new ArrayList<>();
        this.nbrEspecePoisson = EspecePoisson.values().length;
        for (int i = 0; i < 5; i++) {
            AjouterAlgues();
        }

        for (int i = 0; i < nbrPoisson; i++) {

            AjouterPoisson();
        }
    }

    public String allPoisson() {
        StringBuilder resume = new StringBuilder();
        for (Poisson p : this.poisson) {
            if (p instanceof Bar b) {
                resume.append("bar " + b.getNom() + " " + b.getNourriture() + " " + b.getSexe() + " " + b.getTypeSexe() + " " + b.getAge() + " " + b.getPv() + "\n ");
            }
            if (p instanceof Carpe b) {
                resume.append("Carpe " + b.getNom() + " " + b.getNourriture() + " " + b.getSexe() + " " + b.getTypeSexe() + " " + b.getAge() + " " + b.getPv() + "\n ");
            }
            if (p instanceof Sole b) {
                resume.append("Sole " + b.getNom() + " " + b.getNourriture() + " " + b.getSexe() + " " + b.getTypeSexe() + " " + b.getAge() + " " + b.getPv() + "\n ");
            }
            if (p instanceof Merou b) {
                resume.append("Merou " + b.getNom() + " " + b.getNourriture() + " " + b.getSexe() + " " + b.getTypeSexe() + " " + b.getAge() + " " + b.getPv() + "\n ");
            }
            if (p instanceof PoissonClown b) {
                resume.append("PoissonClown " + b.getNom() + " " + b.getNourriture() + " " + b.getSexe() + " " + b.getTypeSexe() + " " + b.getAge() + " " + b.getPv() + "\n ");
            }
            if (p instanceof Thon b) {
                resume.append("Thon " + b.getNom() + " " + b.getNourriture() + " " + b.getSexe() + " " + b.getTypeSexe() + " " + b.getAge() + " " + b.getPv() + "\n ");
            }
        }
        return resume.toString();

    }

    public void AjouterAlgues() {
        Algue algues = new Algue();

        Algue.add(algues);


    }
    public String allAlgue(){
        StringBuilder resume = new StringBuilder();
        for (Algue a : this.Algue) {

                resume.append("algue " + a.Pv + "\n" );

    }
return resume.toString();}
    public void AjouterPoisson() {
        Poisson poissontmp = new Poisson("are", Sexe.values()[Hasard.HasardInteger(Sexe.values().length) - 1]);
        // Choisi une espece de poisson
        Integer nbrHasard;
        String tmpEspece;
        String tmpSexe;
        String tmpNom = "";

        //Choisi Espece de poisson
        nbrHasard = Hasard.genererInt(1, EspecePoisson.values().length);
        tmpEspece = EspecePoisson.values()[nbrHasard].toString();
        //Choisi male ou femelle

        tmpSexe = Sexe.values()[Hasard.HasardInteger(Sexe.values().length) - 1].toString();

        if (tmpSexe == "F") {
            tmpNom = NomPoissonFemelle.values()[Hasard.HasardInteger(NomPoissonFemelle.values().length) - 1].toString();
        }
        if (tmpSexe == "M") {
            tmpNom = NomPoissonMale.values()[Hasard.HasardInteger(NomPoissonMale.values().length) - 1].toString();
        }
        switch (tmpEspece) {
            case "Sole":
                Sole sole = new Sole(tmpNom, Sexe.valueOf(tmpSexe));
                poisson.add(sole);
                break;
            case "Thon":
                Thon thon = new Thon(tmpNom, Sexe.valueOf(tmpSexe));
                poisson.add(thon);
                break;
            case "Merou":
                Merou merou = new Merou(tmpNom, Sexe.valueOf(tmpSexe));
                poisson.add(merou);
                break;

            case "Carpe":
                Carpe carpe = new Carpe(tmpNom, Sexe.valueOf(tmpSexe));
                poisson.add(carpe);
                break;
            case "Bar":
                Bar bar = new Bar(tmpNom, Sexe.valueOf(tmpSexe));
                poisson.add(bar);
                break;
            case "PoissonClown":
                PoissonClown poissonClown = new PoissonClown(tmpNom, Sexe.valueOf(tmpSexe));
                poisson.add(poissonClown);
                break;

        }

    }
}
