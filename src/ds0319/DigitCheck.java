// 자료구조(6007) 과제 1 (60211665 박진형)
package ds0319;

import java.util.Scanner;

public class DigitCheck {

    public static void len(int n) {
        System.out.println(n +"의 자릿수: " + Integer.toString(n).length());
    }
    public static void sum(int n) {
        char[] nums = (String.valueOf(n)).toCharArray() ;
        int sum = 0;
        for(char c : nums) {
            sum += Character.getNumericValue(c);
        }
        System.out.println(n +"의 각 자릿수 합 : " + sum);
    }

    public static void main(String[] args) {
        System.out.println("숫자(정수)를 입력하시오:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        len(n);
        sum(n);
    }
}
