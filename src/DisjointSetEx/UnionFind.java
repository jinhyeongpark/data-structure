package DisjointSetEx;

public class UnionFind {
    protected Node a[];
    public UnionFind(Node[] iarray) {
        a = iarray; //Node 객체를 원소로 하는 1차원 배열
    }
    protected int find(int i) { //경로 압축
        if(i != a[i].getParent()) //자신이 루트가 아닌 경우
            a[i].setParent(find(a[i].getParent())); //루트를 찾아 올라감
        return a[i].getParent();
    }
    public void union(int i, int j) { //union 연산
        int iroot = find(i);
        int jroot = find(j);
        if (iroot == jroot) return; //두 루트가 같으면 종료
        //rank가 높은 루트가 승자가 된다
        if (a[iroot].getRank() > a[jroot].getRank()) //각 랭크를 비교
            a[jroot].setParent(iroot); //더 큰 랭크를 가진 루트가 부모가 됨
        else if (a[iroot].getRank() < a[jroot].getRank())
            a[iroot].setParent(jroot);
        else { //둘의 랭크가 같을 경우
            a[jroot].setParent(iroot); //둘 중 하나가 임의의 승자
            int t = a[iroot].getRank() + 1; //승리한 루트의 랭크를 하나 올림
            a[iroot].setRank(t);
        }
    }
}
