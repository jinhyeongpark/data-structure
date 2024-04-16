// 자료구조(6007) 과제 1 (60211665 박진형)
package RecurseEx;

import java.util.ArrayList;
import java.util.List;

public class Hanoi {
    //3개의 기둥(A, B, C), 서로 다른 n(3, 4)개의 원반
    //기둥 A의 원반들을 보조 기둥 B를 이용해 기둥 C로 옮기기
    //큰 원반이 작은 원반 위에 존재X
    //한 번에 1개의 원반만 이동 가능

    //원반, 출발 기둥, 도착 기둥, 나머지 기둥
    public static void print(int num) {
        System.out.println("원반이 " + num + "개인 경우");
        System.out.print("(원반 이름 크기가 작은 -> 큰 순서: ");
        for(int i = 1; i <= num; i++) {
            System.out.print(i);
            if(i != num) System.out.print(" - ");
        }
        System.out.print(")\n");
    }
    public static void move(int num, String from, String to, String other) {
        if (num == 1) {
            System.out.println("Move Disk 1 " + from +" to " + to);
            return;
        }
        move(num-1, from, other, to);
        System.out.println("Move Disk " + num + " " + from +" to " + to);
        move(num-1, other, to, from);
    }
    public static void main (String[]args){
        print(3);
        move(3, "A", "C", "B");
        print(4);
        move(4, "A", "C", "B");
    }
 }