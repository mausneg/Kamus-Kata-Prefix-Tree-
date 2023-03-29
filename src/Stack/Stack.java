
package Stack;

import Tree.Node;

public class Stack{
    private Node head, tail, current;

    public boolean isEmpty(){
        return (head == null);
    }
    public Node peek(){
        return head;
    }
    public void push(Node node){
        if (isEmpty()) {
            head = tail = node;
            return;
        }
        node.setNext(head);
        head.setPrev(node);
        head = node;
    }
    public Node pop(){
        Node dataPop = peek();
        try {
            head = head.getNext();
            head.setPrev(null);
        } catch (Exception e) {}
        return dataPop;
    }
    public Node getHead() {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;
    }
    public Node getTail() {
        return tail;
    }
    public void setTail(Node tail) {
        this.tail = tail;
    }
    public Node getCurrent() {
        return current;
    }
    public void setCurrent(Node current) {
        this.current = current;
    }
}
