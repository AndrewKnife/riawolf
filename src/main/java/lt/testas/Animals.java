package lt.testas;

import java.util.ArrayList;
import java.util.List;

public class Animals {
    private static Animals duom = null;

    protected Animals() {
    listas= new ArrayList<Animal>();
    }

    private   List<Animal> listas;

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

    public List<Animal> getListas() {
        return listas;
    }
}
