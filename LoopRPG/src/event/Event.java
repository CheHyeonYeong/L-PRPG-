package event;

import battle.Battle;
import charactor.Monster;
import charactor.Player;

import java.util.Random;

public class Event {

    Player player;
    Monster monster = new Monster("몹");
    private Random randomEvent = new Random();
    // 승리 여부 판별하는 flag
    public boolean win = false;

    public Event(Player player) {
        this.player = player;
    }
    
    //main에서 불러올 중심 이벤트
    public void moveingEvent() {
        int event = randomEvent.nextInt(2);
        switch (event) {
            case 1:
                battleEvent();
                break;
            case 2:
                recover();
                break;
            default:
                break;
        }

    }
    //main에서 불러올 승리 여부 판별
    public boolean getWin() {
        return win;
    }

    private void monsterGrow() {
        //다음 몬스터의 레벨 증가
        monster.hp += 10;
        monster.ad += 10;
    }
    void recover() {
        // HP_MAX 값으로 바꾼 후 반환,
        player.hp = player.MAX_HP;
        player.ad /= 2; // 배틀 1회 이후, 공격력 원상 복귀.
        System.out.println("플레이어의 체력이 회복되었습니다.");
        monsterGrow();
    }
    void doubleOffensePower() {
        // 공격력 두배
        player.ad *= 2;
        System.out.println("플레이어의 공격력이 두 배로 증가했습니다! 현재 공격력은 "+player.getAd()+"입니다");
    }
    boolean battleEvent() {
        Battle battleEvent = new Battle(player, monster);
        player = battleEvent.battle();
        if ( player.getHp() > 0) {
            win = true;
            System.out.println("승리하셨습니다");
            recover();
            eventBox();
        } else {
            win = false;
            System.out.println("패배하셨습니다");
            System.out.println("게임을 종료합니다.");
        }
        return player.getHp() > 0; // 플레이어 승리 여부 반환
    }

    public void eventBox() {
        int event = randomEvent.nextInt(3);
        switch (event) {
            case 1:
                recover(); // 회복 이벤트
                break;
            case 2:
                doubleOffensePower(); // 공격력 두배
                break;
            default:
                System.out.println("(ฅ^•ﻌ•^)ฅ♡ 귀여운 토끼 이모티콘을 드려요! ♡(ˆ⌣ˆԅ)"); // 꽝
                break;
        }
    }
}
