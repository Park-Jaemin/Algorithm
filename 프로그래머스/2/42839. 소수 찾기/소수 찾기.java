import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> set = findNumber(numbers.split(""), new HashSet<Integer>(), new boolean[numbers.length()], "");
        return findPrimeNumber(set);
    }
    
    Set<Integer> findNumber(String[] arr, Set<Integer> set, boolean[] used, String now) {
        if (now.length() == arr.length) {
            return set;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                now += arr[i];
                set.add(Integer.parseInt(now));
                findNumber(arr, set, used, now);
                used[i] = false;
                now = now.substring(0, now.length() - 1);
            }
        }
        
        return set;
    }
    
    int findPrimeNumber(Set<Integer> set) {
        int count = 0;
        for (int num : set) {
            count += isPrime(num);
        }
        return count;
    }
    
    int isPrime(int num) {
        if (num == 0 || num == 1) return 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return 0;
        }
        return 1;
    }
}