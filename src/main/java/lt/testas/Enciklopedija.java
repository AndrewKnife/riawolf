package lt.testas;

public class Enciklopedija {

    private static final String FILE_ANIMALS = "src/main/resources/animals.xml";

    public static void main(String[] args) {
        Enciklopedija facade = new Enciklopedija();
    }

    public Enciklopedija(){
        DataWorker worker = new DataWorker();
        Viewer viewer = new Viewer();
        Controller controller = new Controller(worker, viewer);
        controller.createList(FILE_ANIMALS);
        controller.selectionMenu();

    }


}


