package lt.testas.factories;

import lt.testas.*;
import lt.testas.interfaces.*;
import lt.testas.strategies.Crawls;
import lt.testas.strategies.Flies;
import lt.testas.strategies.Runs;
import lt.testas.strategies.Walks;

public class AnimalFactory {

    public void createAnimal(XML xml) {
        Animal animal;
        animal = getFamily(xml.getNodeFamily());
        animal.setFamily(xml.getNodeFamily().trim());
        animal.setType(xml.getNodeType().trim());
        animal.setName(xml.getNodeName().trim());
        animal.setWeight(Double.parseDouble(xml.getNodeWeight()));
        animal.setHeight(Double.parseDouble(xml.getNodeHeight()));
        animal.setIMovement(getMovement(xml.getNodeMove()));
        Animals.getInfo().getListas().add(animal);
    }

    public Animal getFamily(String familyName) {
        if (familyName.toUpperCase().contains("MAMMAL")) {
            return new Mammal();
        } else if (familyName.toUpperCase().contains("BIRD")) {
            return new Bird();
        } else if (familyName.toUpperCase().contains("BUG")) {
            return new Bug();
        } else if (familyName.toUpperCase().contains("SPIDER")) {
            return new Spider();
        } else {
            return null;
        }
    }

    public IMovement getMovement(String moveType) {
        if (moveType.toUpperCase().contains("WALKS")) {
            return new Walks();
        } else if (moveType.toUpperCase().contains("RUNS")) {
            return new Runs();
        } else if (moveType.toUpperCase().contains("FLIES")) {
            return new Flies();
        } else if (moveType.toUpperCase().contains("CRAWLS")) {
            return new Crawls();
        } else {
            return null;
        }
    }
}
