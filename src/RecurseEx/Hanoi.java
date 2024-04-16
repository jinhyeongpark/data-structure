// �ڷᱸ��(6007) ���� 1 (60211665 ������)
package RecurseEx;

import java.util.ArrayList;
import java.util.List;

public class Hanoi {
    //3���� ���(A, B, C), ���� �ٸ� n(3, 4)���� ����
    //��� A�� ���ݵ��� ���� ��� B�� �̿��� ��� C�� �ű��
    //ū ������ ���� ���� ���� ����X
    //�� ���� 1���� ���ݸ� �̵� ����

    //����, ��� ���, ���� ���, ������ ���
    public static void print(int num) {
        System.out.println("������ " + num + "���� ���");
        System.out.print("(���� �̸� ũ�Ⱑ ���� -> ū ����: ");
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