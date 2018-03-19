import java.util.List;

public class Viewer {
    public void printAllNames(List<Animal> listas) {
        for (Animal an : listas) {
            System.out.println(an.getName());
        }
    }

    public void viewAnimal(Animal animal){
        System.out.println(animal.toString());
    }
}
