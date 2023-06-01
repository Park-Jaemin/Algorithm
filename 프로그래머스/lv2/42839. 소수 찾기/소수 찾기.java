import java.util.*;

class Solution {
    public int solution(String numbers) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length(); i++) {
            getNum(set, numbers.split(""), new boolean[numbers.length()], "");
        }

        boolean[] prime = new boolean[set.last()+1];
        getPrime(prime);

        int count = 0;
        for (int num : set) {
            if (!prime[num]) count++;
        }

        return count;
    }
    
    private static void getPrime(boolean[] prime) {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }

    private static void getNum(Set<Integer> set, String[] split, boolean[] using, String num) {
        for (int i = 0; i < split.length; i++) {
            if (!using[i]) {
                num += split[i];
                using[i] = true;
                getNum(set, split, using, num);
                num = num.substring(0, num.length() - 1);
                using[i] = false;
            } else {
                set.add(Integer.parseInt(num));
            }
        }
    }
}