class Solution {
    public int solution(int n, int k) {
        String kNumber = makeKNumber(n, k);          
        return findPrimeCount(kNumber.split("0"));
    }
    
    String makeKNumber(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n%k);
            n /= k;
        }
        return sb.reverse().toString();
    }
    
    int findPrimeCount(String[] arr) {
        int count = 0;
        for (String num : arr) {
            if (num.equals("1") || num.equals("")) continue;
            if (isPrime(Long.parseLong(num))) count++;
        }
        
        return count;
    }
    
    boolean isPrime(long num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}