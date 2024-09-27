// 문제
// 수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.

// 즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.

// 입력
// 첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)

// 둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)

// 출력
// 첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
import java.util.*;

public class Code_005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] sum = new long[n];
        long[] mod = new long[m];
        long count = 0;

        sum[0] = sc.nextInt();
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int num = (int)(sum[i] % m);

            if (num == 0) count++;

            mod[num]++;
        }

        for (int i = 0; i < mod.length; i++) {
            if (mod[i] > 1) {
                count += (mod[i] * (mod[i] - 1) / 2);  // C(mod[i], 2)
            }
        }

        sc.close();

        System.out.println(count);
    }
}