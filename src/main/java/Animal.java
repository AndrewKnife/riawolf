class Mammal extends Animal{

}

class Bird extends Animal{

}

class Bug extends Animal{

}

class Spider extends Animal{

}

public class Animal {
    String family;
    String type;
    String name;
    double weight;
    double height;

    Animal(){

    }

    Animal(String family, String type, String name, double weight, double height) {
        this.family = family;
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "family='" + family +
                ", type='" + type +
                ", name='" + name +
                ", weight=" + weight +
                ", height=" + height +
                '}';
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

    public String movement() {
        String moves;
        moves = this.family.toUpperCase();
        return moves;
    }
}
