// �ڷᱸ��(6007) ���� 2 (������ 60211665)
package ds0326;

public class Main {
    public static void main(String[] args) {
        SList<String> sl = new SList<>();

        System.out.println("<< �ڷᱸ��(6007) ���� 2 (������) >>");
        System.out.println("------------------------------------\n");

        System.out.println("1> 5���� ���� ����");
        sl.insertFront("banana");
        sl.insertFront("grape");
        sl.addLast("tomato");
        sl.addLast("apple");
        sl.addLast("mango");
        sl.print();
    }
}
