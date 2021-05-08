package be.bxl.formation.Model;

import be.bxl.formation.Model.Carnivore.Bar;
import be.bxl.formation.Model.Carnivore.Carpe;
import be.bxl.formation.Model.Carnivore.PoissonCarnivore;
import be.bxl.formation.Model.Carnivore.Sole;
import be.bxl.formation.Model.Herbivore.Merou;
import be.bxl.formation.Model.Herbivore.PoissonClown;
import be.bxl.formation.Model.Herbivore.PoissonHerbivore;
import be.bxl.formation.Model.Herbivore.Thon;
import be.bxl.formation.enumerations.*;
import be.bxl.formation.outils.Hasard;

import java.util.ArrayList;
import java.util.Objects;

public class Aquarium {

    private String nom;

    private ArrayList<Poisson> poisson;
    private ArrayList<Algue> arrayAlgue;
    private Integer nbrEspecePoisson;
    private Integer nbrPoisson = 0;

    private Integer nbrAlgue = 0;
    Integer nbrHasard;

    public Aquarium(String nom, Integer InitNbrPoisson, Integer InitNbrAlgues) {
        this.nom = nom;
        this.poisson = new ArrayList<>();
        this.arrayAlgue = new ArrayList<>();
        this.nbrEspecePoisson = EspecePoisson.values().length;

        for (int i = 0; i < InitNbrAlgues; i++) {
            AjouterAlgues();
        }

        for (int i = 0; i < InitNbrPoisson; i++) {

            AjouterPoisson();
        }
    }

    public StringBuilder grandir() {
        StringBuilder resume = new StringBuilder();

        for (Algue a : this.arrayAlgue) {
            a.setPv(a.getPv() + 1);
            a.setAge(a.getAge() + 1);
            if (a.getPv()==10){a.setPv(5);AjouterAlgues(5);}

        }
        for (Poisson p : this.poisson) {
            p.setPv(p.getPv() - 1);
            p.setAge((p.getAge() + 1));
            Algue a;
            if (p instanceof PoissonHerbivore) {
                if (p.getPv() <= 5) {
                    if (this.nbrAlgue > 0) {
                        nbrHasard = Hasard.obtenirEntier(0, (this.arrayAlgue.size() - 1));

                        a = arrayAlgue.get(nbrHasard);


                        a.setPv((a.getPv() - 2));
                        p.setPv(p.getPv() + 3);

                        resume.append("Alques " + (nbrHasard + 1) + " mangee par poisson " + p.getNom() + " pv" + p.getPv() + "\n");
                    } else {
                        p.setPv(0);
                    } // Les herbivores meurs

                }
            }

            if (p instanceof PoissonCarnivore) {

                nbrHasard = Hasard.obtenirEntier(0, (this.poisson.size()-1));
                Poisson z = this.poisson.get(nbrHasard);
                if (Objects.equals(p, z)) {
                    resume.append(p.getNom() + " veux se manger lui-meme\n");

                } else {
                    z.setPv(z.getPv() - 4);
                    p.setPv(p.getPv() + 5);
                    resume.append(p.getNom() + " a mordu " + z.getNom() + "\n");
                }


            }
        }
        resume.append(SortirLesMorts());
        resume.append("\n \n");
        return resume;
    }


    public String allPoisson() {
        StringBuilder resume = new StringBuilder();
        for (Poisson p : this.poisson) {
            if (p instanceof Bar b) {
                resume.append("bar " + b.getNom() + " " + b.getNourriture() + " " + b.getSexe() + " " + b.getTypeSexe() + " age : " + b.getAge() + " pv: " + b.getPv() + "\n ");
            }
            if (p instanceof Carpe b) {
                resume.append("Carpe " + b.getNom() + " " + b.getNourriture() + " " + b.getSexe() + " " + b.getTypeSexe() + " age : " + b.getAge() + " pv: " + b.getPv() + "\n ");
            }
            if (p instanceof Sole b) {
                resume.append("Sole " + b.getNom() + " " + b.getNourriture() + " " + b.getSexe() + " " + b.getTypeSexe() + " age : " + b.getAge() + " pv: " + b.getPv() + "\n ");
            }
            if (p instanceof Merou b) {
                resume.append("Merou " + b.getNom() + " " + b.getNourriture() + " " + b.getSexe() + " " + b.getTypeSexe() + " age : " + b.getAge() + " pv: " + b.getPv() + "\n ");
            }
            if (p instanceof PoissonClown b) {
                resume.append("PoissonClown " + b.getNom() + " " + b.getNourriture() + " " + b.getSexe() + " " + b.getTypeSexe() + " age : " + b.getAge() + " pv: " + b.getPv() + "\n ");
            }
            if (p instanceof Thon b) {
                resume.append("Thon " + b.getNom() + " " + b.getNourriture() + " " + b.getSexe() + " " + b.getTypeSexe() + " age : " + b.getAge() + " pv: " + b.getPv() + "\n ");
            }
        }
        return resume.toString();

    }

    public Integer getNbrPoisson() {
        return nbrPoisson;
    }

    public Integer getNbrAlgue() {
        return nbrAlgue;
    }

    public void AjouterAlgues() {
        Algue algues = new Algue();

        this.arrayAlgue.add(algues);
        this.nbrAlgue++;

    }
    public void AjouterAlgues(Integer pv) {
        Algue algues = new Algue();
        algues.setPv(pv);
        this.arrayAlgue.add(algues);

        this.nbrAlgue++;

    }

    public String SortirLesMorts() {
        StringBuilder resume = new StringBuilder();
        Integer mortToDay = 0;
        ArrayList<Algue> arrayListClone =  (ArrayList<Algue>) this.arrayAlgue.clone();
        for (Algue a : arrayListClone) {

            if (a.getPv() <= 0) {
                this.arrayAlgue.remove(a);
                mortToDay++;
                this.nbrAlgue--;

            }}

        ArrayList<Poisson> arrayListClone2 =  (ArrayList<Poisson>) this.poisson.clone();



            for (Poisson p : arrayListClone2) {
                if (p.getPv() <= 0) {
                    this.poisson.remove(p);
                    mortToDay++;
                    this.nbrPoisson--;

                }}


        if (mortToDay!=0){resume.append((mortToDay + " algues sont mortes aujourdhui\n"));}

        return resume.toString();
    }

    public String allAlgue() {
        StringBuilder resume = new StringBuilder();
        for (Algue a : this.arrayAlgue) {

            resume.append("age " + a.getAge() + " Pv  : " + a.getPv() + "\n");


        }
        return resume.toString();
    }

    public void AjouterPoisson() {
        Poisson poissontmp = new Poisson("are", Sexe.values()[Hasard.HasardInteger(Sexe.values().length) - 1]);
        // Choisi une espece de poisson
        Integer nbrHasard;
        String tmpEspece;
        String tmpSexe;
        String tmpNom = "";

        //Choisi Espece de poisson



            nbrHasard = Hasard.obtenirEntier(0,(EspecePoisson.values().length-1));
            tmpEspece = EspecePoisson.values()[nbrHasard].toString();
        //Choisi male ou femelle

        tmpSexe = Sexe.values()[Hasard.obtenirEntier(0,(Sexe.values().length) - 1)].toString();

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
                Merou merou = new Merou(tmpNom);
                poisson.add(merou);
                break;

            case "Carpe":
                Carpe carpe = new Carpe(tmpNom, Sexe.valueOf(tmpSexe));
                poisson.add(carpe);
                break;
            case "Bar":
                Bar bar = new Bar(tmpNom);
                poisson.add(bar);
                break;
            case "PoissonClown":
                PoissonClown poissonClown = new PoissonClown(tmpNom, Sexe.valueOf(tmpSexe));
                poisson.add(poissonClown);
                break;

        }
        nbrPoisson++;
    }
}
