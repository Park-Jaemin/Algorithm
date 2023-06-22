import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<Integer>[] graph = new ArrayList[n+1];
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int[] wire : wires) {
            int from = wire[0];
            int to = wire[1];

            graph[from].remove(Integer.valueOf(to));
            graph[to].remove(Integer.valueOf(from));

            int count = dfs(1, new boolean[n + 1], graph);
            min = Math.min(min, Math.abs(n - count - count));

            graph[from].add(to);
            graph[to].add(from);
        }
        return min;
    }
    
    int dfs(int start, boolean[] visit, List<Integer>[] graph) {
        visit[start] = true;
        int count = 1;

        for (int to : graph[start]) {
            if (!visit[to]) {
                count += dfs(to, visit, graph);
            }
        }
        return count;
    }
}