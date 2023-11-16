class Solution {
    public int solution(int storey) {
        int answer = 0;

        String num = Integer.toString(storey);
        int[] arr = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i) - '0';
        }

        for (int i = arr.length-1; i >= 0; i--) {
            int now = arr[i];

            if (now > 5) {
                now = 10 - now;

                if (i == 0) answer++;
                else arr[i-1]++;
            } else if (now == 5 && i > 0 && arr[i-1] >= 5) {
                arr[i-1]++;
            }
            answer += now;
        }

        return answer;
    }
}