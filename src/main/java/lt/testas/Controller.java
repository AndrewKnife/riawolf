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

    //region Getters
    public DataWorker getWorker() {
        return worker;
    }

    public Viewer getViewer() {
        return viewer;
    }
    //endregion

    public void createList(String fileName){
        AnimalFactory factory = new AnimalFactory();
        animals = animals.getInfo();
        Document dok = worker.readFile(fileName);
        List<XML> xmllist =  worker.populateNodes(dok);
        factory.populateList(xmllist);
    }

    public void selectionMenu(){
        viewer.printAllNames(animals.listas);
        viewer.chooseAnimal(animals.listas);
    }


}
