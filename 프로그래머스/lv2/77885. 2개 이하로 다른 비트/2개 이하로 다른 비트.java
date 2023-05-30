class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = find(numbers[i]);
        }

        return answer;
    }
    
    long find(long number) {
        // number -> 비트(2진수) 만들기
        StringBuilder curBit = new StringBuilder("0" + Long.toBinaryString(number));
        int length = curBit.length() - 1;

        if (curBit.charAt(length) == '0') {
            return number + 1;
        }

        while (curBit.charAt(length) == '1') {
            curBit.replace(length, length+1, "0");
            length--;
        }
        curBit.replace(length, length+1, "1");

        for (int i = curBit.length() - 1; i - length >= 2 && i >= 0; i--) {
            curBit.replace(i, i+1, "1");
        }

        return Long.parseLong(curBit.toString(), 2);
    }
}