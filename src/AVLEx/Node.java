package AVLEx;

public class Node<Key extends Comparable<Key>, Value> {
    Key id;
    Value name;
    int height;
    Node left, right;
    public Node(Key newID, Value newName, int newHeight) {
        id = newID;
        name = newName;
        height = newHeight;
        left = right = null;
    }
    public Key getKey() {return id;}
    public Value getValue() {return name;}
    public int getHeight() {return height;}
    public Node getLeft() {return left;}
    public Node getRight() {return right;}

    public String toString() {
        return String.valueOf(id);
    }
}
