// 수업참여0321-박진형60211665
package ArrListEx;

import java.util.NoSuchElementException;

public class ArrList<E> {
    private E a[]; //저장할 배열
    private int size; //리스트 항목 수

    public ArrList() {
        a = (E[])new Object[1]; //리스트 초기 용량 1, 제네릭 객체 생성X
        size = 0; //초기 리스트 항목 수 0
    }
    public E peek(int k) {
        if (isEmpty()) //리스트 항목 수가 0일 때
            throw new NoSuchElementException();
        return a[k]; //k 인덱스의 위치의 항목 반환
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void insertLast(E newItem) {
        if(size == a.length) //용량와 항목 수가 같음 즉, 꽉 찬 상태
            resize(2*a.length); //리스트 용량을 두 배로 늘림
        a[size++] = newItem; //a[항목 수 +1]에 새로운 항목 추가
    }
    public void insert(E newItem, int k) {
        if(k > size) throw new NoSuchElementException(); //건너뜀 방지
        if(size == a.length)
            resize(2*a.length); //리스트 용량을 두 배로 늘림
        //a[size-1](마지막 인덱스)부터 a[k](삽입할 인덱스)까지 우로 1 칸씩 이동
        for(int i = size-1; i >= k; i--) a[i+1] = a[i];
        a[k] = newItem; //a[k]에 새로운 항목 추가
        size++; //항목 수 1 증가

    }
    public void resize(int newSize) {
        Object[] t = new Object[newSize]; //newSize 크기의 배열 t 생성
        for(int i = 0; i < size; i++) t[i]= a[i]; //a 를 t 에 옮김
        a = (E[]) t; //E타입으로 캐스팅한 t 를 a 에 대입
    }
    public E delete(int k) {
        if(k >= size) throw new NoSuchElementException();
        E item = a[k];
        //a[k+1]부터 a[size-1]까지 좌로 1칸씩 이동
        for (int i = k; i < size-1; i++) a[i] = a[i+1];
        size--; //항목 수 1 감소

        if (size > 0 && size == a.length/4) //0 < 항목 수 = a/4
            resize(a.length/2); //리스트 용량을 반으로 줄임
        return item;
    }
    public void print() {
        for (int i = 0; i < a.length; i++) {
            if (i < size) {
                System.out.print(a[i] + " ");
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();
    }
}
