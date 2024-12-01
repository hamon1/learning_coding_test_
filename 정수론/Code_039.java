// 문제
// 어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 팰린드롬이라 부른다. 예를 들어 79,197과 324,423 등이 팰린드롬 수이다.

// 어떤 수 N (1 ≤ N ≤ 1,000,000)이 주어졌을 때, N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 N이 주어진다.

// 출력
// 첫째 줄에 조건을 만족하는 수를 출력한다.
import java.io.*;
import java.util.*;

public class Code_039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;

        int n = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[9000000];
        prime[1] = true;

        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i*2; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                int prime_num = i;

                if (isPalindrome(prime_num)) {
                    if (prime_num >= n) {
                        System.out.println(prime_num);
                        return;
                    }
                }

            }
        }
    }
    static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        StringBuilder sb = new StringBuilder(str);
        return str.equals(sb.reverse().toString());
    }
}
