package week04;

import java.util.Scanner;

public class Inversions {
    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
       int mid;
        if (right > left) {
            mid = (right + left) / 2;

            /* Inversion count will be the sum of inversions in left-part, right-part
          and number of inversions in merging */
            numberOfInversions += getNumberOfInversions(a, b, left, mid);
            numberOfInversions += getNumberOfInversions(a, b, mid + 1, right);

            /*Merge the two parts*/
            numberOfInversions += merge(a, b, left, mid + 1, right);
        }
        //write your code here
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }


    private static int merge(int[] arr, int[] temp, int left, int mid, int right)
    {
        int i, j, k;
        int inv_count = 0;

        i = left; /* i is index for left subarray*/
        j = mid; /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right) && j<arr.length && i < arr.length) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
                /*this is tricky -- see above explanation/diagram for merge()*/
                inv_count = inv_count + (mid - i);
            }
        }

        /* Copy the remaining elements of left subarray
       (if there are any) to temp*/
        while (i <= mid - 1)
            temp[k++] = arr[i++];

        /* Copy the remaining elements of right subarray
       (if there are any) to temp*/
        while (j <= right && k<temp.length && j < arr.length)
            temp[k++] = arr[j++];

        /*Copy back the merged elements to original array*/
        for (i = left; i <= right && i<arr.length && i < temp.length ; i++)
            arr[i] = temp[i];

        return inv_count;
    }
}
