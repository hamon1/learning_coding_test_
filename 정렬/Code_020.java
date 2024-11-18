// 문제
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

// 출력
// 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
import java.io.*;
import java.util.*;

public class Code_020 {
    static int[] a, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        temp = new int[n];

        for (int i = 0; i < n; i++) { 
            a[i] = Integer.parseInt(br.readLine());
        }

        merge(0, a.length - 1);

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }

    public static void merge(int s, int e) {
        if (e - s < 1) return;

        int m = s + (e - s) / 2;

        merge(s, m );
        merge(m + 1, e);

        for (int i = s; i <= e; i++) {
            temp[i] = a[i];
        }

        int i = s, j = m+1, k = s;

        while(i <= m && j <= e) {
            if (temp[i] > temp[j]) {
                a[k++] = temp[j++];
            }
            else {
                a[k++] = temp[i++];
            }
        }

        while(i <= m && k <= e) {
            a[k++] = temp[i++];
        }
        while(j <= e && k <= e) {
            a[k++] = temp[j++];
        }
    }

}
