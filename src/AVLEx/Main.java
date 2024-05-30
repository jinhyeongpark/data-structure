package AVLEx;

public class Main {

    public static void res(AVL avl) {
        System.out.println();
        System.out.print("���� ��ȸ ���: ");
        avl.preorder(avl.getRoot());
        System.out.println();
        System.out.print("���� ��ȸ ���: ");
        avl.inorder(avl.getRoot());
        System.out.println();
        System.out.print("���� ��ȸ ���: ");
        avl.levelorder(avl.getRoot());
        System.out.println();
        System.out.println("Ʈ�� ����: " + avl.height(avl.getRoot()));
        System.out.println();
    }

    public static void main(String[] args) {
        //AVL<Integer, String, Integer> avl = new AVL<>(75, "Apple", 1);
        AVL<Integer, String, Integer> avl = new AVL<>();
        avl.put(75, "Apple");
        avl.put(80, "Banana");
        avl.put(85, "Melon");
        avl.put(20, "Orange");
        avl.put(10, "Tangerine");
        avl.put(50, "Kiwi");
        avl.put(30, "Grape");
        avl.put(40, "Strawberry");
        avl.put(70, "Cherry");
        avl.put(90, "Lemon");
        System.out.println();

        res(avl);

        System.out.println("Ű 30�� ��: " + avl.get(30));
        System.out.println("Ű 20�� ��: " + avl.get(20));
        System.out.println("Ű 90�� ��: " + avl.get(90));

        avl.delete(75);
        avl.delete(85);
        System.out.println();

        res(avl);
    }
}
