package week03;

import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        List<String> numberList = new ArrayList<>(Arrays.asList(a));
        numberList.sort((String num1, String num2) -> {
            String ab = num1 + num2;
            String ba = num2 + num1;
            return ba.compareTo(ab);
        });
        StringBuilder result = new StringBuilder();
        for (String num : numberList) {
            result.append(num);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
