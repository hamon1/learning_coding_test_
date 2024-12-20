// 문제
// august14는 세상에서 가장 맛있는 칵테일이다. 이 칵테일을 만드는 정확한 방법은 아직 세상에 공개되지 않았지만, 들어가는 재료 N개는 공개되어 있다. 

// 경근이는 인터넷 검색을 통해서 재료 쌍 N-1개의 비율을 알아냈고, 이 비율을 이용해서 칵테일에 들어가는 전체 재료의 비율을 알아낼 수 있다.

// 총 재료 쌍 N-1개의 비율이 입력으로 주어진다. 이때, 칵테일을 만드는데 필요한 각 재료의 양을 구하는 프로그램을 작성하시오. 이때, 필요한 재료의 질량을 모두 더한 값이 최소가 되어야 한다. 칵테일을 만드는 재료의 양은 정수이고, 총 질량은 0보다 커야한다.

// 비율은 "a b p q"와 같은 형식이고, a번 재료의 질량을 b번 재료의 질량으로 나눈 값이 p/q라는 뜻이다.

// 입력
// 첫째 줄에 august14를 만드는데 필요한 재료의 개수 N이 주어지며, N은 10보다 작거나 같은 자연수이다.

// 둘째 줄부터 N-1개의 줄에는 재료 쌍의 비율이 한 줄에 하나씩 주어지는데, 문제 설명에 나온 형식인 "a b p q"로 주어진다. 재료는 0번부터 N-1까지이며, a와 b는 모두 N-1보다 작거나 같은 음이 아닌 정수이다. p와 q는 9보다 작거나 같은 자연수이다.

// 출력
// 첫째 줄에 칵테일을 만드는데 필요한 각 재료의 질량을 0번 재료부터 순서대로 공백으로 구분해 출력한다.
import java.util.*;
import java.io.*;

public class Code_044 {
    static boolean[] visited;
    static long[][] ratio;
    static long[] result;
    static class Ratio {
        int to, p, q;
        Ratio(int to, int p, int q) {
            this.to = to;
            this.p = p;
            this.q = q;
        }
    }
    static List<Ratio>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ratio = new long[n - 1][4];
        result = new long[n];
        visited = new boolean[n];
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        long l = 1;
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph[a].add(new Ratio(b, p, q));
            graph[b].add(new Ratio(a, q, p));

            l *= (p * q / lcm(p, q));
        }

        // System.out.println(l);
        result[0] = l;

        dfs(0);

        long lcm = result[0];
        for (int i = 1; i < n; i++) {
            lcm = lcm(lcm, result[i]);
        }

        // for (int i = 0; i < result.length; i++) {
        //     System.out.print(result[i] + " ");
        // }
        // System.out.println(lcm);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]/lcm + " ");
        }


    }
    static long lcm(long a, long b) {
        if (b == 0) 
        return a;
        else
        return lcm(b, a % b);
    }
    // static int gcd(int a, int b) {
    //     int n = lcm(a, b);
    //     return a*b/n;
    // }
    static void dfs(int idx) {
        visited[idx] = true;
        for (Ratio r : graph[idx]) {
                if (!visited[r.to]) {
                    // System.out.println(r.to + " result[idx]? " + result[idx] + "/ q/p ? " + r.q/r.p);
                result[r.to] = result[idx] / r.p * r.q;
                // System.out.println(result[r.to] + "///" + idx);
                dfs(r.to);
            }
        }
    }
}
