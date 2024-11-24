// 문제
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

// 출력
// 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

// 기수 정렬
import java.io.*;
import java.util.*;

public class Code_022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            ary[i] = num;
            if (num > max) max = num;
        }


    }
    public static void radixSort(int[] ary, int max) {
        int exp = 1;
        while ((max/exp)%(exp*10) > 0) {
            int[][] a = new int[ary.length][2];

            for (int i = 0; i < ary.length; i++) {
                int n = (ary[i] / exp) % (exp*10);
                a[i][0] = n;
                a[i][1] = i;
            }
            Arrays.sort(a, new Comparator() {
                
            })
        }
    }
    // exp: 자릿수
    public static void countingSort(int exp, int max) {

    }

}
