package be.bxl.formation.Model;

import be.bxl.formation.enumerations.Nourriture;
import be.bxl.formation.enumerations.Sexe;
import be.bxl.formation.enumerations.TypeDeSexualite;

public class Poisson {
    private String nom;
    private Sexe sexe;
    private Integer Pv;
    private Integer age=0;
    private Nourriture nourriture;
    private TypeDeSexualite TypeSexe;



    public Poisson(String nom, Sexe sexe) {
        this.nom = nom;
        this.sexe = sexe;
        Pv = 10;
        this.age = 0;
    }

    public String getNom() {
        return nom;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public Integer getPv() {
        return Pv;
    }

    public Integer getAge() {
        return age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public void setPv(Integer pv) {
        Pv = pv;
    }

    public void setAge(Integer age) {
        this.age = age;

    }

    public Nourriture getNourriture() {
        return nourriture;
    }

    public void setNourriture(Nourriture nourriture) {
        this.nourriture = nourriture;
    }

    public TypeDeSexualite getTypeSexe() {
        return TypeSexe;
    }

    public void setTypeSexe(TypeDeSexualite typeSexe) {
        TypeSexe = typeSexe;
    }
}
