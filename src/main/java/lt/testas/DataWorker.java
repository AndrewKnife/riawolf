package lt.testas;

import lt.testas.factories.AnimalFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class DataWorker {

    public Document readFile(String fileName) {
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

    public List<XML> populateNodes(Document dokas) {
        List<XML> nodelist = new ArrayList<XML>();
        XML nodes;
        Node nod2;
        Node nod;
        Node nod3;
        NodeList animalinfo;
        animalinfo = dokas.getElementsByTagName("animal");

        for (int i = 0; i < animalinfo.getLength(); i++) {
            try{
            nod = animalinfo.item(i);
            nod2 = nod.getChildNodes().item(1);
            nod3 = nod2.getChildNodes().item(1);
            nodes = new XML(nod, nod2, nod3);
            nodelist.add(nodes);
            }catch (Exception e){

            }
        }
        return nodelist;
    }

}
