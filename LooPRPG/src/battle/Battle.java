package battle;

import charactor.Player;
import charactor.Monster;
import java.util.Random;

public class Battle {
    private Player player;
    private Monster monster;
    private Random random;
    private boolean isPlayerWin; // 승리 여부 저장

    public Battle(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;
        this.random = new Random();
    }

    // 싸움 진행 메서드
    public Player battle() {
        boolean playerTurn = false; // 플레이어 턴 여부

        while (player.getHp() > 0 && monster.getHp() > 0 && !isPlayerWin) { // 둘 중 하나의 HP가 0이 되거나 승리 조건이 만족되면 반복 종료
            if (playerTurn) {
                // 플레이어 턴일 때 몬스터 공격
                int damage = player.getAd();
                if (random.nextInt(100) < 10) { // 10% 확률로 치명타 발생
                    damage = (int) (damage * 1.2); // 20% 추가 데미지
                    int monsterHp = monster.hit(damage); // 몬스터에게 데미지 입히고 남은 HP 저장
                    System.out.println(player.name + "의 치명타 공격! " + damage + "만큼의 데미지를 입혔습니다! (" + monster.name + "의 남은 체력: " + monsterHp + ")");
                    if (monsterHp <= 0) { // 몬스터 HP가 0 이하면 플레이어 승리
                        isPlayerWin = true;
                    }
                } else {
                    int monsterHp = monster.hit(damage); // 몬스터에게 데미지 입히고 남은 HP 저장
                    System.out.println(player.name + "의 공격! " + damage + "만큼의 데미지를 입혔습니다! (" + monster.name + "의 남은 체력: " + monsterHp + ")");
                    if (monsterHp <= 0) { // 몬스터 HP가 0 이하면 플레이어 승리
                        isPlayerWin = true;
                    }
                }
                playerTurn = false; // 몬스터 턴으로 변경
            } else {
                // 몬스터 턴일 때 플레이어 공격
                int damage = monster.getAd();
                if (random.nextInt(100) < 10) { // 10% 확률로 치명타 발생
                    damage = (int) (damage * 1.2); // 20% 추가 데미지
                    int playerHp = player.hit(damage); // 플레이어에게 데미지 입히고 남은 HP 저장
                    System.out.println(monster.name + "의 치명타 공격! " + damage + "만큼의 데미지를 입혔습니다! (" + player.name + "의 남은 체력: " + playerHp + ")");
                    if (playerHp <= 0) { // 플레이어 HP가 0 이하면 몬스터 승리
                        isPlayerWin = false;
                    }
                } else {
                    int playerHp = player.hit(damage); // 플레이어에게 데미지 입히고 남은 HP 저장
                    System.out.println(monster.name + "의 공격! " + damage + "만큼의 데미지를 입혔습니다! (" + player.name + "의 남은 체력: " + playerHp + ")");
                    if (playerHp <= 0) { // 플레이어 HP가 0 이하면 몬스터 승리
                        isPlayerWin = false;
                    }
                }
                playerTurn = true; // 플레이어 턴으로 변경
            }
        }

        // 배틀 이후 결과 값 반환
        return player;
    }
}