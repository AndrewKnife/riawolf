import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.util.ArrayList;
import java.util.List;

public class DataWorker {
    public static Document readFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(fileName);
        } catch (Exception e) {

        }
        return doc;
    }

    public static List<Animal> populateList(Document dokas) {
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

    public static String defineFamily(String famName){
        return famName;
    }
}
