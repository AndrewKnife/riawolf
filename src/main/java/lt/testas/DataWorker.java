package lt.testas;

import lt.testas.factories.AnimalFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
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
        XML xml;
        String family, type, name, height, weight, move;
        NodeList animalinfo = null;
        Node nod;
        NodeList magicNodes;

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr;

        try {
            animalinfo = (NodeList) xpath.compile("/animals/animal/*[1]").evaluate(dokas, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < animalinfo.getLength(); i++) {
            try {
                nod = animalinfo.item(i);
                Element eElement = (Element) nod;
                type = eElement.getTagName();
                family =((Node) xpath.compile("family").evaluate(eElement,XPathConstants.NODE)).getTextContent();
                name = ((Node) xpath.compile("name").evaluate(eElement,XPathConstants.NODE)).getTextContent();
                height = ((Node) xpath.compile("height").evaluate(eElement,XPathConstants.NODE)).getTextContent();
                weight =((Node) xpath.compile("weight").evaluate(eElement,XPathConstants.NODE)).getTextContent();
                move =((Node) xpath.compile("moves").evaluate(eElement,XPathConstants.NODE)).getTextContent();
                xml = new XML(family, type, name,height, weight, move );
                nodelist.add(xml);
            } catch (Exception e) {

            }
        }
        return nodelist;
    }

    public Animal getAnimalByName(String name){
        boolean working = true;
        boolean rasta = false;
        Animal ani = null;
        while (working) {
            for (int i = 0; i < Animals.getInfo().getListas().size(); i++) {
                if(Animals.getInfo().getListas().get(i).name.toUpperCase().equals(name.toUpperCase())){
                    ani = Animals.getInfo().getListas().get(i);
                    rasta = true;
                    working = false;
                    break;
                }
            }
            if(!rasta){
                System.out.println("Try a different name");
            }
        }
        return ani;
    }
}
