import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String head1 = extractHead(o1);
            String head2 = extractHead(o2);
            if (!head1.equals(head2)) return head1.compareTo(head2);
            
            int number1 = extractNumber(o1.substring(head1.length()));
            int number2 = extractNumber(o2.substring(head2.length()));
            return number1 - number2;
        });
        return files;
    }
    
    String extractHead(String file) {
        StringBuilder head = new StringBuilder();
        int i = 0;
        while (!Character.isDigit(file.charAt(i))) head.append(file.charAt(i++));
        return head.toString().toLowerCase();
    }
    
    int extractNumber(String file) {
        StringBuilder number = new StringBuilder();
        int i = 0;
        while (i < file.length() && Character.isDigit(file.charAt(i))) number.append(file.charAt(i++));
        return Integer.parseInt(number.toString());
    }
}