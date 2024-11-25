// 문제
// 강토는 자신의 기타 강의 동영상을 블루레이로 만들어 판매하려고 한다. 블루레이에는 총 N개의 강의가 들어가는데, 블루레이를 녹화할 때, 강의의 순서가 바뀌면 안 된다. 순서가 뒤바뀌는 경우에는 강의의 흐름이 끊겨, 학생들이 대혼란에 빠질 수 있기 때문이다. 즉, i번 강의와 j번 강의를 같은 블루레이에 녹화하려면 i와 j 사이의 모든 강의도 같은 블루레이에 녹화해야 한다.

// 강토는 이 블루레이가 얼마나 팔릴지 아직 알 수 없기 때문에, 블루레이의 개수를 가급적 줄이려고 한다. 오랜 고민 끝에 강토는 M개의 블루레이에 모든 기타 강의 동영상을 녹화하기로 했다. 이때, 블루레이의 크기(녹화 가능한 길이)를 최소로 하려고 한다. 단, M개의 블루레이는 모두 같은 크기이어야 한다.

// 강토의 각 강의의 길이가 분 단위(자연수)로 주어진다. 이때, 가능한 블루레이의 크기 중 최소를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 강의의 수 N (1 ≤ N ≤ 100,000)과 M (1 ≤ M ≤ N)이 주어진다. 다음 줄에는 강토의 기타 강의의 길이가 강의 순서대로 분 단위로(자연수)로 주어진다. 각 강의의 길이는 10,000분을 넘지 않는다.

// 출력
// 첫째 줄에 가능한 블루레이 크기중 최소를 출력한다.
import java.io.*;
import java.util.*;

public class Code_030 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int sum = 0;

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if (arr[i] > max) max = arr[i];
        }

        
        System.out.println(binarySearch(arr, sum, m, max));
    }
    static int binarySearch(int[] arr, int sum, int m, int max) {
        int start = max;
        int end = sum;
        int mid;

        while (start <= end) {
            mid = (end + start) / 2;
            // System.out.println(mid + " " + start + " " + end);

            if (isPossible(arr, mid, m)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
    static boolean isPossible(int[] arr, int mid, int m) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > mid) {
                count++;
                sum = 0;
            }
            sum += arr[i];
        }
        if (sum != 0) count++;
        // System.out.println(count + " " + m);
        if (count > m) return true;
        return false;
    }
}
