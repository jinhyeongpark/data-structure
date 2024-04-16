// �ڷᱸ��(6007) ���� 2 (������ 60211665)
package SListEx;

import SListEx.SList;

public class Main {
    public static void main(String[] args) {
        SList<String> sl = new SList<>();

        System.out.println("<< �ڷᱸ��(6007) ���� 2 (������ 60211665) >>");
        System.out.println("------------------------------------\n");
        
        System.out.println("1> 5���� ���� ����");
        sl.insertFront("banana");
        sl.insertFront("grape");
        sl.addLast("tomato");
        sl.addLast("apple");
        sl.addLast("mango");
        sl.print();
        
        int index = sl.search("banana");
        System.out.printf("2> banana(index %d) �ڿ� cherry ����\n", index);
        sl.insertAfter("cherry", sl.getNode(index));
        sl.print();
        
        index = sl.search("apple");
        System.out.printf("3> apple(index %d) �տ� melon ����\n", index);
        sl.add("melon",index);
        sl.print();
        
        System.out.printf("4> index 3���� peach ����\n");
        sl.add("peach", 3);
        sl.print();
        
        index = sl.search("tomato");
        System.out.printf("5> tomato(index %d) ���� �׸� ����\n", index);
        sl.deleteAfter(sl.getNode(index));
        sl.print();
        
        System.out.printf("6> banana �׸� ����\n");
        sl.deleteItem("banana");
        sl.print();
        
        System.out.printf("7> index 3 �׸� ����\n");
        sl.delete(3);
        sl.print();
        
        System.out.println("8> �� ���� ���� 3�� ����");
        sl.deleteFront();
        sl.deleteFront();
        sl.deleteFront();
        sl.print();
    }
}