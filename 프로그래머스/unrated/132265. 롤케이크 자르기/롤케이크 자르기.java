import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int[] left = new int[10001];
        int[] right = new int[10001];
        int r = 0;
        for (int x : topping) {
            if (right[x] == 0) {
                r++;
            }
            right[x]++;
        }
        
        int ans = 0;
        int l = 0;
        for (int x : topping) {
            if (right[x] == 1) { // right[1] = 1 -> 0
                r--;
            }

            if (left[x] == 0) { // left[1] = 0 -> 1
                l++;
            }
            right[x]--;
            left[x]++;

            if (l == r) {
                ans++;
            }
        }
        return ans;
    }
}