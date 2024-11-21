// 문제
// 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

// 출력
// 첫째 줄에 연결 요소의 개수를 출력한다.
import java.io.*;
import java.util.*;

public class Code_023 {
    static int[][] list;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new int[n][n];

        for (int i = 0; i < m; i++)  {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            list[u][v] = 1;
            list[v][u] = 1;
        }

        visited = new boolean[n];
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, check);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
    static void dfs(int node, boolean[] check) {
        visited[node] = true;
        for (int i = 0; i < list[0].length; i++) {
            if (!visited[i] && list[node][i] == 1) {
                check[i] = true;
                dfs(i, check);
            }
        }
        return;
        // if (!check_checkedAllList(check)) cnt++;
    }
    static boolean check_checkedAllList(boolean[] check) {
        for (int i = 0; i < check.length; i++) {
            if (!check[i]) return false;
        }
        return true;
    }
}
