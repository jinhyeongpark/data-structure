package ArrStackEx;

import java.util.EmptyStackException;

public class ArrayStack<E> {
    private E s[]; //스택을 위한 배열
    private int top; //맨 위 원소 인덱스

    public ArrayStack() {
        s = (E[]) new Object[1];
        top = -1; //empty 인덱스, 인덱스가 0이면 원소가 하나 있어야 하기 때문
    }
    public int size() {return top+1;} //항목 수 반환
    public boolean isEmpty() {return (top == -1);}
    //peek, push, pop, resize 선언
    public E peek() {
        if(isEmpty()) throw new EmptyStackException();
        return s[top];
    }
    public void push(E newItem) {
        if (size() == s.length) resize(2*s.length);
        s[++top] = newItem; //인덱스를 미리 증가시키고 항목 추가
    }
    public E pop() {
        if(isEmpty()) throw new EmptyStackException();
        E item = s[top]; //s[top]을 item 으로 지정
        s[top--] = null; //s[top]을 null 로 바꾸면서 top 감소
        if (size() > 0 && size() == s.length/4) //0 < 항목 수 = s/4
            resize(s.length/2); //리스트 용량을 반으로 줄임
        return item; //item 반환
    }
    public void resize(int newSize) {
        Object[] t = new Object[newSize]; //newSize 크기의 배열 t 생성
        for(int i = 0; i < size(); i++) t[i]= s[i]; //a 를 t 에 옮김
        s = (E[]) t; //E타입으로 다캐스팅한 t 를 a 에 대입
    }
    public void print() {

    }
}
