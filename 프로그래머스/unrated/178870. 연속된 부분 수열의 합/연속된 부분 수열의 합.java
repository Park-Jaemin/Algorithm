import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        List<int[]> list = new ArrayList<>();
        int left = 0;
        int right = 0;

        int sum = sequence[0];
        do {
            if (sum == k) {
                list.add(new int[]{left, right});
            }

            if (sum <= k && right < sequence.length) {
                right++;
                if (right < sequence.length) sum += sequence[right];
            } else {
                if (left < sequence.length) sum -= sequence[left];
                left++;
            }

        } while (right != sequence.length || left != sequence.length);

        list.sort(Comparator.comparing(o->o[1]-o[0]));
        return list.get(0);
    }
}