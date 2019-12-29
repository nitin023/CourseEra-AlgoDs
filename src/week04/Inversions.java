package week04;

import java.util.Scanner;

public class Inversions {
    private static long getNumberOfInversions(int[] a,  int left, int right) {
        long numberOfInversions = 0;
        for(int i = left ; i < right ; i++)
        {
            for(int j = i + 1 ; j < right ; j++)
            {
                if(a[i] > a[j])
                {
                    numberOfInversions++;
                }
            }
        }
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(getNumberOfInversions(a, 0, a.length));
    }
}
