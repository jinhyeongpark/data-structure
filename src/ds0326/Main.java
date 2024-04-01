// 자료구조(6007) 과제 2 (박진형 60211665)
package ds0326;

public class Main {
    public static void main(String[] args) {
        SList<String> sl = new SList<>();

        System.out.println("<< 자료구조(6007) 과제 2 (박진형 60211665) >>");
        System.out.println("------------------------------------\n");
        
        System.out.println("1> 5개의 원소 삽입");
        sl.insertFront("banana");
        sl.insertFront("grape");
        sl.addLast("tomato");
        sl.addLast("apple");
        sl.addLast("mango");
        sl.print();
        
        int index = sl.search("banana");
        System.out.printf("2> banana(index %d) 뒤에 cherry 삽입\n", index);
        sl.insertAfter("cherry", sl.getNode(index));
        sl.print();
        
        index = sl.search("apple");
        System.out.printf("3> apple(index %d) 앞에 melon 삽입\n", index);
        sl.add("melon",index);
        sl.print();
        
        System.out.printf("4> index 3으로 peach 삽입\n");
        sl.add("peach", 3);
        sl.print();
        
        index = sl.search("tomato");
        System.out.printf("5> tomato(index %d) 뒤의 항목 삭제\n", index);
        sl.deleteAfter(sl.getNode(index));
        sl.print();
        
        System.out.printf("6> banana 항목 삭제\n");
        sl.deleteItem("banana");
        sl.print();
        
        System.out.printf("7> index 3 항목 삭제\n");
        sl.delete(3);
        sl.print();
        
        System.out.println("8> 맨 앞의 원소 3개 제거");
        sl.deleteFront();
        sl.deleteFront();
        sl.deleteFront();
        sl.print();
    }
}