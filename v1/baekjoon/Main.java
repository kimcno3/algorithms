package v1.baekjoon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println(recursion(sc.nextInt()));
    }

    public static int recursion(int n) {
        System.out.println(n);
        if (n >= 2) {
            return recursion(n-1) + recursion(n-2);
        } else if (n == 1) {
            return 1;
        } else {
            return 0;
        }
    }
}