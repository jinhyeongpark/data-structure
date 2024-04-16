// 자료구조(6007) 과제 #4 (60211665 박진형)
package ListStackEx;

import java.util.EmptyStackException; //빈 스택을 읽으려 할 때

public class ListStack<E extends Comparable<E>> {
    public Node<E> top;
    public int size;

    public ListStack() {
        top = null;
        size = 0;
    }
    public int size() {return size;}
    public boolean isEmpty() {return(top == null);}
    //peek, push, pop 선언
    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
        return top.getItem();
    }
    public void push(E newItem) {
        Node newNode = new Node(newItem, top); //top 레퍼런스를 next 에 복사
        top = newNode;
        size++;
    }
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E topItem = top.getItem(); //top 의 item 을 topItem에 저장
        top = top.getNext(); //top 이 top 의 다음을 가리키게 함
        size--; //항목 수 감소
        return topItem; //topItem 반환
    }
}