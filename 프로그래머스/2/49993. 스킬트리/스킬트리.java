class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String regex = "[^" + skill + "]";
        for (String tree : skill_trees) {
            if (skill.startsWith(tree.replaceAll(regex, ""))) answer++;
        }
        return answer;
    }
}