class Solution {
    public int solution(int n) {
        int count = getCount(n);
        while (true) {
            if (count == getCount(++n)) break;
        }
        return n;
    }
    
    int getCount(int n) {
        String binary = Integer.toBinaryString(n);
        return binary.length() - binary.replace("1", "").length();
    }
}