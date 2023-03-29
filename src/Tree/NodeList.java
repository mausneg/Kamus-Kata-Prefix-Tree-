package Tree;

public class NodeList {
    private NodeList next, prev;
    private Node node;

    public NodeList getNext() {
        return next;
    }
    public void setNext(NodeList next) {
        this.next = next;
    }
    public NodeList getPrev() {
        return prev;
    }
    public void setPrev(NodeList prev) {
        this.prev = prev;
    }
    public Node getNode() {
        return node;
    }
    public void setNode(Node node) {
        this.node = node;
    }

}
