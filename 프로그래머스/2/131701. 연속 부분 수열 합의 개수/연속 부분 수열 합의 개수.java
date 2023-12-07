import java.util.*;

class Solution {
    public int solution(int[] elements) {     
        Set<Integer> set = new HashSet<>();
        
        int[] arr = new int[elements.length * 2];
        for (int i = 0; i <= arr.length / 2; i += arr.length / 2) {
            System.arraycopy(elements, 0, arr, i, elements.length);
        }

        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = i; j < i + elements.length; j++) {
                sum += arr[j];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}