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
        boolean isPlayerTurn = random.nextBoolean(); // 누가 먼저 공격할지 랜덤으로 결정
        System.out.println("battle 호출");
        while (player.getHp() > 0 & monster.getHp() > 0) { // 둘 중 하나의 HP가 0이 되면 반복 종료
            System.out.println("battle While");
            if (isPlayerTurn) {
                // 플레이어 턴일 때 몬스터 공격
                int damage = player.getAd();
                if (random.nextInt(100) < 10) { // 10% 확률로 치명타 발생
                    damage = (int) (damage * 1.2); // 20% 추가 데미지
                    int monsterHp = monster.hit(damage); // 몬스터에게 데미지 입히고 남은 HP 저장
                    System.out.println(player.name + "의 치명타 공격! " + damage + "만큼의 데미지를 입혔습니다! (" + monster.name + "의 남은 체력: " + monsterHp + ")");
                } else {
                    int monsterHp = monster.hit(damage); // 몬스터에게 데미지 입히고 남은 HP 저장
                    System.out.println(player.name + "의 공격! " + damage + "만큼의 데미지를 입혔습니다! (" + monster.name + "의 남은 체력: " + monsterHp + ")");
                }
                isPlayerTurn = false; // 몬스터 턴으로 변경
            } else {
                // 몬스터 턴일 때 플레이어 공격
                int damage = monster.getAd();
                if (random.nextInt(100) < 10) { // 10% 확률로 치명타 발생
                    damage = (int) (damage * 1.2); // 20% 추가 데미지
                    int playerHp = player.hit(damage); // 플레이어에게 데미지 입히고 남은 HP 저장
                    System.out.println(monster.name + "의 치명타 공격! " + damage + "만큼의 데미지를 입혔습니다! (" + player.name + "의 남은 체력: " + playerHp + ")");
                } else {
                    int playerHp = player.hit(damage); // 플레이어에게 데미지 입히고 남은 HP 저장
                    System.out.println(monster.name + "의 공격! " + damage + "만큼의 데미지를 입혔습니다! (" + player.name + "의 남은 체력: " + playerHp + ")");
                }
                isPlayerTurn = true; // 플레이어 턴으로 변경
            }
        }

        // 배틀 이후 결과 값 반환
        if (player.getHp() > 0) {
            System.out.println("승리하셨습니다");
            // 승리 시 보상 처리 로직 추가
        } else {
            System.out.println("패배하셨습니다");
            // 패배 시 처리 로직 추가
        }
        return player;
    }
}
