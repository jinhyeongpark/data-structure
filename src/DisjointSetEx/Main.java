package DisjointSetEx;

public class Main {

    public static void main(String[] args) {
        int N = 10;
        Node[] a = new Node[N];

        for(int i = 0; i < N; i++)
            a[i] = new Node(i, 0); //�θ�� ��ũ�� �̷��� ���� ����

        UnionFind unionFind = new UnionFind(a);

        unionFind.union(2, 1); unionFind.union(2, 6);
        unionFind.union(7, 3); unionFind.union(4, 5);
        unionFind.union(9, 5); unionFind.union(7, 2);
        unionFind.union(7, 8); unionFind.union(0, 4);

        System.out.print("8ȸ�� union ���� ���� ��\n(i:parent, rank):");
        for (int i = 0; i < N; i++)
            System.out.print("("+i+":"+unionFind.a[i].getParent()+","+unionFind.a[i].getRank()+") ");
        unionFind.union(9, 1);
        System.out.print("\n\nunion(9, 1) ���� ��\n(i: parent, rank):");
        for (int i = 0; i < N; i++)
            System.out.print("("+i+":"+unionFind.a[i].getParent()+","+unionFind.a[i].getRank()+") ");
        System.out.println();


    }
}
