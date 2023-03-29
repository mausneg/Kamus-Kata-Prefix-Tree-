package Tree;

import java.util.ArrayList;

import Stack.Stack;

public class Tree{
    private Node root, current;
    private int totalWord;

    private void addChild(char c){
        Node newNode = new Node();
        newNode.setNodeName(c);
        current.setNodeList(newNode);
        newNode.setParent(current);
        current = newNode;
    }
    public void insert(String data){
        totalWord++;
        char[] dataChars = data.toLowerCase().toCharArray();
        if (root == null) {
            Node newNode = new Node();
            root = newNode;
        }
        current = root;
        for (int i = 0; i < dataChars.length; i++) {
            boolean loop = false;
            current.setCurrent(current.getHead());
            while (current.getCurrent() != null) {
                if (current.getCurrent().getNode().getNodeName() == dataChars[i]){
                    current = current.getCurrent().getNode();
                    loop = true;
                    break;
                }
                current.setCurrent(current.getCurrent().getNext());
            }
            if (loop) continue;
            addChild(dataChars[i]);
        }
        current.mark();
    }
    public ArrayList<String> search (String data){
        ArrayList<String> print = new ArrayList<String>();
        Stack visited = new Stack();
        char[] dataChars = data.toCharArray();
        current = root;
        for (int i = 0; i < dataChars.length; i++) {
            boolean found = false;
            current.setCurrent(current.getHead());
            while (current.getCurrent() != null) {
                if (current.getCurrent().getNode().getNodeName() == dataChars[i]) {
                    current = current.getCurrent().getNode();
                    found = true;
                    break;
                }
                current.setCurrent(current.getCurrent().getNext());
            }
            if (found) continue;
            else return print;
        }
        Node mark1 = current;
        visited.push(mark1);
        while (!visited.isEmpty()){
            current = visited.pop();
            if (current != null) {
                current.setCurrent(current.getTail());
                while (current.getCurrent() != null) {
                    visited.push(current.getCurrent().getNode());
                    current.setCurrent(current.getCurrent().getPrev());
                }
            }
            if (current.isEndOfWord()) {
                String temp = "";
                ArrayList<Character> reverse = new ArrayList<Character>(); 
                Node mark2 = current;
                while (mark2 != mark1) {
                    reverse.add(mark2.getNodeName());
                    mark2 = mark2.getParent();
                }
                temp = temp + data;
                for (int i = reverse.size()-1; i >= 0; i--) {
                    temp = temp + reverse.get(i);
                }
                print.add(temp);
            }
        }
        return print;
    }
    public void printAsc(String data){
        ArrayList<String> print = new ArrayList<String>();
        print = search(data);
        if (print.isEmpty()) {
            System.out.println("\nData tidak ditemukan\n");
            return;
        }
        for (int i = 0; i < print.size(); i++) {
            System.out.println(print.get(i));
        }
        System.out.println("\nJumlah Data : " + print.size());
    }
    public void printDesc(String data){
        ArrayList<String> print = new ArrayList<String>();
        print = search(data);
        if (print.isEmpty()) {
            System.out.println("\nData tidak ditemukan\n");
            return;
        }
        for (int i = print.size() - 1; i >= 0; i--) {
            System.out.println(print.get(i));
        }
        System.out.println("\nJumlah Data : " + print.size());
    }
    public boolean delete(String data){
        char[] dataChars = data.toLowerCase().toCharArray();
        current = root;
        for (int i = 0; i < dataChars.length; i++) {
            boolean loop = false;
            current.setCurrent(current.getHead());
            while (current.getCurrent() != null) {
                if (current.getCurrent().getNode().getNodeName() == dataChars[i]){
                    current = current.getCurrent().getNode();
                    loop = true;
                    break;
                }
                current.setCurrent(current.getCurrent().getNext());
            }
            if (loop) continue;
            return false;
        }
        if (!current.isEndOfWord()) return false;
        Node delete = current;
        current = current.getParent();
        delete.unmark();
        if (delete.getHead() != null) return true;
        while (current.getHead().getNext() == null && current != root) {
            if (delete.isEndOfWord()) return true;
            delete = null;
            delete = current;
            current = current.getParent();
        }
        if (current.getHead().getNode() == delete) {
            current.setHead(current.getHead().getNext());
            current.getHead().setPrev(null);
            return true;
        }
        if (current.getTail().getNode() == delete) {
            current.setTail(current.getTail().getPrev());
            current.getTail().setNext(null);
            return true;
        }
        current.setCurrent(current.getHead().getNext());
        while (current.getCurrent().getNext() != null) {
            if (current.getCurrent().getNode() == delete) {
                current.getCurrent().getPrev().setNext(current.getCurrent().getNext());
                current.getCurrent().getNext().setPrev(current.getCurrent().getPrev());
                return true;
            }
            current.setCurrent(current.getCurrent().getNext());
        }
        return true;
    }
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    public int getTotalWord() {
        return totalWord;
    }
    public void setTotalWord(int totalWord) {
        this.totalWord = totalWord;
    }
}
