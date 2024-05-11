// 자료구조(6007) 과제 #7 (60211665 박진형)
package BSTEx;

public class Main {

    public static void res(BST bst) {
        System.out.print("inorder: ");
        bst.inorder(bst.getRoot());
        System.out.println();
        System.out.print("preorder: ");
        bst.preorder(bst.getRoot());
        System.out.println();
        System.out.println("높이 = "+ bst.height(bst.getRoot()));
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

        System.out.println("<<  자료구조(6007) 과제 #6 (60211665 박진형) >>");

        System.out.println("1. 키와 값 10개 삽입 후 >>");
        res(bst);

        System.out.println("키(40)의 값 = " + bst.get(40));
        System.out.println("키(80)의 값 = " + bst.get(80));
        System.out.println("키(77)의 값 = " + bst.get(77));
        System.out.println("최소 키값 = " + bst.min());
        System.out.println("최대 키값 = " + bst.max());
        System.out.println();

        bst.delete(15);
        bst.delete(35);
        System.out.println("2. 15, 35 삭제 후 >>");
        res(bst);

        bst.deleteMin();
        System.out.println("최소 키 삭제 후 >>");
        res(bst);

        bst.deleteMax();
        System.out.println("최대 키 삭제 후 >>");
        res(bst);

    }
}
