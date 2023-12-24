class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int maxHealth = health;
        int beforeAttackTime = 0;
        int bandageTime = 0;
        
        for (int[] attack : attacks) {
            bandageTime = attack[0] - beforeAttackTime - 1;
            health = Math.min(maxHealth, health + 
                             bandageTime * bandage[1] +
                             bandageTime / bandage[0] * bandage[2]);
            
            health -= attack[1];
            beforeAttackTime = attack[0];
            if (health <= 0) return -1;
        }
        
        return health;
    }
}
