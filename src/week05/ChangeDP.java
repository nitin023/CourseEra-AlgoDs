package week05;

import java.util.*;

public class ChangeDP {


    private static int getChange(long m) {
        long  numCoins;

        Map<Long,Long> denominationMap = new HashMap<>();
        denominationMap.put(0L,0L);
        List<Integer> givenCoinDenominations = new ArrayList<>(Arrays.asList(1,3,4));
        for(long value = 1 ; value <=m ; value++) {

            denominationMap.put(value, Long.MAX_VALUE);

            for (int denomination : givenCoinDenominations) {
                if (value >= denomination) {
                    numCoins = denominationMap.get(value - denomination) + 1;
                    if (numCoins < denominationMap.get(value)) {
                        denominationMap.put(value, numCoins);
                    }
                }
            }
        }
        return denominationMap.get(m).intValue();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
