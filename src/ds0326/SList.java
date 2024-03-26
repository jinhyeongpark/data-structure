// �ڷᱸ��(6007) ���� 2 (������ 60211665)
package ds0326;

import java.util.NoSuchElementException;

public class SList<E extends Comparable<E>> {
    protected Node head; //���� ����Ʈ�� ù ��� ����Ŵ
    private int size;

    public SList() {
        head = null; //ù ��带 null �� �ʱ�ȭ
        size = 0; //��� ���� �����ϴ� size �� 0���� �ʱ�ȭ
    }
    //Ž��, ����, ���� ������ ���� �޼ҵ� ����
    public int search(E target) {
        Node p = head; //head���� Ž�� ����
        for (int k = 0; k < size; k++) {
            //if(target == p.getItem())
            if(target.compareTo((E) p.getItem())==0)
                return k;
            p = p.getNext(); //���� ��带 ȣ��
        }
        return -1; //Ž�� ������ ��� -1 ��ȯ
    }
    public void insertFront(E newItem) {
        head = new Node(newItem, head); //�� ��带 ����� item�� ��� ���� ���� ���� head�� ����
        size++; //�׸� �� ����
    }
    public void insertAfter(E newItem, Node p) { //�߰��� item�� �߰��� ��ġ p
        p.setNext(new Node(newItem, p.getNext())); //p�� ���� ��带 �ڽ��� ���� ���� ������ �� �ڽ��� p�� �������� ��
        size++; //�׸� �� ����
    }
    public void deleteFront() {
        //if (isEmpty()) throw new NoSuchElementException();
        head = head.getNext(); //head�� ���� node�� head�� ����
        size--; //�׸� �� ��
    }
    public void deleteAfter(Node p) {
        if(p == null) throw new NoSuchElementException();
        Node t = p.getNext(); //p�� ������ t�� ����
        p.setNext(t.getNext()); //p�� ���� �ڸ�: t -> t.next()
        t.setNext(null); //t�� null�� ����
        size--; //�׸� �� ����
    }
    public Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> p = head;
        for (int i = 0; i < index; i++) {
            p = p.getNext(); // �ε����� �ش��ϴ� ������ �̵�
        }
        return p; // �ش� �ε����� ��� ��ȯ
    }

    public void add(E newItem, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            insertFront(newItem); // �� �տ� ����
        } else {
            Node<E> p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.getNext(); // ������ ��ġ�� ���� ��� ã��
            }
            insertAfter(newItem, p); // ���� ��� �ڿ� ����
        }
    }
    public void addLast(E newItem) {
        if (head == null) {
            System.out.println("addLast���� head == null ��Ȳ");
            insertFront(newItem); // ����Ʈ�� ��������� �� �տ� ����
        } else {
            Node<E> p = head;
            while (p.getNext() != null) {
                p = p.getNext(); // ������ ��� ã��
            }
            insertAfter(newItem, p); // ������ ��� �ڿ� ����
        }
    }
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            deleteFront(); // �� ���� �׸� ����
        } else {
            Node<E> p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.getNext(); // ������ �׸��� ���� ��� ã��
            }
            deleteAfter(p); // ������ �׸��� ���� ��� ���� �׸� ����
            size--;
        }
    }
    public void deleteItem(E item) {
        if (head == null) {
            return; // ����Ʈ�� ��������� �ƹ� �۾��� �������� ����
        }
        if (head.getItem().equals(item)) {
            deleteFront(); // �� ���� �׸��� ���� ����� ���
            return;
        }
        Node<E> prev = head;
        Node<E> current = head.getNext();
        while (current != null) {
            if (current.getItem().equals(item)) {
                prev.setNext(current.getNext()); // ���� ����� �ǳʶٰ� ����
                current.setNext(null); // ���� ����� ���� ����
                size--; // �׸� �� ����
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }
    public void print() {
        Node<E> current = head;
        System.out.print("�׸��(" + size + ") : ");
        while (current != null) {
            System.out.print(current.getItem() + " "); // ���� ����� ��� ���
            current = current.getNext(); // ���� ���� �̵�
        }
        System.out.println(); // ��� ���� �� �� �ٲ�
    }
}
