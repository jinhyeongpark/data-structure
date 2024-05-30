package AVLEx;

public class Main {

    public static void res(AVL avl) {
        System.out.println();
        System.out.print("전위 순회 결과: ");
        avl.preorder(avl.getRoot());
        System.out.println();
        System.out.print("중위 순회 결과: ");
        avl.inorder(avl.getRoot());
        System.out.println();
        System.out.print("레벨 순회 결과: ");
        avl.levelorder(avl.getRoot());
        System.out.println();
        System.out.println("트리 높이: " + avl.height(avl.getRoot()));
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

        System.out.println("키 30의 값: " + avl.get(30));
        System.out.println("키 20의 값: " + avl.get(20));
        System.out.println("키 90의 값: " + avl.get(90));

        avl.delete(75);
        avl.delete(85);
        System.out.println();

        res(avl);
    }
}
