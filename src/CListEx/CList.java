package CListEx;

import java.util.NoSuchElementException;

public class CList<E> {
    private Node last;
    private int size;

    public CList() {
        last = null;
        size = 0;
    }
    //삽입, 삭제 메소드 선언
    public void insert(E newItem) { //last 다음에 삽입
        Node newNode = new Node(newItem, null); //새 노드 생성
        if (last == null) { //empty
            newNode.setNext(newNode); //newNode 다음에 newNode
            last = newNode; //newNode를 last 로 설정
        }
        else {
            //newNode의 다음이 last 의 다음을 가리키도록
            newNode.setNext(last.getNext());
            //last 는 새로운 노드인 newNode를 가리키도록
            last.setNext(newNode); //last->newNode
        }
        size++; //항목 수 증가
    }
    public void delete() { //last 다음 노드 삭제
        if(isEmpty()) throw new NoSuchElementException();
        Node x = last.getNext(); //x에 자신의 다음을 넣음
        if (x == last) last = null; //자신의 다음이 자신인 경우 null
        else {
            //last 를 last 의 다다음과 연결
            last.setNext(x.getNext()); //다다음을 다음으로
            //last 의 다음을 null 로
            x.setNext(null);
        }
        size--; //항목 수 감소
    }

    public void print() {
        if(size > 0) {
            int i = 0;
            for(Node<E> p = last.getNext(); i < size; p = p.getNext(), i++) {
                System.out.print(p.getItem() + "\t");
            }
        } else System.out.println("리스트 비어있음.");
        System.out.println();
    }
    public int getSize() {
        return size;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}