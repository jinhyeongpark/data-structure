// 자료구조(6007) 과제 #6 (60211665 박진형)
package TreeEx;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>> {
    private Node root;

    public BinaryTree() {
        root = null;
    }
    public Node getRoot() {return root;}
    public void setRoot(Node newRoot) {root = newRoot;}
    public boolean isEmpty() {return (root == null);}
    //preorder(), inorder(), postorder(), levelorder(),
    //size(), height(), isEqual() 메소드 선언

    public void preorder(Node n) {
        if(n != null) {
            System.out.print(n.getKey() + " "); //자기 자신
            preorder(n.getLeft()); //왼쪽
            preorder(n.getRight()); //오른
        }
    }
    public void inorder(Node n) {
        if(n != null) {
            inorder(n.getLeft()); //왼쪽
            System.out.print(n.getKey() + " "); //자기 자신
            inorder(n.getRight()); //오른
        }
    }
    public void postorder(Node n) {
        if(n != null) {
            postorder(n.getLeft());
            postorder(n.getRight());
            System.out.print(n.getKey() + " ");
        }
    }
    public void levelorder(Node root) {
        Queue<Node> q = new LinkedList();
        Node t;
        q.add(root);
        while(!q.isEmpty()) {
            t = q.remove();
            System.out.print(t.getKey() + " ");
            if(t.getLeft() != null)
                q.add(t.getLeft());
            if(t.getRight() != null)
                q.add(t.getRight());
        }
    }
    public int size(Node n) {
        if(n == null)
            return 0;
        else
            return (1 + size(n.getLeft()) + size(n.getRight()));
    }
    public int height(Node n) {
        if(n == null)
            return 0;
        else
            //Math.max() 사용하여 대소 비교
            return (1 + Math.max(height(n.getLeft()),height(n.getRight())));
    }
    public static boolean isEqual(Node n , Node m) {
        if(n == null || m == null) //둘 다 null이거나 하나만 null
            return n == m; //true or false

        if(n.getKey().compareTo(m.getKey()) != 0) //n과 m을 비교해 0이 아닐 시
            return false; //false

        return(isEqual(n.getLeft(), m.getLeft())) && //n과 m의 각 왼쪽을 비교
            (isEqual(n.getRight(), m.getRight())); //n과 m의 각 오른쪽을 비교
    }
    public Node copy(Node n) {
        if(n == null) return null;
        else {
            Node newNode = new Node(n.getKey(), null, null);
            newNode.setLeft(copy(n.getLeft()));
            newNode.setRight(copy(n.getRight()));
            return newNode;
        }
    }
}
