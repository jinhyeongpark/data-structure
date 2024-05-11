// �ڷᱸ��(6007) ���� #6 (60211665 ������)
package TreeEx;

public class Main {

    public static void main(String[] args) {
        Node A = new Node("A", null, null);
        Node B = new Node("B", null, null);
        Node C = new Node("C", null, null);
        Node D = new Node("D", null, null);
        Node E = new Node("E", null, null);
        Node F = new Node("F", null, null);
        Node G = new Node("G", null, null);
        Node H = new Node("H", null, null);
        Node I = new Node("I", null, null);

        A.setLeft(B); A.setRight(C);
        B.setLeft(D); B.setRight(E);
        C.setLeft(F); C.setRight(G);
        F.setLeft(H); G.setRight(I);

        BinaryTree t1 = new BinaryTree<>();
        t1.setRoot(A);

        BinaryTree t2 = new BinaryTree<>();
        t2.setRoot(t1.copy(t1.getRoot()));

        System.out.println("<< �ڷᱸ��(���¹�ȣ) ���� #6 (60211665 ������) >>");

        System.out.println("t1�� ũ��: " + t1.size(t1.getRoot()));
        System.out.println("t1�� ����: " + t1.height(t1.getRoot()));
        System.out.println("t2�� ũ��: " + t2.size(t2.getRoot()));
        System.out.println("t2�� ����: " + t2.height(t2.getRoot()));

        System.out.println("t1�� ���� ��ȸ �� ���� ��ȸ:");
        t1.preorder(t1.getRoot()); System.out.println();
        t1.levelorder(t1.getRoot()); System.out.println();
        System.out.println("t2�� ���� ��ȸ �� ���� ��ȸ:");
        t2.preorder(t2.getRoot()); System.out.println();
        t2.levelorder(t2.getRoot()); System.out.println();

        System.out.println("t1�� t2�� ������?: " + BinaryTree.isEqual(t1.getRoot(), t2.getRoot()));

    }
}
