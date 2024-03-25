import charactor.Player;
import event.Event;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("게임을 시작합니다.");
		System.out.print("플레이어 이름을 입력하세요: ");

		// 사용자로부터 이름을 입력받아 문자열 변수에 저장합니다.
		String playerName = scanner.nextLine();

		// 입력받은 이름으로 Player 객체를 생성합니다.
		Player player = new Player(playerName);
		// 생성한 Player 객체를 이용하여 Event 객체를 생성합니다.
		Event event = new Event(player);

		// 게임이 끝났는지 여부를 판단하기 위한 변수를 선언하고, 초기값은 false로 설정합니다.
		boolean gameOver = false;

		// gameOver가 true가 될 때까지 게임을 계속 진행합니다
		while (!gameOver) {

			// 이동 이벤트를 처리합니다.
			event.moveingEvent();

			// 이벤트 결과에 따라 승리했는지 확인합니다.
			if (event.getWin()) {
				System.out.println("플레이어 " + player.name + "의 남은 체력: " + player.getHp());
				System.out.print("계속 진행하시겠습니까? (y/n): ");
				String choice = scanner.nextLine();

				// 사용자 입력을 확인하여 계속 진행 또는 게임 종료를 결정합니다.
				if (choice.equalsIgnoreCase("y") || choice.equals("ㅛ")) {
					System.out.println("다음 맵으로 이동합니다.");
				} else if (choice.equalsIgnoreCase("n") || choice.equals("ㅜ")) {
					System.out.println("게임을 종료합니다.");
					gameOver = true;
				}
			} else {
				System.out.println("전투에서 패배하셨습니다.");
				gameOver = true;
			}
		}
		scanner.close();
	}
}
