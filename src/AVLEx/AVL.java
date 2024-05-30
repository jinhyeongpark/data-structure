package AVLEx;

import java.util.LinkedList;
import java.util.Queue;

public class AVL<Key extends Comparable<Key>, Value, Integer> {

    public Node root;

    public Node getRoot() {
        return root;
    }
    public AVL(Key newId, Value newName, int height) {
        root = new Node(newId, newName, height);
    }
    public AVL() {root = null;}

    private Node rotationRight(Node n) {
        Node x = n.left; //���� Ʈ���� x�� ����
        n.left = x.right; //x�� ������ Ʈ���� n�� ���ʿ� ����
        x.right = n; //n�� x�� ������ Ʈ���� ����
        n.height = tallerHeight(height(n.left), height(n.right)) + 1; //���� ����
        x.height = tallerHeight(height(x.left), height(x.right)) + 1; //���� ����
        return x;
    }

    private Node rotationLeft(Node n) {
        Node x = n.right; //������ Ʈ���� x�� ����
        n.right = x.left; //x�� ���� Ʈ���� n�� �����ʿ� ����
        x.left = n; //n�� x�� �� Ʈ���� ����
        n.height = tallerHeight(height(n.left), height(n.right)) + 1; //���� ����
        x.height = tallerHeight(height(x.left), height(x.right)) + 1; //���� ����
        return x;
    }

    public void put(Key k, Value v) {
        root = put(root, k, v);
    }
    private Node put(Node n, Key k, Value v) {
        if (n == null){
            System.out.println();
            System.out.print("(" + k + ", " + v + ") ����");
            return new Node(k, v, 1); //��Ʈ�� ������� ��� ����
        }

        int t = k.compareTo((Key) n.id); //��Ʈ�� �ش� k�� Ű�� ��

        if (t < 0)
            n.left = put(n.left, k, v);
        else if (t > 0)
            n.right = put(n.right, k, v);
        else { //������
            n.name = v; //��Ʈ�� �̸� �缳��
            return n; //��ȯ
        }
        n.height = tallerHeight(height(n.left), height(n.right)) + 1; //���� �缳��
        return balance(n); //�ұ��� �ؼ�
    }

    private Node balance(Node n) {
        if (bf(n) > 1) { //���� ����Ʈ���� �� ���� ���
            if (bf(n.left) < 0) { //n.left�� ������ ����Ʈ���� �� ���� ���
                n.left = rotationLeft(n.left); //�켱 LR�� ���� rotationLeft
                System.out.print(": " + n.left + "(LRȸ��)");
            } else System.out.print(": " + n.left + "(LLȸ��)");

            n = rotationRight(n);
        } else if (bf(n) < -1) { //������ ����Ʈ���� �� ���� ���
            if (bf(n.right) > 0) { // n.right�� ���� ����Ʈ���� �� ���� ���
                n.right = rotationRight(n.right); //�켱 RL�� ���� rotationRight
                System.out.print(": " + n.right + "(RLȸ��)");
            } else System.out.print(": " + n.right + "(RRȸ��)");

            n = rotationLeft(n);
        }
        return n;
    }

    private int bf(Node n) {
        return height(n.left) - height(n.right);
    }

    public int height(Node n) {
        if (n == null)
            return 0;
        return n.height;
    }

    public int tallerHeight(int x, int y) {
        if (x > y)
            return x;
        else
            return y;
    }

    public void delete(Key k) {
        root = delete(root, k);
    }

    private Node delete(Node n, Key k) {
        if (n == null) {
            return null;
        }

        int t = k.compareTo((Key) n.id);

        if (t < 0)
            n.left = delete(n.left, k);
        else if (t > 0)
            n.right = delete(n.right, k);
        else {
            System.out.println();
            System.out.print("(" + k + ") ���� ");
            if (n.left == null)
                return n.right;
            else if (n.right == null)
                return n.left;
            else {
                Node target = n;
                n = min(target.right);
                n.right = deleteMin(target.right);
                n.left = target.left;
            }
        }
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        return balance(n);
    }

    public void deleteMin() {
        if (root == null)
            System.out.println("empty Ʈ��");

        root = deleteMin(root);
    }

    private Node deleteMin(Node n) {
        if (n.left == null)
            return n.right;

        n.left = deleteMin(n.left);
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;

        return balance(n);
    }
    public Key min() {
        if (root == null) return null;
        return (Key) min(root).id;
    }
    private Node min(Node n) {
        if (n.left == null) return n;
        return min(n.left);
    }
    public void inorder(Node n) {
        if(n != null) {
            inorder(n.getLeft()); //����
            System.out.print(n.getKey() + " "); //�ڱ� �ڽ�
            inorder(n.getRight()); //����
        }
    }
    public void preorder(Node n) {
        if(n != null) {
            System.out.print(n.getKey() + " "); //�ڱ� �ڽ�
            preorder(n.getLeft()); //����
            preorder(n.getRight()); //����
        }
    }
    public void levelorder(Node root) {
        Queue<Node> q = new LinkedList();
        Node t; //������ ��带 ����ϱ� ���� �ӽ� ���
        q.add(root); //��Ʈ ��带 ť�� ����
        while(!q.isEmpty()) { //ť�� ���Ұ� �ִ� ����
            //ť�� �Ǿ� ��带 ���� �� ���
            t = q.remove();
            System.out.print(t.getKey() + " ");
            //������ ����� �� �� ��带 ť�� ����
            if(t.getLeft() != null)
                q.add(t.getLeft());
            if(t.getRight() != null)
                q.add(t.getRight());
        }
    }
    public Value get(Key k) {return get(root, k);}
    public Value get(Node n, Key k) {
        if (n == null) return null; //n�� null�̸� null ����
        int compareResult = n.getKey().compareTo(k); //t�� n�� k �� ����� ������ ����
        if(compareResult > 0) return get(n.getLeft(), k); //t�� ����� ���ʿ��� Ž��
        else if (compareResult < 0) return get(n.getRight(), k); //t�� ������ �����ʿ��� Ž��
        else return (Value) n.getValue(); //k�� ���� ��� �߰�,Value Ÿ�� ��ȯ�� ���� ĳ����
    }
}
