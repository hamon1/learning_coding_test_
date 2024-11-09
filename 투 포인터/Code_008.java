// ## 문제

// N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.

// N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.

// 수의 위치가 다르면 값이 같아도 다른 수이다.

// ## 입력

// 첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)

// ## 출력

// 좋은 수의 개수를 첫 번째 줄에 출력한다.
import java.util.*;

public class Code_008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i< n; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        long count = 0; 

        
        for (int i = 0; i< n; i++) {
            long find = arr[i];
            int p1 = 0;
            int p2 = n - 1;

            while (p1 < p2) {
                if (arr[p1] + arr[p2] == find) {
                    if (p1 != i && p2 != i) {
                        count++;
                        break;
                    } else if (p1 == i) {
                        p1++;
                    } else if (p2 == i){
                        p2--;
                    }
                } else if (arr[p1] + arr[p2] < find) {
                    p1++;
                } else {
                    p2--;
                }
            }
        }

        System.out.println(count);;
    }
}
