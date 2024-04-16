// �ڷᱸ��(6007) ���� #3 (60211665 ������)
package DListEx;

import java.util.NoSuchElementException;

public class DList<E> {
    protected DNode head, tail;
    protected int size;

    public DList() {
        head = new DNode(null, null, null);
        tail = new DNode(null, head, null); //tail ���� ��带 head �� ����
        head.setNext(tail); //head ���� ��带 tail �� ����
        size = 0;
    }

    //����, ������ ���� �޼ҵ�
    //DNode �����ϸ� �Ű������� previous �� next �� ����
    //�� �� ������ ����� ������ ���� set �޼ҵ� ���
    public void insertBefore(DNode p, E newItem) { //p �տ� ����
        if (p == null || p == head) throw new NoSuchElementException();
        DNode t = p.getPrevious(); //p �� ������ t �� ����
        DNode newNode = new DNode(newItem, t, p); //newItem �� ���� �� ����� �յڿ� t �� p �� ����
        p.setPrevious(newNode); //p �� ���� ���� newNode�� ����
        t.setNext(newNode); //t �� ���� ���� newNode�� ����
        size++; //�׸� �� ����
    }

    public void insertAfter(DNode p, E newItem) { //p �ڿ� ����
        if (p == null || p == tail) throw new NoSuchElementException();
        DNode t = p.getNext(); //p �� ������ t �� ����
        DNode newNode = new DNode(newItem, p, t); //newItem �� ���� �� ����� �յڿ� p �� t �� ����
        t.setPrevious(newNode); //t �� ���� ���� newNode�� ����
        p.setNext(newNode); //p �� ���� ���� newNode�� ����
        size++; //�׸� �� ����
    }

    public void delete(DNode x) {
        if (x == null) throw new NoSuchElementException();
        DNode f = x.getPrevious(); //x �� ������ f �� ����
        DNode r = x.getNext(); //x �� ������ r �� ����
        f.setNext(r); //f -> r
        r.setPrevious(f); // f <- r
        size--; //�׸� �� ����
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
        DNode<E> current = head.getNext(); // ��� �������� ����
        System.out.print("�׸��(" + size + ") : ");
        while (current != tail) {
            System.out.print(current.getItem() + " "); // ���� ����� ������ ���
            current = current.getNext(); // ���� ���� �̵�
        }
        System.out.println(); // ��� ���� �� �� �ٲ�
        System.out.println();
    }
}
