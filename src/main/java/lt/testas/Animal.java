package lt.testas;

import lt.testas.interfaces.IMovement;

public class Animal {
    String family;
    String type;
    String name;
    double weight;
    double height;
    IMovement IMovement;

    public Animal() {

    }

    public Animal(String family, String type, String name, double weight, double height) {
        this.family = family;
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "{" +
                "family='" + family +
                ", type='" + type +
                ", name='" + name +
                ", weight=" + weight +
                ", height=" + height +
                '}'+"\n"+ IMovement.move();
    }

    //region Getters
    public String getFamily() {
        return family;
    }


    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
    //endregion


    //region Setters
    public void setFamily(String family) {
        this.family = family;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setIMovement(lt.testas.interfaces.IMovement IMovement) {
        this.IMovement = IMovement;
    }
    //endregion
}
