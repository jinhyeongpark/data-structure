// �ڷᱸ��(6007) ���� #5 (60211665 ������)
package ListStackEx;

import java.util.EmptyStackException; //�� ������ ������ �� ��

public class ListStack<E extends Comparable<E>> {
    public Node<E> top;
    public int size;

    public ListStack() {
        top = null;
        size = 0;
    }
    public int size() {return size;}
    public boolean isEmpty() {return(top == null);}
    //peek, push, pop ����
    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.getItem();
    }
    public void push(E newItem) {
        //newNode�� top�� �������� �ٶ󺸰� ��
        Node newNode = new Node(newItem, top);
        //newNode�� top���� ����
        top = newNode;
        size++;
    }
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E topItem = top.getItem(); //top �� item �� topItem�� ����
        //top�� ���� ���Ҹ� top���� ����
        top = top.getNext();
        size--; //�׸� �� ����
        return topItem; //topItem ��ȯ
    }
}