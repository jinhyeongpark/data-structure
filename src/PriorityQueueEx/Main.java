//자료구조(6007) 과제 #9 (60211665 박진형)
package PriorityQueueEx;

public class Main {

    public static void main(String[] args) {
        //1. 최초의 Bheap 객체 생성 후 출력
        Entry[] a = new Entry[16]; //a[0]은 사용 X
        a[1] = new Entry(80, "Pear");
        a[2] = new Entry(40, "Kiwi");
        a[3] = new Entry(70, "Melon");
        a[4] = new Entry(30, "Grape");
        a[5] = new Entry(60, "Mango");
        a[6] = new Entry(20, "Cherry");
        a[7] = new Entry(50, "Apple");
        a[8] = new Entry(10, "Banana");
        //h2를 위한 배열 생성
        int keys[] = new int[8];
        String values[] = new String[8];
        for (int i = 0; i < 8; i++) {
            keys[i] = (int) a[i+1].getKey();
            values[i] = (String)a[i+1].getValue();
        }

        BHeap h = new BHeap(a, 8);
        System.out.println("1. 최초의 Bheap 객체 생성 후 출력: ");
        h.print();

        //2. createHeap()으로 힙 속성에 맞는 최소힙 h를 만든 후 출력
        h.createHeap();
        System.out.println("2. 최소힙 h를 만든 후 출력: ");
        h.print();
        //3. 45, 15를 순서대로 삽입한 후 최소힙 h출력
        h.insert(45, "Peach");
        h.insert(15, "Watermelon");
        System.out.println("3. 45, 15를 순서대로 삽입 후 h 출력: ");
        h.print();
        //4. 최소키를 삭제 후 최소힙 h 출력
        h.deleteMin();
        System.out.println("4. 최소키 삭제 후 출력: ");
        h.print();
        System.out.println();
        //5. empty인 최소힙 h2 생성 후 각 최소힙 h2을 출력
        System.out.println("5. empty인 최소힙 h2 생성 후 각 최소힙 h2을 출력");
        Entry[] b = new Entry[16];
        BHeap h2 = new BHeap(b, 0);
        for(int i = 0; i < 8; i++) {
            h2.insert(keys[i], values[i]);
            System.out.println("키 " + keys[i] + " 삽입 후 최소힙: ");
            h2.print();
        }
        System.out.println("6. 45, 15를 순서대로 삽입 후 h2 출력: ");
        //6. 45, 15를 순서대로 삽입한 후 최소힙 h2 출력
        h.insert(45, "Peach");
        h.insert(15, "Watermelon");
        h2.print();
        //7. 최소키를 삭제 후 최소힙 h2 출력
        System.out.println("7. 최소키를 삭제 후 h2 출력: ");
        h2.deleteMin();
        h2.print();
    }
}
