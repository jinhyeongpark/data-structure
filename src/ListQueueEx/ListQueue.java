package ListQueueEx;

import java.util.NoSuchElementException;
import SListEx.Node;

public class ListQueue<E extends Comparable<E>> {
    private Node<E> front, rear;
    private int size;

    public ListQueue() {
        front = rear = null;
        size = 0;
    }
    public int size() {return size;}
    public Node front() {return front;}
    public Node rear() {return front;}
    public boolean isEmpty() {return (size == 0);}

    //add(), remover();
    public void add(E newItem) {
        Node newNode = new Node(newItem, null); // 새 노드 생성
        if(isEmpty()) front = newNode;
        else rear.setNext(newNode); //그렇지 않으면 rear 의 next 가 newNode를 가리킴
        rear = newNode;
        size++;
    }
    public E remove() {
        if(isEmpty()) throw new NoSuchElementException();
        E frontItem = front.getItem(); //frontItem에 front 항목 대입
        front = front.getNext(); //front 다음 항목을 front 에 넣음
        if(isEmpty()) rear = null; //비었다면 rear 를 null
        size--;
        return frontItem;
    }
}
