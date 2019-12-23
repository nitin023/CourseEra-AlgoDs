package week03;

import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        Set<Integer> tempSummands = new LinkedHashSet<>();
        int currentSum = 0 , i = 1;
        while (currentSum <= n)
        {
            tempSummands.add(i);
            currentSum+=i;
            i++;
        }
        if(currentSum > n)
        {
            int diff = currentSum - n;
            tempSummands.remove(diff);
        }
        summands = new ArrayList<>(tempSummands);
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}
