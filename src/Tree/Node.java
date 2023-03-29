package Tree;

public class Node{
    private NodeList head, tail, current;
    private Node parent, next, prev;
    private char nodeName;
    private boolean endOfWord;

    public Node(){
        endOfWord = false;
    }
    public boolean isEndOfWord() {
        return endOfWord;
    }
    public void mark(){
        endOfWord = true;
    }
    public void unmark(){
        endOfWord = false;
    }
    public void setNodeList(Node node) {
        int compare;
        NodeList newNodeList = new NodeList();
        newNodeList.setNode(node);
        if (head == null) {
            head = tail = newNodeList;
            return;
        }
        if (Character.compare(newNodeList.getNode().getNodeName(), head.getNode().getNodeName()) < 0) {
            newNodeList.setNext(head);
            head.setPrev(newNodeList);
            head = newNodeList;
            return;
        }
        if (Character.compare(newNodeList.getNode().getNodeName(), tail.getNode().getNodeName()) > 0) {
            newNodeList.setPrev(tail);
            tail.setNext(newNodeList);
            tail = newNodeList;
            return;
        }
        current = head;
        while (current.getNext() != null) {
            if (Character.compare(current.getNode().getNodeName(), newNodeList.getNode().getNodeName()) < 0 && Character.compare(current.getNext().getNode().getNodeName(), newNodeList.getNode().getNodeName()) > 0) {
                newNodeList.setNext(current.getNext());
                newNodeList.setPrev(current);
                current.getNext().setPrev(newNodeList);
                current.setNext(newNodeList);
                return;
            }
            current = current.getNext();
        }
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getPrev() {
        return prev;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    public NodeList getHead() {
        return head;
    }
    public void setHead(NodeList head) {
        this.head = head;
    }
    public NodeList getTail() {
        return tail;
    }
    public void setTail(NodeList tail) {
        this.tail = tail;
    }
    public NodeList getCurrent() {
        return current;
    }
    public void setCurrent(NodeList current) {
        this.current = current;
    }
    public Node getParent() {
        return parent;
    }
    public void setParent(Node parent) {
        this.parent = parent;
    }
    public char getNodeName() {
        return nodeName;
    }
    public void setNodeName(char nodeName) {
        this.nodeName = nodeName;
    }
}