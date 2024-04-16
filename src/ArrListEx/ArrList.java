// ��������0321-������60211665
package ArrListEx;

import java.util.NoSuchElementException;

public class ArrList<E> {
    private E a[]; //������ �迭
    private int size; //����Ʈ �׸� ��

    public ArrList() {
        a = (E[])new Object[1]; //����Ʈ �ʱ� �뷮 1, ���׸� ��ü ����X
        size = 0; //�ʱ� ����Ʈ �׸� �� 0
    }
    public E peek(int k) {
        if (isEmpty()) //����Ʈ �׸� ���� 0�� ��
            throw new NoSuchElementException();
        return a[k]; //k �ε����� ��ġ�� �׸� ��ȯ
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void insertLast(E newItem) {
        if(size == a.length) //�뷮�� �׸� ���� ���� ��, �� �� ����
            resize(2*a.length); //����Ʈ �뷮�� �� ��� �ø�
        a[size++] = newItem; //a[�׸� �� +1]�� ���ο� �׸� �߰�
    }
    public void insert(E newItem, int k) {
        if(k > size) throw new NoSuchElementException(); //�ǳʶ� ����
        if(size == a.length)
            resize(2*a.length); //����Ʈ �뷮�� �� ��� �ø�
        //a[size-1](������ �ε���)���� a[k](������ �ε���)���� ��� 1 ĭ�� �̵�
        for(int i = size-1; i >= k; i--) a[i+1] = a[i];
        a[k] = newItem; //a[k]�� ���ο� �׸� �߰�
        size++; //�׸� �� 1 ����

    }
    public void resize(int newSize) {
        Object[] t = new Object[newSize]; //newSize ũ���� �迭 t ����
        for(int i = 0; i < size; i++) t[i]= a[i]; //a �� t �� �ű�
        a = (E[]) t; //EŸ������ ĳ������ t �� a �� ����
    }
    public E delete(int k) {
        if(k >= size) throw new NoSuchElementException();
        E item = a[k];
        //a[k+1]���� a[size-1]���� �·� 1ĭ�� �̵�
        for (int i = k; i < size-1; i++) a[i] = a[i+1];
        size--; //�׸� �� 1 ����

        if (size > 0 && size == a.length/4) //0 < �׸� �� = a/4
            resize(a.length/2); //����Ʈ �뷮�� ������ ����
        return item;
    }
    public void print() {
        for (int i = 0; i < a.length; i++) {
            if (i < size) {
                System.out.print(a[i] + " ");
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();
    }
}
