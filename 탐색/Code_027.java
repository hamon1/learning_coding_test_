// 문제
// N×M크기의 배열로 표현되는 미로가 있다.

// 1	0	1	1	1	1
// 1	0	1	0	1	0
// 1	0	1	0	1	1
// 1	1	1	0	1	1
// 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

// 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

// 입력
// 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

// 출력
// 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
import java.io.*;
import java.util.*;

public class Code_027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String Line = br.readLine();

            for (int j = 0; j < m; j++) { 
                map[i][j] = Line.charAt(j) - '0';
            }
        }

        bfs(n-1, m-1, map, visited);

    }
    static void bfs (int i, int j, int[][] map, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        // visited[0][0] = true;

        while (!queue.isEmpty()) {
            int node[] = queue.poll();
            int x = node[0];
            int y = node[1];
            int count = node[2];

            if (x < 0 || y < 0 || x > i || y > j) continue;
            if (visited[x][y]) continue;
            if (map[x][y] != 1) continue;

            visited[x][y] = true;

            if (x == i && y == j) {
                System.out.println(count);
                return;
            }

            queue.add(new int[]{x, y + 1, count + 1});
            queue.add(new int[]{x + 1, y, count + 1});
            queue.add(new int[]{x, y - 1, count + 1});
            queue.add(new int[]{x - 1, y, count + 1});

            // visited[x][y] = false;
    
        }
    }
}
