// 자료구조(6007) 과제 #3 (60211665 박진형)
package DListEx;

import java.util.NoSuchElementException;

public class DList<E> {
    protected DNode head, tail;
    protected int size;

    public DList() {
        head = new DNode(null, null, null);
        tail = new DNode(null, head, null); //tail 이전 노드를 head 로 설정
        head.setNext(tail); //head 다음 노드를 tail 로 설정
        size = 0;
    }

    //삽입, 삭제를 위한 메소드
    //DNode 생성하며 매개변수에 previous 와 next 를 설정
    //그 후 기존의 노드들과 연결을 위해 set 메소드 사용
    public void insertBefore(DNode p, E newItem) { //p 앞에 삽입
        if (p == null || p == head) throw new NoSuchElementException();
        DNode t = p.getPrevious(); //p 의 이전을 t 로 설정
        DNode newNode = new DNode(newItem, t, p); //newItem 을 가진 새 노드의 앞뒤에 t 와 p 를 연결
        p.setPrevious(newNode); //p 의 이전 노드로 newNode를 설정
        t.setNext(newNode); //t 의 다음 노드로 newNode를 설정
        size++; //항목 수 증가
    }

    public void insertAfter(DNode p, E newItem) { //p 뒤에 삽입
        if (p == null || p == tail) throw new NoSuchElementException();
        DNode t = p.getNext(); //p 의 다음을 t 로 설정
        DNode newNode = new DNode(newItem, p, t); //newItem 을 가진 새 노드의 앞뒤에 p 와 t 를 연결
        t.setPrevious(newNode); //t 의 이전 노드로 newNode를 설정
        p.setNext(newNode); //p 의 다음 노드로 newNode를 설정
        size++; //항목 수 증가
    }

    public void delete(DNode x) {
        if (x == null) throw new NoSuchElementException();
        DNode f = x.getPrevious(); //x 의 이전을 f 에 저장
        DNode r = x.getNext(); //x 의 다음을 r 에 저장
        f.setNext(r); //f -> r
        r.setPrevious(f); // f <- r
        size--; //항목 수 감소
    }
    public int search(E target) {
        DNode current = head.getNext();
        int index = 0;
        while(current != tail) {
            if(current.getItem().equals(target)) return index;
            current = current.getNext();
            index++;
        } return -1;
    }
    public DNode<E> getNode(int index) {
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException();

        DNode<E> current = head.getNext();
        int currentIndex = 0;
        while(currentIndex < index) {
            current = current.getNext();
            currentIndex++;
        } return current;
    }
    public void addFirst(E newItem) {
        DNode<E> newNode = new DNode<>(newItem, head, head.getNext());
        head.getNext().setPrevious(newNode);
        head.setNext(newNode);
        size++;
    }
    public void addLast(E newItem) {
        DNode<E> newNode = new DNode<>(newItem, tail.getPrevious(), tail);
        tail.getPrevious().setNext(newNode);
        tail.setPrevious(newNode);
        size++;
    }
    public void deleteItem(E target) {
        DNode<E> current = head.getNext();
        while(current != tail) {
            if(current.getItem().equals(target)) {
                delete(current);
                return;
            }
            current = current.getNext();
        }
    }
    public void concat(DList<E> other) {
        DNode<E> lastNode = tail.getPrevious();
        DNode<E> current = other.head.getNext();
        while(current != other.tail) {
            addLast(current.getItem());
            current = current.getNext();
        }
    }
    public void print() {
        DNode<E> current = head.getNext(); // 헤드 다음부터 시작
        System.out.print("항목수(" + size + ") : ");
        while (current != tail) {
            System.out.print(current.getItem() + " "); // 현재 노드의 아이템 출력
            current = current.getNext(); // 다음 노드로 이동
        }
        System.out.println(); // 출력 종료 후 줄 바꿈
        System.out.println();
    }
}
