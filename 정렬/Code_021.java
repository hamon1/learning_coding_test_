// 문제
// N개의 수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에 대해서 버블 소트를 수행할 때, Swap이 총 몇 번 발생하는지 알아내는 프로그램을 작성하시오.

// 버블 소트는 서로 인접해 있는 두 수를 바꿔가며 정렬하는 방법이다. 예를 들어 수열이 3 2 1 이었다고 하자. 이 경우에는 인접해 있는 3, 2가 바뀌어야 하므로 2 3 1 이 된다. 다음으로는 3, 1이 바뀌어야 하므로 2 1 3 이 된다. 다음에는 2, 1이 바뀌어야 하므로 1 2 3 이 된다. 그러면 더 이상 바꿔야 할 경우가 없으므로 정렬이 완료된다.

// 입력
// 첫째 줄에 N(1 ≤ N ≤ 500,000)이 주어진다. 다음 줄에는 N개의 정수로 A[1], A[2], …, A[N]이 주어진다. 각각의 A[i]는 0 ≤ |A[i]| ≤ 1,000,000,000의 범위에 들어있다.

// 출력
// 첫째 줄에 Swap 횟수를 출력한다


//정답이 int를 넘을 수 있었음
import java.io.*;
import java.util.*;

public class Code_021 {
    static int[] a, temp;
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            // System.out.println(i + " : " + a[i]);
        }
        // for (int i = 0; i < n; i++) {
        //     System.out.println(a[i]);
        // }
    
        temp = new int[n];


        merge(0, a.length - 1);

        System.out.println(count);
    }

    public static void merge(int s, int e) {
        if (e - s < 1) return;

        int m = s + (e - s) / 2;

        merge(s, m );
        merge(m + 1, e);

        for (int i = s; i <= e; i++) {
            temp[i] = a[i];
        }

        int i = s, j = m+1, k = s;

        while(i <= m && j <= e) {
            if (temp[i] > temp[j]) {
                count += j - k;
                a[k++] = temp[j++];
            }
            else {
                a[k++] = temp[i++];
            }
        }

        while(i <= m && k <= e) {
            a[k++] = temp[i++];
        }
        while(j <= e && k <= e) {
            a[k++] = temp[j++];
        }
    }

}


