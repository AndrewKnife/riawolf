package lt.testas.factories;

import lt.testas.*;
import lt.testas.interfaces.*;
import lt.testas.strategies.Crawls;
import lt.testas.strategies.Flies;
import lt.testas.strategies.Runs;
import lt.testas.strategies.Walks;

import java.util.List;

public class AnimalFactory {

    public void populateList(List<XML> xmlList){
        Animal animal;
        String family;
        for(XML xml : xmlList){
            try{
                family = xml.getFamilyNode().getNodeName();
                animal = getFamily(family);
                animal.setFamily(family);
                animal.setType(xml.getTypeNode().getNodeName());
                animal.setName(xml.getTypeNode().getChildNodes().item(1).getTextContent().trim());
                animal.setHeight(Double.parseDouble(xml.getTypeNode().getChildNodes().item(3).getTextContent()));
                animal.setWeight(Double.parseDouble(xml.getTypeNode().getChildNodes().item(5).getTextContent()));
                animal.setIMovement(getMovement(xml.getTypeNode().getChildNodes().item(7).getTextContent()));
                Animals.listas.add(animal);
            }catch (Exception e){

            }
        }
    }

    public Animal getFamily(String familyName) {
        if(familyName.toUpperCase().equals("MAMMAL")){
            return new Mammal();
        }else if(familyName.toUpperCase().equals("BIRD")){
            return new Bird();
        }else if(familyName.toUpperCase().equals("BUG")){
            return new Bug();
        }else if(familyName.toUpperCase().equals("SPIDER")){
            return new Spider();
        }else{
            return null;
        }
    }

    public IMovement getMovement(String moveType){
        if(moveType.toUpperCase().contains("WALKS")){
            return new Walks();
        }else if(moveType.toUpperCase().contains("RUNS")){
            return new Runs();
        }else if(moveType.toUpperCase().contains("FLIES")){
            return new Flies();
        }else if(moveType.toUpperCase().contains("CRAWLS")){
            return new Crawls();
        }else{
            return null;
        }
    }
}
