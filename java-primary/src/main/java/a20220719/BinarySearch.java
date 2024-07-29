package a20220719;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {0,2,4,6,12,51,623,2141};
        System.out.println(bs(arr, 51, 0, arr.length - 1));
    }
    public static int bs(int[] arr, int x, int l, int r) {
        if (l == r && arr[l] != x) {
            return -1;
        }

        int mid = (l + r) /2;
        if (arr[mid] > x) {
            return bs(arr, x, l, mid - 1);
        } else if (arr[mid] < x) {
            return bs(arr, x, mid + 1, r);
        } else {
            return mid;
        }
    }
}
