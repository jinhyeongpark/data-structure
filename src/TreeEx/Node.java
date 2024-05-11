// 자료구조(6007) 과제 #6 (60211665 박진형)
package TreeEx;

public class Node<Key extends Comparable<Key>> {
    private Key item;
    private Node<Key> left;
    private Node<Key> right;

    public Node(Key newItem, Node lt, Node rt) {
        item = newItem; left = lt; right = rt;
    }
    public Key getKey(){return item;}
    public Node getLeft() {return left;}
    public Node getRight() {return right;}
    public void setKey(Key newItem){item = newItem;}
    public void setLeft(Node lt) {left = lt;}
    public void setRight(Node rt) {right = rt;}
}
