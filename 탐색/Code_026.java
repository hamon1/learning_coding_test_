// 문제
// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

// 입력
// 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

// 출력
// 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
import java.io.*;
import java.util.*;

public class Code_026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i <= n; i++) {
            if (graph[i] != null) {
                Collections.sort(graph[i]);
            }
        }

        boolean[] visited = new boolean[n + 1];

        System.out.print(start + " ");
        dfs(start, graph, visited);

        System.out.println();
        visited = new boolean[n + 1];
        // System.out.print(start + " ");
        bfs(start, graph, visited);
    }
    static void dfs (int i, LinkedList<Integer>[] graph, boolean[] visited) {
        if (!visited[i]) {
            visited[i] = true;
            for (int n : graph[i]) {
                if (!visited[n]) {
                    System.out.print(n + " ");
                    dfs(n, graph, visited);
                }
            }
        }
    }
    static void bfs (int i, LinkedList<Integer>[] graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            System.out.print(n + " ");
            for (int v : graph[n]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
}
