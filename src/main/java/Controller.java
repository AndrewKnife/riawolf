import java.util.List;
import java.util.Scanner;

public class Controller {
    public void chooseAnimal(List<Animal> listas) {
        Scanner scan = new Scanner(System.in);
        boolean working = true;
        boolean rasta = false;
        Animal ani = null;
        String name;
        Viewer view = new Viewer();
        view.printAllNames(listas);
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
        view.viewAnimal(ani);
        scan.close();
    }
}
