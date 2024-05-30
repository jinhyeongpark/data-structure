//�ڷᱸ��(6007) ���� #9 (60211665 ������)
package PriorityQueueEx;

public class BHeap<Key extends Comparable<Key>, Value> {
    private Entry[] a; //a[0]�� ��� ����
    private int N; //���� ũ��
    public BHeap(Entry[] harray, int initialSize) {
        a = harray;
        N = initialSize;
    }
    public int size() {return N;} //�� ũ�� ����
    private boolean greater(int i, int j) { //i�� �� ũ�� true
        return a[j].getKey().compareTo(a[i].getKey()) < 0;
    }
    private void swap(int i, int j) { //��ȯ
        Entry temp = a[i]; a[i] = a[j]; a[j] = temp;
        //createHeap, insert, deleteMin, downheap, upheap
    }
    public void createHeap() { //�ʱ� �� ����
        for(int i = N/2; i > 0; i--) { //a[N/2]~a[1]
            downheap(i);
        }
    }
    private void downheap(int i) { //i�� ���� ��� �ε���
        while (2*i <= N) { //i�� ���� �ڽ��� ���� ������
            int k = 2*i; //k�� ���� �ڽ� �ε���
            //�¿� �ڽ� ���Ͽ� ���� ���� �� Ŭ ��� ++�� k�� ����
            // �ڽ� ������ �ٲ�
            if(k < N && greater(k,k+1)) {
                k++;
            }
            if(!greater(i, k)) break; //i�� k���� �۰ų� ������ ����
            swap(i,k); //�׷��� ������ i�� k�� ��ȯ
            i = k; //���� ����Ű�� �ִ� ��� ��ġ�� k�� �����Ͽ� �� �Ӽ� ����
        }
    }
    public void insert(Key newKey, Value newValue) {
        Entry temp = new Entry(newKey,newValue); //Entry ����
        a[++N] = temp; //�迭 ������ �׸� ���� ��ġ�� ����
        upheap(N); //�ö󰡸� �� �Ӽ� ����
    }
    private void upheap(int j) { //j�� ���� ��� �ε���
        while (j > 1 && greater(j/2, j)) { //j�� ��Ʈ�� �ƴϸ鼭 j���� j �θ� ũ��
            swap(j/2, j); //j�� j �θ� ��ȯ
            j = j/2; //���� ����Ű�� �ִ� ��� ��ġ�� j/2�� �����Ͽ� �� �Ӽ� ����
        }
    }
    public Entry deleteMin() { //�ּڰ� ����
        Entry min = a[1]; //a[1]�� min�� ����
        swap(1, N--); //���� ������ �׸�� ��ȯ�ϰ� �� ũ�� 1 ����
        a[N+1] = null; //������ �׸� null�� ó��
        downheap(1); //�� �Ӽ� ȸ��
        return min; //������ ��Ʈ ��ȯ
    }
    public void print() {
        for(int i = 1; i < size() + 1; i++) {
            Entry e = a[i];
            if (e != null) {
                System.out.print("("+ e.getKey() + ", " + "\""+ e.getValue()+ "\")");
                if (i != size()) System.out.print(", ");
            }
        }System.out.println();
    }
}
