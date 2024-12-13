// 문제
// 자연수 n이 주어졌을 때, GCD(n, k) = 1을 만족하는 자연수 1 ≤ k ≤ n 의 개수를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 자연수 n (1 ≤ n ≤ 1012)이 주어진다.

// 출력
// GCD(n, k) = 1을 만족하는 자연수 1 ≤ k ≤ n 의 개수를 출력한다.
import java.io.*;
import java.util.*;

public class Code_041 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;

        long n = Long.parseLong(br.readLine());

        long result = n;
        // n = p_1^x * p_2^Y * ...;
        // p 는 소수
        for (long p = 2; p <= Math.sqrt(n); p++) {
            if (n % p == 0) {
                result = result - result/p;
                while (n % p == 0) { // p_1^x 에서 x만큼 나누기 (해당 소수를 식에서 완전 삭제)
                    n /= p;
                }
                // 후에 n 안의 새로운 소수를 찾음
            }
        }
        if (n > 1) { // n이 1 이상인 경우 == n의 식 안에 포함될 숫자가 남음
            result = result - result/n;
        }
        System.out.println(result);
    }
}
