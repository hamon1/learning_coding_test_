// 문제
// 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

// 입력
// 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

// 출력
// 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.

import java.io.*;
import java.util.*;

public class Code_017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();

        int[] n = new int[line.length()];
        for (int i = 0; i < n.length; i++) {
            n[i] = line.charAt(i) - '0';
        }

        int min = 1000000000;
        int idx = 0;

        for (int i = 0; i < n.length; i++) {
            min = 1000000000;
            for (int j = 0; j < n.length - i; j++) {
                if (n[j] < min) {
                    min = n[j];
                    idx = j;
                }
            }
            n[idx] = n[n.length - i - 1];
            n[n.length - i - 1] = min;
        }

        for (int i = 0; i < n.length; i++) {
            bw.write(String.valueOf(n[i]));
        }
        bw.flush();
        bw.close();
    }
}
