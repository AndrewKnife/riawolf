
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Animal {
    String family;
    String type;
    String name;
    double weight;
    double height;

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

    public String getFamily() {
        return family;
    }

    //region Getters
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
        types a = types.valueOf(moves);
        String move = a.getMovement();
        return move;
    }
}


enum types {
    MAMMAL("Walks"),
    BIRD("Flies"),
    BUG("Crawls"),
    SPIDER("Crawls");

    private String movement;

    types(String move) {
        this.movement = move;
    }

    public String getMovement() {
        return movement;
    }
}

public class KLase {

    private static final String FILE_ANIMALS = "src/main/resources/animals.xml";
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Document doc = readFile(FILE_ANIMALS);
        List<Animal> listas = getInfo(doc);
        showMenu(listas);
    }

    private static void showMenu(List<Animal> listas) {
        boolean working = true;
        boolean rasta = false;
        Animal ani = null;
        String name;
        for (Animal an : listas) {
            System.out.println(an.getName());
        }
        System.out.println("Choose a name");
        while (working) {
            name = scan.nextLine();
            for (int i = 0; i < listas.size(); i++) {
                if(listas.get(i).name.toUpperCase().equals(name.toUpperCase())){
                    ani = listas.get(i);
                    rasta = true;
                    working = false;
                    break;
                }
            }
            if(!rasta){
                System.out.println("Try a different name");
            }
        }
        System.out.println(ani.toString());
        System.out.println(ani.movement());
    }

    private static List<Animal> getInfo(Document dokas) {
        List<Animal> listas = new ArrayList<Animal>();
        Animal animal;
        String family;
        String type;
        String name;
        String height;
        String width;
        Node nod2;
        Node nod;
        Node nod3;
        NodeList animalinfo;
        animalinfo = dokas.getElementsByTagName("animal");

        for (int i = 0; i < animalinfo.getLength(); i++) {
            nod = animalinfo.item(i);
            nod2 = nod.getChildNodes().item(1);
            family = nod2.getNodeName();
            nod3 = nod2.getChildNodes().item(1);
            type = nod3.getNodeName();
            name = (nod3.getChildNodes().item(1).getTextContent()).replace("\n", "");
            name = name.replace("\t", "");
            name = name.replace(" ", "");
            height = nod3.getChildNodes().item(3).getTextContent();
            width = nod3.getChildNodes().item(5).getTextContent();
            animal = new Animal(family, type, name, Double.parseDouble(height), Double.parseDouble(width));
            listas.add(animal);
        }
        return listas;
    }

    private static Document readFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document doc = null;
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileName);
            expr = xpath.compile(fileName);
        } catch (Exception e) {

        }
        return doc;
    }
}


