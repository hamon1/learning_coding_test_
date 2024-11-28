// 문제
// 세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. B를 오름차순 정렬했을 때, B[k]를 구해보자.

// 배열 A와 B의 인덱스는 1부터 시작한다.

// 입력
// 첫째 줄에 배열의 크기 N이 주어진다. N은 105보다 작거나 같은 자연수이다. 둘째 줄에 k가 주어진다. k는 min(109, N2)보다 작거나 같은 자연수이다.

// 출력
// B[k]를 출력한다.
import java.io.*;
import java.util.*;

public class Code_031 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // long middle = (long)(n/2) * (long)(n/2);

        long start = 1;
        long end = Math.min(1000000000, (long)n*n);

        while(true) {
            long middle = start + (end - start) / 2;
            long a = count_number_of_lower(n, middle);
            long a_0 = count_number_of_lower(n, middle-1);

            if (a_0 < k && a >= k) {
                System.out.println(middle);
                break;
            }

            if (a < k) start = middle + 1;
            else end = middle - 1;
        }

        // System.out.println(count_number_of_lower(n, k));
    }
    static long count_number_of_lower(int n, long number) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            long r = number/i;

            result += Math.min(r, n);
        }

        return result;
    }
}
