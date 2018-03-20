package lt.testas;

public class Enciklopedija {

    private static final String FILE_ANIMALS = "src/main/resources/animals.xml";

    private DataWorker worker;
    private Viewer viewer;
    private Controller controller;

    public static void main(String[] args) {
        Enciklopedija facade = new Enciklopedija();
    }

    public Enciklopedija(){
        worker = new DataWorker();
        viewer = new Viewer();
        controller = new Controller(worker, viewer);
        controller.createList(FILE_ANIMALS);
        controller.selectionMenu();

    }
}


