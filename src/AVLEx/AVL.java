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
        Node x = n.left; //왼쪽 트리를 x에 지정
        n.left = x.right; //x의 오른쪽 트리를 n의 왼쪽에 붙임
        x.right = n; //n을 x의 오른쪽 트리로 지정
        n.height = tallerHeight(height(n.left), height(n.right)) + 1; //높이 갱신
        x.height = tallerHeight(height(x.left), height(x.right)) + 1; //높이 갱신
        return x;
    }

    private Node rotationLeft(Node n) {
        Node x = n.right; //오른쪽 트리를 x에 지정
        n.right = x.left; //x의 왼쪽 트리를 n의 오른쪽에 붙임
        x.left = n; //n을 x의 쪽 트리로 지정
        n.height = tallerHeight(height(n.left), height(n.right)) + 1; //높이 갱신
        x.height = tallerHeight(height(x.left), height(x.right)) + 1; //높이 갱신
        return x;
    }

    public void put(Key k, Value v) {
        root = put(root, k, v);
    }
    private Node put(Node n, Key k, Value v) {
        if (n == null){
            System.out.println();
            System.out.print("(" + k + ", " + v + ") 삽입");
            return new Node(k, v, 1); //루트가 비었으면 노드 생성
        }

        int t = k.compareTo((Key) n.id); //루트와 해당 k의 키값 비교

        if (t < 0)
            n.left = put(n.left, k, v);
        else if (t > 0)
            n.right = put(n.right, k, v);
        else { //같으면
            n.name = v; //루트의 이름 재설정
            return n; //반환
        }
        n.height = tallerHeight(height(n.left), height(n.right)) + 1; //높이 재설정
        return balance(n); //불균형 해소
    }

    private Node balance(Node n) {
        if (bf(n) > 1) { //왼쪽 서브트리가 더 높은 경우
            if (bf(n.left) < 0) { //n.left의 오른쪽 서브트리가 더 높은 경우
                n.left = rotationLeft(n.left); //우선 LR을 위한 rotationLeft
                System.out.print(": " + n.left + "(LR회전)");
            } else System.out.print(": " + n.left + "(LL회전)");

            n = rotationRight(n);
        } else if (bf(n) < -1) { //오른쪽 서브트리가 더 높은 경우
            if (bf(n.right) > 0) { // n.right의 왼쪽 서브트리가 더 높은 경우
                n.right = rotationRight(n.right); //우선 RL을 위한 rotationRight
                System.out.print(": " + n.right + "(RL회전)");
            } else System.out.print(": " + n.right + "(RR회전)");

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
            System.out.print("(" + k + ") 삭제 ");
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
            System.out.println("empty 트리");

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
            inorder(n.getLeft()); //왼쪽
            System.out.print(n.getKey() + " "); //자기 자신
            inorder(n.getRight()); //오른
        }
    }
    public void preorder(Node n) {
        if(n != null) {
            System.out.print(n.getKey() + " "); //자기 자신
            preorder(n.getLeft()); //왼쪽
            preorder(n.getRight()); //오른
        }
    }
    public void levelorder(Node root) {
        Queue<Node> q = new LinkedList();
        Node t; //삭제된 노드를 출력하기 위한 임시 노드
        q.add(root); //루트 노드를 큐에 삽입
        while(!q.isEmpty()) { //큐에 원소가 있는 동안
            //큐의 맨앞 노드를 삭제 및 출력
            t = q.remove();
            System.out.print(t.getKey() + " ");
            //삭제된 노드의 좌 우 노드를 큐에 삽입
            if(t.getLeft() != null)
                q.add(t.getLeft());
            if(t.getRight() != null)
                q.add(t.getRight());
        }
    }
    public Value get(Key k) {return get(root, k);}
    public Value get(Node n, Key k) {
        if (n == null) return null; //n이 null이면 null 리턴
        int compareResult = n.getKey().compareTo(k); //t에 n과 k 비교 결과인 정수를 대입
        if(compareResult > 0) return get(n.getLeft(), k); //t가 양수면 왼쪽에서 탐색
        else if (compareResult < 0) return get(n.getRight(), k); //t가 음수면 오른쪽에서 탐색
        else return (Value) n.getValue(); //k를 가진 노드 발견,Value 타입 반환을 위한 캐스팅
    }
}
