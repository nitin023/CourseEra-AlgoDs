package week03;

import java.util.Scanner;

public class Change {
    private static int getChange(int m) {

        int denominations[] = {10,5,1};
        int numCoins = 0;
        for (int i = 0 ; i<denominations.length ; i++){
            numCoins+=(m/denominations[i]);
            m %=denominations[i];
        }
        return numCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
