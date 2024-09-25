import java.util.*;

public class Code_000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        bubble_sort(arr);

        print_arr(merge_sort(arr));

        //백준 제출 용
        // int[] result = merge_sort(arr);
        // for (int i = 0; i < result.length; i++) {
        //     System.out.println(result[i]);
        // }
    }

    // 시간 복잡도 = O(n^2)
    public static void bubble_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-(i+1); j++) {
                int a = arr[j];
                int b = arr[j+1];

                if (a > b) {
                    int temp = b;
                    arr[j+1] = a;
                    arr[j] = temp;
                }
            }
        }
        print_arr(arr);
    }

    // 시간 복잡도 = O(n log n)
    public static int[] merge_sort(int[] arr) {
        int length = arr.length;
        if (length <= 1) {
            return arr;
        }

        int mid = length / 2;
        int[] left = merge_sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = merge_sort(Arrays.copyOfRange(arr, mid, length));
        
        int[] merge_arr = new int[length];
        int i = 0; int j = 0; int idx = 0;
        while (i < left.length && j < right.length) {
            if (left[i] > right[j]) {
                merge_arr[idx++] = right[j++];
            }
            else {
                merge_arr[idx++] = left[i++];
            }
        }
        while (i < left.length) {
            merge_arr[idx++] = left[i++];
        }
        while (j < right.length) {
            merge_arr[idx++] = right[j++];
        }

        return merge_arr;
    }

    public static void print_arr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
