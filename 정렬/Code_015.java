// 문제
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

// 출력
// 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

import java.io.*;
import java.util.*;

public class Code_015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] ary = new int[n];

        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }

        int num = n - 1;
        
        while (num > 0) {
            for (int i = 0; i < num ; i++) {
                if (ary[i] > ary[i + 1]) {
                    int a = ary[i];
                    int b = ary[i + 1];
                    ary[i] = b;
                    ary[i + 1] = a;
                }
            }
            num--;
        }

        for (int i = 0; i < n; i++) {
            bw.write(ary[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
