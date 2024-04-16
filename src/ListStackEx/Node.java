// 자료구조(6007) 과제 #5 (60211665 박진형)
package ListStackEx;

public class Node<E extends Comparable<E>> {
    private E item;
    private Node<E> next;

    public Node(E newItem, Node<E> p) {
        item = newItem; //담을 item
        next = p; //다음으로 연결될 node
    }
    //getter, setter 메소드
    public E getItem() {return item;}
    public Node<E> getNext() {return next;}
    public void setItem(E newItem) {item = newItem;}
    public void setNext(Node<E> newNext) {next = newNext;}
}