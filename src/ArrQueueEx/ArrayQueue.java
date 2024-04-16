package ArrQueueEx;

import java.util.NoSuchElementException;

public class ArrayQueue<E> {
    private E[] q;
    private int front, rear, size;
    public ArrayQueue() {
        q = (E[]) new Object[2];
        front = rear = size = 0;
    }
    public int size() {return size;}
    public boolean isEmpty() {return (size == 0);}
    //add(), remover(), resize();
    public void add(E newItem) {
        if((rear + 1) % q.length == front) //rear 다음의 인덱스가 front 즉 full 상태
            resize(2*q.length);
        rear = (rear + 1) % q.length; //rear 를 다음으로 옮기고
        q[rear] = newItem; //새로운 항목 추가
        size++; //항목 수 증가
    }
    public E remove() {
        if(isEmpty()) throw new NoSuchElementException();
        front = (front + 1) % q.length; //front 를 다음으로 옮기고
        E item = q[front]; //q[front]를 item 에 저장
        q[front] = null; //q[front] 삭제
        size--; //항목 수 감소
        if(size > 0 && size == q.length/4)
            resize(q.length/2);
        return item;
    }
    private void resize(int newSize) {
        Object [] t = new Object[newSize];
        //front 가 비어있으므로 q[front+1] 부터 이동하여 t[1]부터 채움
        for(int i = 1, j = front + 1; i < size + 1; i++, j++ ) {
            t[i] = q[j%q.length];
        }
        front = 0; //front 는 다시 t[0]에 위치시킴
        rear = size; //rear 는 맨 뒤에 위치
        q = (E[]) t; //그대로 q 에 붙임

    }
}
