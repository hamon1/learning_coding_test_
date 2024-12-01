// 문제
// M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

// 출력
// 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
import java.io.*;
import java.util.*;

public class Code_037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] list = new boolean[m + 1];
        list[1] = true;

        for (int i = 2; i <= m; i++) {
            if (!list[i]) {
                for (int j = i*2; j <= m; j += i) {
                    list[j] = true;
                }
            }
        }
        
        for (int i = n; i < list.length; i++) {
            if (!list[i]) {
                System.out.println(i);
            }
        }
    }
}
