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
    private ArrayList<Poisson> poisson2;
    private ArrayList<Algue> arrayAlgue;
    private Integer nbrEspecePoisson;
    private Integer nbrPoisson = 0;

    private Integer nbrAlgue = 0;
    Integer nbrHasard;

    public Aquarium(String nom, Integer InitNbrPoisson, Integer InitNbrAlgues) {
        this.nom = nom;
        this.poisson = new ArrayList<>();
        this.poisson2 = new ArrayList<>();
        this.arrayAlgue = new ArrayList<>();
        this.nbrEspecePoisson = EspecePoisson.values().length;

        for (int i = 0; i < InitNbrAlgues; i++) {
            AjouterAlgues();
        }

        for (int i = 0; i < InitNbrPoisson; i++) {

            AjouterPoisson();
        }
    }

    public String grandir() {
        StringBuilder resume = new StringBuilder();
        ArrayList<Algue> arrayListClone = (ArrayList<Algue>) this.arrayAlgue.clone();
        for (Algue a : arrayListClone) {
            a.setPv(a.getPv() + 1);
            a.setAge(a.getAge() + 1);
            if (a.getPv() == 10) {
                a.setPv(5);
                AjouterAlgues(10);
            }

        }
        ArrayList<Poisson> arrayListClone2 = new ArrayList<>();
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

                        resume.append("Algues " + (nbrHasard + 1) + " mangee par poisson " + p.getNom() + " pv" + p.getPv() + "\n");
                    } else {
                        p.setPv(0);
                    } // Les herbivores meurs

                }
            }

            if (p instanceof PoissonCarnivore) {

                nbrHasard = Hasard.obtenirEntier(0, (this.poisson.size() - 1));
                Poisson z = this.poisson.get(nbrHasard);
                if (Objects.equals(p, z)) {
                    resume.append(p.getNom() + " veux se manger lui-meme\n");

                } else {
                    z.setPv(z.getPv() - 4);
                    p.setPv(p.getPv() + 5);
                    resume.append(p.getNom() + " a mordu " + z.getNom() + "\n");
                }


            }
            //sexe
            //mono et hermaphridte avec l'age

            resume.append(   RencontreSexe(p));


            // change le sexe du merou et bar apres 10 ans
            if (p.getAge() == 10 && (p instanceof Bar || p instanceof Merou)) {
                p.setSexe(Sexe.F);
            }
            //Poisson age de 20 tour meurs
            if (p.getTours() > 20) {
                p.setPv(0);
            }
            p.setTours(p.getTours() + 1);
        }
        //Ajoute tous les nouveaux
        if (this.poisson2.size() > 0) {
            for (Poisson pTmp : this.poisson2) {
                this.poisson.add(pTmp);


            }
            resume.append(("J ai ajouter " + this.poisson2.size() + " poissons"));
            nbrPoisson++;
            this.poisson2.clear();
        }

        resume.append(SortirLesMorts());
        resume.append("\n \n");
        return resume.toString();
    }


    public String allPoisson() {
        StringBuilder resume = new StringBuilder();
        resume.append("\n");
        resume.append("Voici les poissons\n");
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
        ArrayList<Algue> arrayListClone = (ArrayList<Algue>) this.arrayAlgue.clone();
        for (Algue a : arrayListClone) {

            if (a.getPv() <= 0) {
                this.arrayAlgue.remove(a);
                mortToDay++;
                this.nbrAlgue--;

            }
        }
        if (mortToDay != 0) {
            resume.append((mortToDay + " algues sont mortes aujourdhui\n"));
        }
        ArrayList<Poisson> arrayListClone2 = (ArrayList<Poisson>) this.poisson.clone();

        mortToDay = 0;
        for (Poisson p : arrayListClone2) {
            if (p.getPv() <= 0) {
                this.poisson.remove(p);
                mortToDay++;
                this.nbrPoisson--;
                resume.append(p.getNom() + " Est mort aujourd hui\n");
            }
        }


        if (mortToDay != 0) {
            resume.append((mortToDay + " poisson(s) sont mortes aujourdhui\n"));
        }

        return resume.toString();
    }

    public String allAlgue() {
        StringBuilder resume = new StringBuilder();
        resume.append("Voici les algues\n");
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


        nbrHasard = Hasard.obtenirEntier(0, (EspecePoisson.values().length - 1));
        tmpEspece = EspecePoisson.values()[nbrHasard].toString();
        //Choisi male ou femelle

        tmpSexe = Sexe.values()[Hasard.obtenirEntier(0, (Sexe.values().length) - 1)].toString();

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


    public String RencontreSexe(Poisson p) {
        StringBuilder resume = new StringBuilder();
        int nbrHasard = Hasard.obtenirEntier(0, (poisson.size() - 1));
        Poisson z = this.poisson.get(nbrHasard);
        if (Objects.equals(p, z)) {
            String tmpNom;
            if ((p instanceof Thon && z instanceof Thon) && (p.getSexe() != z.getSexe())) {
                String tmpSexe = Sexe.values()[Hasard.obtenirEntier(0, (Sexe.values().length) - 1)].toString();

                Thon thon = new Thon(DonnerNom(tmpSexe), Sexe.valueOf(tmpSexe));

                poisson2.add(thon);
                resume.append((p.getNom() + " et ") + z.getNom() + " ont fait un enfant nommer" + thon.getNom());
            }

            if ((p instanceof Carpe && z instanceof Carpe) && (p.getSexe() != z.getSexe())) {
                String tmpSexe = Sexe.values()[Hasard.obtenirEntier(0, (Sexe.values().length) - 1)].toString();
                Carpe carpe = new Carpe(DonnerNom(tmpSexe), Sexe.valueOf(tmpSexe));
                poisson2.add(carpe);
                resume.append((p.getNom() + " et ") + z.getNom() + " ont fait un enfant nommer" + carpe.getNom());
            }

            if ((p instanceof Bar && z instanceof Bar) && (p.getSexe() != z.getSexe())) {
                Bar bar = new Bar(DonnerNom("M"));
                poisson2.add(bar);
                resume.append((p.getNom() + " et ") + z.getNom() + " ont fait un enfant nommer" + bar.getNom());
            }

            if ((p instanceof Bar && z instanceof Bar) && (p.getSexe() != z.getSexe())) {

                Merou merou = new Merou(DonnerNom("M"));
                poisson2.add(merou);
                resume.append((p.getNom() + " et ") + z.getNom() + " ont fait un enfant nommer" + merou.getNom());
            }
            if (p instanceof Sole && z instanceof Sole) {
                if (p.getSexe() == z.getSexe()) {
                    p.setSexe(ChangeDeSexe(p.getSexe()));

                }
                String tmpSexe = Sexe.values()[Hasard.obtenirEntier(0, (Sexe.values().length) - 1)].toString();
                Sole sole = new Sole(DonnerNom(tmpSexe), Sexe.valueOf(tmpSexe));
                poisson2.add(sole);
                resume.append((p.getNom() + " et ") + z.getNom() + " ont fait un enfant nommer" + sole.getNom());
            }
            if (p instanceof PoissonClown && z instanceof PoissonClown) {
                if (p.getSexe() == z.getSexe()) {
                    p.setSexe(ChangeDeSexe(p.getSexe()));

                }
                String tmpSexe = Sexe.values()[Hasard.obtenirEntier(0, (Sexe.values().length) - 1)].toString();
                PoissonClown poissonClown = new PoissonClown(DonnerNom(tmpSexe), Sexe.valueOf(tmpSexe));
                poisson2.add(poissonClown);
                resume.append((p.getNom() + " et ") + z.getNom() + " ont fait un enfant nommer" + poissonClown.getNom());
            }
        }
        return resume.toString();
    }

    private Sexe ChangeDeSexe(Sexe sexe) {
        if (sexe == Sexe.F) ;
        sexe = Sexe.M;
        if (sexe == Sexe.M) ;
        sexe = Sexe.F;
        return sexe;
    }


    private String DonnerNom(String tmpSexe) {
        String tmpNom = "";
        if (tmpSexe == "F") {

            tmpNom = NomPoissonFemelle.values()[Hasard.HasardInteger(NomPoissonFemelle.values().length) - 1].toString();
        }
        if (tmpSexe == "M") {
            tmpNom = NomPoissonMale.values()[Hasard.HasardInteger(NomPoissonMale.values().length) - 1].toString();
        }

        return tmpNom;
    }

}
