// �ڷᱸ��(6007) ���� #7 (60211665 ������)
package BSTEx;

public class Main {

    public static void res(BST bst) {
        System.out.print("inorder: ");
        bst.inorder(bst.getRoot());
        System.out.println();
        System.out.print("preorder: ");
        bst.preorder(bst.getRoot());
        System.out.println();
        System.out.println("���� = "+ bst.height(bst.getRoot()));
        System.out.println();
    }

    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>(50, "Apple");
        bst.put(60, "Banana");
        bst.put(20, "Melon");
        bst.put(10, "Orange");
        bst.put(40, "Tangerine");
        bst.put(25, "Kiwi");
        bst.put(15, "Grape");
        bst.put(80, "Strawberry");
        bst.put(70, "Cherry");
        bst.put(35, "Lemon");

        System.out.println("<<  �ڷᱸ��(6007) ���� #6 (60211665 ������) >>");

        System.out.println("1. Ű�� �� 10�� ���� �� >>");
        res(bst);

        System.out.println("Ű(40)�� �� = " + bst.get(40));
        System.out.println("Ű(80)�� �� = " + bst.get(80));
        System.out.println("Ű(77)�� �� = " + bst.get(77));
        System.out.println("�ּ� Ű�� = " + bst.min());
        System.out.println("�ִ� Ű�� = " + bst.max());
        System.out.println();

        bst.delete(15);
        bst.delete(35);
        System.out.println("2. 15, 35 ���� �� >>");
        res(bst);

        bst.deleteMin();
        System.out.println("�ּ� Ű ���� �� >>");
        res(bst);

        bst.deleteMax();
        System.out.println("�ִ� Ű ���� �� >>");
        res(bst);

    }
}
