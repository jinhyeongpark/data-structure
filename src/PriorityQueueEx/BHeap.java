//자료구조(6007) 과제 #9 (60211665 박진형)
package PriorityQueueEx;

public class BHeap<Key extends Comparable<Key>, Value> {
    private Entry[] a; //a[0]은 사용 안함
    private int N; //힙의 크기
    public BHeap(Entry[] harray, int initialSize) {
        a = harray;
        N = initialSize;
    }
    public int size() {return N;} //힙 크기 리턴
    private boolean greater(int i, int j) { //i가 더 크면 true
        return a[j].getKey().compareTo(a[i].getKey()) < 0;
    }
    private void swap(int i, int j) { //교환
        Entry temp = a[i]; a[i] = a[j]; a[j] = temp;
        //createHeap, insert, deleteMin, downheap, upheap
    }
    public void createHeap() { //초기 힙 생성
        for(int i = N/2; i > 0; i--) { //a[N/2]~a[1]
            downheap(i);
        }
    }
    private void downheap(int i) { //i는 현재 노드 인덱스
        while (2*i <= N) { //i의 왼쪽 자식이 힙에 있으면
            int k = 2*i; //k는 왼쪽 자식 인덱스
            //좌우 자식 비교하여 좌측 값이 더 클 경우 ++로 k를 우측
            // 자식 값으로 바꿈
            if(k < N && greater(k,k+1)) {
                k++;
            }
            if(!greater(i, k)) break; //i가 k보다 작거나 같으면 종료
            swap(i,k); //그렇지 않으면 i와 k를 교환
            i = k; //현재 가리키고 있느 노드 위치를 k로 변경하여 힙 속성 유지
        }
    }
    public void insert(Key newKey, Value newValue) {
        Entry temp = new Entry(newKey,newValue); //Entry 생성
        a[++N] = temp; //배열 마지막 항목 다음 위치에 저장
        upheap(N); //올라가며 힙 속성 유지
    }
    private void upheap(int j) { //j는 현재 노드 인덱스
        while (j > 1 && greater(j/2, j)) { //j가 루트가 아니면서 j보다 j 부모가 크면
            swap(j/2, j); //j와 j 부모 교환
            j = j/2; //현재 가리키고 있느 노드 위치를 j/2로 변경하여 힙 속성 유지
        }
    }
    public Entry deleteMin() { //최솟값 삭제
        Entry min = a[1]; //a[1]을 min에 저장
        swap(1, N--); //힙의 마지막 항목과 교환하고 힙 크기 1 감소
        a[N+1] = null; //마지막 항목 null로 처리
        downheap(1); //힙 속성 회복
        return min; //삭제된 노트 반환
    }
    public void print() {
        for(int i = 1; i < size() + 1; i++) {
            Entry e = a[i];
            if (e != null) {
                System.out.print("("+ e.getKey() + ", " + "\""+ e.getValue()+ "\")");
                if (i != size()) System.out.print(", ");
            }
        }System.out.println();
    }
}
