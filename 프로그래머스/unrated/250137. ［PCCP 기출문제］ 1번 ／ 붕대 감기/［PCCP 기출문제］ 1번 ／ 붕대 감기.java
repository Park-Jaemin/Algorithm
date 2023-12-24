class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int maxTime = attacks[attacks.length-1][0];
        int time = 1;
        int index = 0;
        int bandageTime = 0;
        
        while (time <= maxTime) {
            if (time == attacks[index][0]) { // 현재 시간이랑 공격 시간이랑 동일 시
                health -= attacks[index][1];
                index++;
                bandageTime = 0;
                
                if (health <= 0) return -1;
            } else {
                bandageTime++;
                health += bandage[1];
                if (bandageTime == bandage[0]) { // 붕대 감은 시간이랑 시전 시간 동일
                    health += bandage[2];
                    bandageTime = 0;
                }
                health = Math.min(health, maxHealth);
            }
            
            time++;
        }
        
        return health;
    }
}

// 최대 체력 = health
// bondage [0] = 시전 시간, [1] = 초당 회복량, [2] = 추가 회복량(시전 시간 다 채울시)
// attack [0] = 공격 시간, [1] = 데미지

