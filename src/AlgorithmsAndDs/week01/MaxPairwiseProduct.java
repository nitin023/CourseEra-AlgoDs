package AlgorithmsAndDs.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Max product of any pair
* */

public class MaxPairwiseProduct {

    static long getMaxPairwiseProduct(int[] numbers) {
        long max_product = 0;
        int n = numbers.length , i;

        long firstMax = Long.MIN_VALUE,secondMax = Long.MIN_VALUE;
        int firstIndex = -1;
        for(i = 0 ; i<n; i++)
        {
            if(numbers[i] > firstMax)
            {
                firstMax = numbers[i];
                firstIndex = i;
            }
        }

        for(i = 0 ; i<n; i++)
        {
            if(numbers[i] > secondMax && i!=firstIndex)
            {
                secondMax = numbers[i];
            }
        }
        max_product = firstMax * secondMax;
        return max_product;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
