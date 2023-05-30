import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        boolean[] visit = new boolean[y+1];
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.offer(new int[]{x, 0});
        visit[x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0];
            int count = poll[1];

            if (cur == y) return count;

            if (cur+n <= y && !visit[cur+n]) {
                visit[cur+n] = true;
                queue.offer(new int[]{cur+n, count+1});
            }
            if (cur*2 <= y && !visit[cur*2]) {
                visit[cur*2] = true;
                queue.offer(new int[]{cur*2, count+1});
            }
            if (cur*3 <= y && !visit[cur*3]) {
                visit[cur*3] = true;
                queue.offer(new int[]{cur*3, count+1});
            }
        }
        return -1;
    }
}