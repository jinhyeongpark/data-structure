// �ڷᱸ��(6007) ���� #5 (60211665 ������)
package ListStackEx;

public class Node<E extends Comparable<E>> {
    private E item;
    private Node<E> next;

    public Node(E newItem, Node<E> p) {
        item = newItem; //���� item
        next = p; //�������� ����� node
    }
    //getter, setter �޼ҵ�
    public E getItem() {return item;}
    public Node<E> getNext() {return next;}
    public void setItem(E newItem) {item = newItem;}
    public void setNext(Node<E> newNext) {next = newNext;}
}