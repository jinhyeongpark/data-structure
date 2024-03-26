// 자료구조(6007) 과제 2 (박진형 60211665)
package ds0326;

public class Main {
    public static void main(String[] args) {
        SList<String> sl = new SList<>();

        System.out.println("<< 자료구조(6007) 과제 2 (박진형) >>");
        System.out.println("------------------------------------\n");

        System.out.println("1> 5개의 원소 삽입");
        sl.insertFront("banana");
        sl.insertFront("grape");
        sl.addLast("tomato");
        sl.addLast("apple");
        sl.addLast("mango");
        sl.print();
    }
}
