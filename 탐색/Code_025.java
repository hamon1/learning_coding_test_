// 문제
// BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

// 오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

// A는 B와 친구다.
// B는 C와 친구다.
// C는 D와 친구다.
// D는 E와 친구다.
// 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.

// 둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.

// 출력
// 문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
import java.io.*;
import java.util.*;

public class Code_025 {
    static boolean result;
    static Stack<Integer> isfriend;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // boolean[][] friends = new boolean[n][n];
        LinkedList<Integer>[] friends = new LinkedList[n];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // friends[a][b] = friends[b][a] = true;
            if (friends[a] == null) friends[a] = new LinkedList<>();
            if (friends[b] == null) friends[b] = new LinkedList<>();
            friends[a].add(b);
            friends[b].add(a);
        }
        
        // boolean[] visited;
        isfriend = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (result) break;
            isfriend.clear();
            boolean[] visited = new boolean[n];
            isfriend.push(i);
            dfs(i, friends, visited);
        }
        if (result) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static void dfs(int n, LinkedList<Integer>[] friends, boolean[] visited) {
        if (isfriend.size() >= 5) {
            result = true;
            return;
        }
        if (!visited[n]) {
            visited[n] = true;
            
            for (int i : friends[n]) {
                // System.out.println("n: " + isfriend.peek() + " / " +  i);
                if (!visited[i]) {
                    isfriend.push(i);
                    dfs(i, friends, visited);
                }
            }
        } 
            isfriend.pop();
            visited[n] = false;
            return;

    }
}
