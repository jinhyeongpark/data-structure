package DisjointSetEx;

public class Main {

    public static void main(String[] args) {
        int N = 10;
        Node[] a = new Node[N];

        for(int i = 0; i < N; i++)
            a[i] = new Node(i, 0); //부모와 랭크로 이뤄진 노드들 삽입

        UnionFind unionFind = new UnionFind(a);

        unionFind.union(2, 1); unionFind.union(2, 6);
        unionFind.union(7, 3); unionFind.union(4, 5);
        unionFind.union(9, 5); unionFind.union(7, 2);
        unionFind.union(7, 8); unionFind.union(0, 4);

        System.out.print("8회의 union 연산 수행 후\n(i:parent, rank):");
        for (int i = 0; i < N; i++)
            System.out.print("("+i+":"+unionFind.a[i].getParent()+","+unionFind.a[i].getRank()+") ");
        unionFind.union(9, 1);
        System.out.print("\n\nunion(9, 1) 수행 수\n(i: parent, rank):");
        for (int i = 0; i < N; i++)
            System.out.print("("+i+":"+unionFind.a[i].getParent()+","+unionFind.a[i].getRank()+") ");
        System.out.println();


    }
}
