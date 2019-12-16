package week02;

import java.util.Scanner;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {

        int Fib[] = new int[n+2];
        Fib[0] = 0;
        Fib[1] = 1;

        int i;
        for(i = 2 ; i<=n ; i++)
        {
            Fib[i] = (Fib[i-1] + Fib[i-2])%10;
        }
        return Fib[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}
