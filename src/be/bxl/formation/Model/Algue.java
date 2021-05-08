package be.bxl.formation.Model;

public class Algue {
    private Integer Pv;
    private Integer age=0;

    public Algue() {
        this.Pv = 10;
        this.age = 0;
    }

    public Integer getPv() {
        return Pv;
    }

    public Integer getAge() {
        return age;
    }

    public void setPv(Integer pv) {
        Pv = pv;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
