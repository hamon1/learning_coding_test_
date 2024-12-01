// 문제
// 어떤 수가 소수의 N제곱(N ≥ 2) 꼴일 때, 그 수를 거의 소수라고 한다.

// 두 정수 A와 B가 주어지면, A보다 크거나 같고, B보다 작거나 같은 거의 소수가 몇 개인지 출력한다.

// 입력
// 첫째 줄에 왼쪽 범위 A와 오른쪽 범위 B가 공백 한 칸을 사이에 두고 주어진다.

// 출력
// 첫째 줄에 총 몇 개가 있는지 출력한다.

// 제한
// 1 ≤ A ≤ B ≤ 10^14
import java.io.*;
import java.util.*;

public class Code_038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int max_prime = (int)Math.sqrt(b) + 1;
        // int max_prime = (int)b;

        // System.out.println(b + " " + max_prime);

        boolean[] prime = new boolean[max_prime];

        for (int i = 2; i < max_prime; i++) {
            if (!prime[i]) {
                for (int j = i * 2; j < max_prime; j += i) {
                    prime[j] = true;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < max_prime; i++) {
            if (!prime[i]) {
                long prime_num = i;
                // System.out.println(prime_num + "\n");
                prime_num *= i;
                while (prime_num <= b) {
                    if (prime_num >= a) count++;
                    if (prime_num > b / i) break;
                    prime_num *= i;
                }
            }
        }

        System.out.println(count);
    }
}
