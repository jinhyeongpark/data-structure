// �ڷᱸ��(6007) ���� 1 (60211665 ������)
package ds0319;

import java.util.Scanner;

public class DigitCheck {

    public static void len(int n) {
        System.out.println(n +"�� �ڸ���: " + Integer.toString(n).length());
    }
    public static void sum(int n) {
        char[] nums = (String.valueOf(n)).toCharArray() ;
        int sum = 0;
        for(char c : nums) {
            sum += Character.getNumericValue(c);
        }
        System.out.println(n +"�� �� �ڸ��� �� : " + sum);
    }

    public static void main(String[] args) {
        System.out.println("����(����)�� �Է��Ͻÿ�:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        len(n);
        sum(n);
    }
}
