package lt.testas;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML {
    private Node animalNode;
    private Node familyNode;
    private Node typeNode;

    public XML(Node animalNode, Node familyNode, Node typeNode) {
        this.animalNode = animalNode;
        this.familyNode = familyNode;
        this.typeNode = typeNode;
    }

    //region Getters

    public Node getAnimalNode() {
        return animalNode;
    }

    public Node getFamilyNode() {
        return familyNode;
    }

    public Node getTypeNode() {
        return typeNode;
    }

    //endregion
}
