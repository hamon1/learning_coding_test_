// 문제
// N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

// 출력
// M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
import java.io.*;
import java.util.*;

public class Code_029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] values = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ary);

        for (int i = 0; i < m; i++) {
            System.out.println(binarySearch(ary, values[i]));  // 1 or 0 출력 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1 0 or 1
        }

    }

    static int binarySearch(int[] ary, int values) {
        int start = 0; 
        int end = ary.length - 1;

        int mid;
        
        while (start <= end) {
            mid = start + (end - start) / 2;

            if (ary[mid] == values) {
                return 1;
            }
            
            if (ary[mid] < values) {
                start = mid + 1;
            } else if (ary[mid] > values) {
                end = mid - 1;
            }
        }

        return 0;
    }
}
