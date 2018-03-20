package lt.testas;

import lt.testas.factories.AnimalFactory;
import org.w3c.dom.Document;

import java.util.List;

public class Controller {

    private DataWorker worker;
    private Viewer viewer;
    private Animals animals = null;
    private AnimalFactory factory;

    Controller(DataWorker worker, Viewer viewer){
        this.worker = worker;
        this.viewer = viewer;
    }

    public void createList(String fileName){
        factory = new AnimalFactory();
        animals = animals.getInfo();
        Document dok = worker.readFile(fileName);
        List<XML> xmllist =  worker.populateNodes(dok);
        for(XML xml : xmllist){
            factory.createAnimal(xml);
        }

    }

    public void selectionMenu(){
        viewer.printAllNames();
        Animal ani = worker.getAnimalByName(viewer.chooseAnimal());
        viewer.printAnimalInfo(ani);
    }




}
