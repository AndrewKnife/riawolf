import org.w3c.dom.Document;
import java.util.List;

public class Enciklopedija {

    private static final String FILE_ANIMALS = "src/main/resources/animals.xml";

    public static void main(String[] args) {
        Enciklopedija facade = new Enciklopedija();
    }

    public Enciklopedija(){
        DataWorker worker = new DataWorker();
        Controller controller = new Controller();
        Document doc = worker.readFile(FILE_ANIMALS);
        List<Animal> listas = worker.populateList(doc);
        controller.chooseAnimal(listas);
    }


}


