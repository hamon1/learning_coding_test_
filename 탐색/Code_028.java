// 문제
// 트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.

// 입력
// 트리가 입력으로 주어진다. 먼저 첫 번째 줄에서는 트리의 정점의 개수 V가 주어지고 (2 ≤ V ≤ 100,000)둘째 줄부터 V개의 줄에 걸쳐 간선의 정보가 다음과 같이 주어진다. 정점 번호는 1부터 V까지 매겨져 있다.

// 먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 하나는 정점번호, 다른 하나는 그 정점까지의 거리이다. 예를 들어 네 번째 줄의 경우 정점 3은 정점 1과 거리가 2인 간선으로 연결되어 있고, 정점 4와는 거리가 3인 간선으로 연결되어 있는 것을 보여준다. 각 줄의 마지막에는 -1이 입력으로 주어진다. 주어지는 거리는 모두 10,000 이하의 자연수이다.

// 출력
// 첫째 줄에 트리의 지름을 출력한다.
import java.io.*;
import java.util.*;

public class Code_028 {
    static int MAX = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());

        LinkedList<int[]>[] tree = new LinkedList[v + 1];
        for (int i = 0; i <= v; i++) {
            tree[i] = new LinkedList<>();
        }

        for (int i = 1; i <= v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int nextNode = Integer.parseInt(st.nextToken());
                if (nextNode == -1) break;
                int w = Integer.parseInt(st.nextToken());
                tree[node].add(new int[]{nextNode, w});
            }
        }
    int[] result;
    MAX = 0;

    boolean[] visited = new boolean[v + 1];
    
    result = searchMax(tree, 1, visited);
    visited = new boolean[v + 1];

    MAX = searchMax(tree, result[0], visited)[1];

    System.out.println(MAX);
    }
    static int[] searchMax (LinkedList<int[]>[] tree, int i, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();
        int[] distance = new int[visited.length];

        q.add(new int[]{i, 0});
        visited[i] = true;
        int max = 0;
        
        while(!q.isEmpty()) {
            int[] node = q.poll();

            for (int[] nextNode : tree[node[0]]) {
                if (!visited[nextNode[0]]) {
                    visited[nextNode[0]] = true;
                    q.add(new int[] {nextNode[0], nextNode[1]});

                    distance[nextNode[0]] = distance[node[0]] + nextNode[1];

                }
            }
        }


        int f = 0;
        for (int j = 1; j < distance.length; j++) {
            if (distance[j] > max) {
                max = distance[j];
                f = j;
            }
        }

        return new int[]{f, max};
    }
}
