package lt.testas;

public class XML {

    private String _nodeFamily;
    private String _nodeType;
    private String _nodeName;
    private String _nodeHeight;
    private String _nodeWeight;
    private String _nodeMove;

    public XML(String nodeFamily, String nodeType, String nodeName, String nodeHeight, String nodeWeight, String nodeMove) {
        this._nodeFamily = nodeFamily;
        this._nodeType = nodeType;
        this._nodeName = nodeName;
        this._nodeHeight = nodeHeight;
        this._nodeWeight = nodeWeight;
        this._nodeMove = nodeMove;
    }

    //region Getters
    public String getNodeFamily() {
        return _nodeFamily;
    }

    public String getNodeType() {
        return _nodeType;
    }

    public String getNodeName() {
        return _nodeName;
    }

    public String getNodeHeight() {
        return _nodeHeight;
    }

    public String getNodeWeight() {
        return _nodeWeight;
    }

    public String getNodeMove() {
        return _nodeMove;
    }
    //endregion
}
