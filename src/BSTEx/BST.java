// 자료구조(6007) 과제 #7 (60211665 박진형)
package BSTEx;

public class BST<Key extends Comparable<Key>, Value> {
    public Node root;
    public Node getRoot() {return root;}
    public BST(Key newId, Value newName) {
        root = new Node(newId, newName);
    }
    //get, put, min, deleteMin, delete 메소드 선언

    //키값만 넣으면 루트와 키틑 비교하는 메서드로 연결
    public Value get(Key k) {return get(root, k);}
    public Value get(Node n, Key k) {
        if (n == null) return null; //n이 null이면 null 리턴
        int compareResult = n.getKey().compareTo(k); //t에 n과 k 비교 결과인 정수를 대입
        if(compareResult > 0) return get(n.getLeft(), k); //t가 양수면 왼쪽에서 탐색
        else if (compareResult < 0) return get(n.getRight(), k); //t가 음수면 오른쪽에서 탐색
        else return (Value) n.getValue(); //k를 가진 노드 발견,Value 타입 반환을 위한 캐스팅
    }

    public void put(Key k ,Value v) {root = put(root, k ,v);}
    public Node put(Node n, Key k, Value v) {
        if (n == null)
            return new Node(k, v); //n이 null이면 해당 위치에서 새 노드 생성 및 반환
        int t = n.getKey().compareTo(k); //n과 k 비교 결과
        //재귀를 통해 루트의 자식으로
        if(t > 0)
            n.setLeft(put(n.getLeft(), k, v));
        else if(t < 0)
            n.setRight(put(n.getRight(), k, v));
        else
            n.setValue(v);
        return n;
    }

    public Key min() { //최소 키 반환
        if (root == null) return null; //root가 null이면 null 반환
        return (Key) min(root).getKey();} //Key타입으로 캐스팅 된 min(root)의 키 값 반환
    private Node min(Node n) { //최소 노드 반환
        if(n.getLeft() == null) return n; //n의 왼쪽 자식이 null인 경우 n이 최솟값
        return min(n.getLeft()); //그렇지 않으면 재귀를 통해 다시 왼쪽을 탐색
    }

    public void deleteMin() {
        if(root == null) System.out.println("empty tree");
        root = deleteMin(root);}
    public Node deleteMin(Node n) {
        //n의 왼쪽이 null인 경우 n의 오른쪽을 반환
        if(n.getLeft() == null) return n.getRight();
        n.setLeft(deleteMin(n.getLeft()));
        return n;
    }
    //max, deleteMax 구현
    public Key max() { //최소 키 반환
        if (root == null) return null; //root가 null이면 null 반환
        return (Key) max(root).getKey();} //Key타입으로 캐스팅 된 min(root)의 키 값 반환
    private Node max(Node n) { //최소 노드 반환
        if(n.getRight() == null) return n; //n의 왼쪽 자식이 null인 경우 n이 최솟값
        return max(n.getRight()); //그렇지 않으면 재귀를 통해 다시 왼쪽을 탐색
    }

    public void deleteMax() {
        if(root == null) System.out.println("empty tree");
        root = deleteMax(root);}
    public Node deleteMax(Node n) {
        //n의 왼쪽이 null인 경우 n의 오른쪽을 반환
        if(n.getRight() == null) return n.getLeft();
        n.setRight(deleteMax(n.getRight()));
        return n;
    }

    public void delete(Key k) {root = delete(root, k);}
    public Node delete(Node n, Key k) {
        if(n == null) return null;

        int t = n.getKey().compareTo(k);
        if (t > 0)
            n.setLeft(delete(n.getLeft(), k));
        else if (t < 0)
            n.setRight(delete(n.getRight(), k));
        else {
            //아래 두 과정을 통해 case 0과 1을 해결
            if(n.getRight() == null) return n.getLeft();
            if(n.getLeft() == null) return n.getRight();
            //아래의 과정을 통해 case 2 해결
            Node target = n; //삭제할 노드 n을  target에 대입
            n = min(target.getRight()); //n에 그 자리를 대체할 중위 후속자로 변경
            n.setRight(deleteMin(target.getRight())); //n의 오른쪽에는 중위 후속자를 삭제한 상태의 target 오른쪽 트리를 붙임
            n.setLeft(target.getLeft()); //n의 왼쪽에는 target의 왼쪽 트리를 붙임
        }
        return n;
    }
    //이진트리 메서드
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
    public int height(Node n) {
        if(n == null)
            return 0;
        else
            //Math.max() 사용하여 대소 비교
            return (1 + Math.max(height(n.getLeft()),height(n.getRight())));
    }
}
