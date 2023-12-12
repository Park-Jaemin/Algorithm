import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
//         Set<String> set = new HashSet<>();
        
//         for (int i = 0; i < phone_book.length; i++) {
//             String number = phone_book[i];
            
//             if (i == 0) {
//                 set.add(number);
//                 continue;
//             }
            
//             for (int j = 0; j < number.length(); j++) {
//                 if (set.contains(number.substring(0, j))) return false;
//             }
//             set.add(number);
//         }
        
//         return true;
        
        Map<String, Integer> map = new HashMap<>();

        // 모든 phone 번호 hashMap에 담기
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            // 전화번호의 길이만큼 순회
            for (int j = 0; j < phone_book[i].length(); j++) {
                // 해당 전화번호의 접두어가 key로 가진 경우
                if (map.containsKey(phone_book[i].substring(0,j))) {
                    return false;
                }
            }
        }

        return true;
    }
}