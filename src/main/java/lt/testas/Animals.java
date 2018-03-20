package lt.testas;

import java.util.ArrayList;
import java.util.List;

public class Animals {
    private static Animals duom = null;

    protected Animals() {

    }

    public static List<Animal> listas = new ArrayList<Animal>();

    public static Animals getInfo() {
        if (duom == null) {
            synchronized (Animals.class) {
                if (duom == null) {
                    duom = new Animals();
                }
            }
        }
        return duom;
    }
}
