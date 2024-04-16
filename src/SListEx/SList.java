// 자료구조(6007) 과제 2 (박진형 60211665)
package SListEx;

import java.util.NoSuchElementException;

public class SList<E extends Comparable<E>> {
    protected Node head; //연결 리스트의 첫 노드 가리킴
    private int size;

    public SList() {
        head = null; //첫 노드를 null 로 초기화
        size = 0; //노드 수를 저장하는 size 를 0으로 초기화
    }
    //탐색, 삽입, 삭제 연산을 위한 메소드 선언
    public int search(E target) {
        Node p = head; //head부터 탐색 시작
        for (int k = 0; k < size; k++) {
            //if(target == p.getItem())
            if(target.compareTo((E)p.getItem())==0)
                return k;
            p = p.getNext(); //다음 노드를 호출
        }
        return -1; //탐색 실패한 경우 -1 반환
    }
    public void insertFront(E newItem) {
        head = new Node(newItem, head); //새 노드를 만들어 item을 담고 다음 노드로 원래 head를 지정
        size++; //항목 수 증가
    }
    public void insertAfter(E newItem, Node p) { //추가할 item과 추가할 위치 p
        p.setNext(new Node(newItem, p.getNext())); //p의 다음 노드를 자신의 다음 노드로 설정한 후 자신의 p의 다음으로 들어감
        size++; //항목 수 증가
    }
    public void deleteFront() {
        if (isEmpty()) throw new NoSuchElementException();
        head = head.getNext(); //head의 다음 node를 head로 지정
        size--; //항목 수 감
    }
    private boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}
	public void deleteAfter(Node p) {
        if(p == null) throw new NoSuchElementException();
        Node t = p.getNext(); //p의 다음을 t로 설정
        p.setNext(t.getNext()); //p의 다음 자리: t -> t.next()
        t.setNext(null); //t를 null로 설정
        size--; //항목 수 감소
    }
    public Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext(); // 인덱스에 해당하는 노드까지 이동
        }
        return p; // 해당 인덱스의 요소 반환
    }

    public void add(E newItem, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            insertFront(newItem); // 맨 앞에 삽입
        } else {
            Node<E> p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.getNext(); // 삽입할 위치의 이전 노드 찾기
            }
            insertAfter(newItem, p); // 이전 노드 뒤에 삽입
        }
    }
    public void addLast(E newItem) {
        if (head == null) {
            insertFront(newItem); // 리스트가 비어있으면 맨 앞에 삽입
        } else {
            Node<E> p = head;
            while (p.getNext() != null) {
                p = p.getNext(); // 마지막 노드 찾기
            }
            insertAfter(newItem, p); // 마지막 노드 뒤에 삽입
        }
    }
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            deleteFront(); // 맨 앞의 항목 삭제
        } else {
            Node<E> p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.getNext(); // 삭제할 항목의 이전 노드 찾기
            }
            deleteAfter(p); // 삭제할 항목의 이전 노드 다음 항목 삭제
        }
    }
    public void deleteItem(E item) {
        if (head == null) {
            return; // 리스트가 비어있으면 아무 작업도 수행하지 않음
        }
        if (head.getItem().equals(item)) {
            deleteFront(); // 맨 앞의 항목이 삭제 대상인 경우
            return;
        }
        Node<E> prev = head;
        Node<E> current = head.getNext();
        while (current != null) {
            if (current.getItem().equals(item)) {
                prev.setNext(current.getNext()); // 삭제 대상을 건너뛰고 연결
                current.setNext(null); // 삭제 대상을 연결 해제
                size--; // 항목 수 감소
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }
    public void print() {
        Node<E> current = head;
        System.out.print("항목수(" + size + ") : ");
        while (current != null) {
            System.out.print(current.getItem() + " "); // 현재 노드의 요소 출력
            current = current.getNext(); // 다음 노드로 이동
        }
        System.out.println(); // 출력 종료 후 줄 바꿈
        System.out.println();
    }
}