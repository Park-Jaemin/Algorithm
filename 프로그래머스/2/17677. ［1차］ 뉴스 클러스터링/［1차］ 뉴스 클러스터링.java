import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        final int MOD = 65536;
        List<String> list1 = makeList(str1.toLowerCase());
        List<String> list2 = makeList(str2.toLowerCase());

        double unionCount = list1.size() + list2.size();
        int intersectionCount = getIntersectionsCount(list1, list2);
        unionCount -= intersectionCount;

        return (int) unionCount == intersectionCount ? MOD : (int) Math.floor(intersectionCount / unionCount * MOD);
    }
    
    List<String> makeList(String str) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            String s = str.substring(i, i+2);
            if (s.matches("^[a-z]{2}")) list.add(s);
        }

        return list;
    }
    
    int getIntersectionsCount(List<String> list1, List<String> list2) {
        int count = 0;
        for (String str : list1) {
            if (list2.remove(str)) {
                count++;
            }
        }
        return count;
    }
}