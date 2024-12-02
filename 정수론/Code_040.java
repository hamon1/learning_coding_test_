// 문제
// 어떤 정수 X가 1보다 큰 제곱수로 나누어 떨어지지 않을 때, 그 수를 제곱ㄴㄴ수라고 한다. 제곱수는 정수의 제곱이다. min과 max가 주어지면, min보다 크거나 같고, max보다 작거나 같은 제곱ㄴㄴ수가 몇 개 있는지 출력한다.

// 입력
// 첫째 줄에 두 정수 min과 max가 주어진다.

// 출력
// 첫째 줄에 min보다 크거나 같고, max보다 작거나 같은 제곱ㄴㄴ수의 개수를 출력한다.
import java.io.*;
import java.util.*;

public class Code_040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] list = new boolean[(int)(max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            long n = i*i;
            long start_idx = min / n;
            if (min % n != 0) {
                start_idx++;
            }
            for (long j = start_idx; n * j <= max; j++) {
                list[(int)((j * n) - min)] = true;
            }
        }

        
        int count = 0;

        for (long i = 0; i <= max-min; i++) {
            if (!list[(int)i]) count++;
        }

        System.out.println(count);
    }
    // static Long is(long num, boolean[] list) {
        
    // }
}
