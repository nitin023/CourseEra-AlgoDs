package week02;

import java.util.Scanner;

public class Fibonacci {
    private static long calc_fib(int n) {
        int Fib[] = new int[n+2];
        int i;

        Fib[0] = 0 ; Fib[1]  = 1;
        for(i = 2 ; i <=n ; i++)
        {
            Fib[i] = Fib[i-1] + Fib[i-2];
        }
        return Fib[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}
