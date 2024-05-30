//�ڷᱸ��(6007) ���� #9 (60211665 ������)
package PriorityQueueEx;

public class Main {

    public static void main(String[] args) {
        //1. ������ Bheap ��ü ���� �� ���
        Entry[] a = new Entry[16]; //a[0]�� ��� X
        a[1] = new Entry(80, "Pear");
        a[2] = new Entry(40, "Kiwi");
        a[3] = new Entry(70, "Melon");
        a[4] = new Entry(30, "Grape");
        a[5] = new Entry(60, "Mango");
        a[6] = new Entry(20, "Cherry");
        a[7] = new Entry(50, "Apple");
        a[8] = new Entry(10, "Banana");
        //h2�� ���� �迭 ����
        int keys[] = new int[8];
        String values[] = new String[8];
        for (int i = 0; i < 8; i++) {
            keys[i] = (int) a[i+1].getKey();
            values[i] = (String)a[i+1].getValue();
        }

        BHeap h = new BHeap(a, 8);
        System.out.println("1. ������ Bheap ��ü ���� �� ���: ");
        h.print();

        //2. createHeap()���� �� �Ӽ��� �´� �ּ��� h�� ���� �� ���
        h.createHeap();
        System.out.println("2. �ּ��� h�� ���� �� ���: ");
        h.print();
        //3. 45, 15�� ������� ������ �� �ּ��� h���
        h.insert(45, "Peach");
        h.insert(15, "Watermelon");
        System.out.println("3. 45, 15�� ������� ���� �� h ���: ");
        h.print();
        //4. �ּ�Ű�� ���� �� �ּ��� h ���
        h.deleteMin();
        System.out.println("4. �ּ�Ű ���� �� ���: ");
        h.print();
        System.out.println();
        //5. empty�� �ּ��� h2 ���� �� �� �ּ��� h2�� ���
        System.out.println("5. empty�� �ּ��� h2 ���� �� �� �ּ��� h2�� ���");
        Entry[] b = new Entry[16];
        BHeap h2 = new BHeap(b, 0);
        for(int i = 0; i < 8; i++) {
            h2.insert(keys[i], values[i]);
            System.out.println("Ű " + keys[i] + " ���� �� �ּ���: ");
            h2.print();
        }
        System.out.println("6. 45, 15�� ������� ���� �� h2 ���: ");
        //6. 45, 15�� ������� ������ �� �ּ��� h2 ���
        h.insert(45, "Peach");
        h.insert(15, "Watermelon");
        h2.print();
        //7. �ּ�Ű�� ���� �� �ּ��� h2 ���
        System.out.println("7. �ּ�Ű�� ���� �� h2 ���: ");
        h2.deleteMin();
        h2.print();
    }
}
