package ds0319;

import java.util.Scanner;

public class RecurseTest {
    public static void recurse(int count) {
        if(count <= 0) {
            System.out.println(".");
        } else {
            System.out.println(count + " *");
            recurse(count - 1);
        }
    }
    public static int factRecurse(int num) {
        if(num <= 1) return 1;
        else return num * factRecurse(num-1);
    }
    public static int factRep(int num) {
        int res = 1;
        for(int i = 1; i <= num; i++) {
            res *= i;
        }
        return res;
    }

    public static int power(int x, int n) {
        if(n == 0) return 1;
        else if(n%2==0)  return power(x*x,n/2);
        else return x*power(x*x,(n-1)/2);
    }

    public static int fib(int n) {
        if(n==0) return 0;
        else if(n==1) return 1;
        else return fib(n-1) + fib(n-2);
    }

    public static int fib_iter(int n) {
        if (n < 2) return n;
        else {
            int last = 0;
            int current = 1;
            for(int i = 2; i < n+1; i++) {
                int tmp = current;
                current += last;
                last = tmp;
            } return current;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fib_iter(sc.nextInt()));
    }
}
