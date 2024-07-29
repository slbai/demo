package a20220718;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4,5,1,3,9,6,8};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int p = arr[l];
        int left = l;
        int right = r;

        while (left < right) {
            while (left < right && arr[right] >= p) {
                right--;
            }
            while (left < right && arr[left] <= p) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        arr[l] = arr[right];
        arr[right] = p;
        sort(arr, l, right - 1);
        sort(arr, right + 1, r);
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
