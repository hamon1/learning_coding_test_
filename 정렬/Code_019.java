// 문제
// 수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 N(1 ≤ N ≤ 5,000,000)과 K (1 ≤ K ≤ N)이 주어진다.

// 둘째에는 A1, A2, ..., AN이 주어진다. (-109 ≤ Ai ≤ 109)

// 출력
// A를 정렬했을 때, 앞에서부터 K번째 있는 수를 출력한다.

import java.io.*;
import java.util.*;

public class Code_019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

    
        int n = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, n - 1, k - 1);
        System.out.println(arr[k - 1]);
    }
    public static void quickSort (int[] arr, int s, int e, int k) {
        if (s < e) {
            int pivot = pivot(arr, s, e);
            if (pivot == k) return;
            else if (k < pivot)
                quickSort(arr, s, pivot - 1, k);
            else 
                quickSort(arr, pivot + 1, e, k);

        }
    }

    public static int pivot (int[] arr, int s, int e) {
        if (s + 1 == e) {
            if (arr[s] > arr[e]) swap(arr, s, e);
            return e;
        }

        int m = (s + e) / 2;

        swap(arr, s, m);

        int pivot = arr[s];

        int i = s + 1, j = e;
        while (i <= j) {
            while (j >= s + 1 && pivot < arr[j]) j--;
            while (i <= e && pivot > arr[i]) i++;

            if (i <= j) {
                swap(arr, i++, j--);
            }
        }

        arr[s] = arr[j];
        arr[j] = pivot;
        return j;
    }

    static void swap (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
