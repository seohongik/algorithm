package programus;

public class MonsterAttackBandageHeal {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int lastAttackTime  = attacks[attacks.length-1][0];
        User user = new User(health,bandage[0], bandage[1] , bandage[2]);
        int[][] allAttacks = new int[lastAttackTime+1][2];
        for (int i=0; i<allAttacks.length; i++) {
            for (int j=0; j< attacks.length; j++) {
                if(i==attacks[j][0]){
                    allAttacks[i] = attacks[j];
                }
            }
        }
        for (int i=0; i<allAttacks.length; i++) {
            if(user.currentHealth<=0){
                break;
            }
            user.play(i,allAttacks[i][0], allAttacks[i][1]);
        }

        if(user.currentHealth>0){
            return user.currentHealth;
        }else {
            return -1;
        }
    }

    public static class User {

        final int healAmount;
        final int maxHealth;
        final int maxChainHealingCount;
        final int additionalHealAmount;
        int isChainHealingCount;
        int currentHealth;


        public User(int health,int maxChainHealingCount,  int healAmount, int additionalHealAmount) {
            this.maxChainHealingCount = maxChainHealingCount;
            this.maxHealth = health;
            this.additionalHealAmount = additionalHealAmount;
            this.healAmount = healAmount;
            this.currentHealth = maxHealth;
        }

        public void play(int time , int attackTime, int attackDamage) {
            currentHealth-=attackDamage;

            if(attackTime!=time){
                currentHealth+=healAmount;
                isChainHealingCount++;
            }else {
                isChainHealingCount=0;
            }
            if(isChainHealingCount>=maxChainHealingCount){
                currentHealth += (additionalHealAmount);
                isChainHealingCount=0;
            }

            if(currentHealth>=maxHealth){
                currentHealth = maxHealth;
            }
        }

        @Override
        public String toString() {
            return "User{" +
                    "healAmount=" + healAmount +
                    ", maxHealth=" + maxHealth +
                    ", maxChainHealingCount=" + maxChainHealingCount +
                    ", additionalHealAmount=" + additionalHealAmount +
                    ", isChainHealingCount=" + isChainHealingCount +
                    ", currentHealth=" + currentHealth +
                    '}';
        }
    }
}

