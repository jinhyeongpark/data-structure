// �ڷᱸ��(6007) ���� #3 (60211665 ������)
package DListEx;

public class Main {
    public static void main(String[] args) {
        DList<String> s1 = new DList<>();
        DList<String> s2 = new DList<>();

        System.out.println("<< �ڷᱸ��(6007) ���� 3 (������ 60211665) >>");
        System.out.println("------------------------------------\n");

        System.out.println("1> s1: 4�� ���� ����");
        s1.addFirst("apple");
        s1.addFirst("mango");
        s1.addLast("peach");
        s1.addLast("melon"); s1.print();

        System.out.println("\n2> s1: apple �ڿ� cherry ����");
        s1.insertAfter(s1.getNode(s1.search("apple")), "cherry"); s1.print();

        System.out.println("\n3> s1: peach �տ� banana ����");
        s1.insertBefore(s1.getNode(s1.search("peach")), "banana"); s1.print();

        System.out.println("\n4> s1: apple, banana ����");
        s1.delete(s1.getNode(s1.search("apple"))); s1.print();
        s1.delete(s1.getNode(s1.search("banana"))); s1.print();

        System.out.println("\n5> s1: peach, melon ����");
        s1.deleteItem("peach"); s1.print();
        s1.deleteItem("melon"); s1.print();

        System.out.println("\n6> s2: 3�� ���� ����");
        s2.addFirst("pear");
        s2.addLast("kiwi");
        s2.addLast("blueberry"); s2.print();

        System.out.println("\n7> s1 �ڿ� s2 ����");
        s1.concat(s2); s1.print();
    }
}
