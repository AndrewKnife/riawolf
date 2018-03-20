package lt.testas;

import java.util.List;
import java.util.Scanner;

public class Viewer {
    public void printAllNames() {
        for (Animal an : Animals.getInfo().getListas()) {
            System.out.println(an.getName());
        }
    }

    public String chooseAnimal() {
        Scanner scan = new Scanner(System.in);
        String name;
        System.out.println("Choose a name");
        name = scan.nextLine();
        scan.close();
        return name;
    }

    public void printAnimalInfo(Animal animal){
        System.out.println(animal.toString());
    }
}
