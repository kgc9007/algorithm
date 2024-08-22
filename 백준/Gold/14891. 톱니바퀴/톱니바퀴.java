// BOJ 14891번 톱니바퀴

import java.util.Scanner;

public class Main {

	static int[][] wheel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 톱니바퀴 정보 입력
		wheel = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String line = sc.next();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = line.charAt(j) - '0';
			}
		}

		// 총 회전 횟수 K 입력
		int K = sc.nextInt();

		while (K-- > 0) {
			// 회전시킬 톱니바퀴의 번호 N, 방향 D 입
			int N = sc.nextInt();
			int D = sc.nextInt();

			// 회전시킬 톱니바퀴의 왼쪽 톱니바퀴 확인
			int leftCount = 0;
			for (int i = N - 1; i > 0; i--) {
				if (wheel[i][6] != wheel[i - 1][2]) {
					leftCount++;
				} else {
					break;
				}
			}
			// 회전시킬 톱니바퀴의 오른쪽 톱니바퀴 확인
			int rightCount = 0;
			for (int i = N - 1; i < 3; i++) {
				if (wheel[i][2] != wheel[i + 1][6]) {
					rightCount++;
				} else {
					break;
				}
			}

			// 지정 톱니바퀴 회전
			rotate(N, D);
			// 왼쪽 톱니바퀴 회전
			for (int i = 1; i <= leftCount; i++) {
				if (i % 2 == 0) {
					rotate(N - i, D);
				} else {
					rotate(N - i, -D);
				}
			}
			// 오른쪽 톱니바퀴 회전
			for (int i = 1; i <= rightCount; i++) {
				if (i % 2 == 0) {
					rotate(N + i, D);
				} else {
					rotate(N + i, -D);
				}
			}

		}

		// 점수 계산 후 결과 출력
		System.out.println(getScore());

	}

	// 톱니바퀴 회전 메소드
	public static void rotate(int N, int D) {
		// 반시계 방향 회전
		if (D == -1) {
			// wheel[][0]을 tmp로 저장
			// 0번 ~ 6번 인덱스까지 다음 인덱스의 값으로 교환
			// 7번 인덱스에 tmp 값 저장
			int tmp = wheel[N - 1][0];
			for (int i = 0; i < 7; i++) {
				wheel[N - 1][i] = wheel[N - 1][i + 1];
			}
			wheel[N - 1][7] = tmp;

		} else { // 시계 방향 입력
			// wheel[][7]을 tmp로 저장
			// 7번 ~ 1번 인덱스까지 다음 인덱스의 값으로 교환
			// 0번 인덱스에 tmp 값 저장
			int tmp = wheel[N - 1][7];
			for (int i = 7; i > 0; i--) {
				wheel[N - 1][i] = wheel[N - 1][i - 1];
			}
			wheel[N - 1][0] = tmp;

		}
	}

	// 점수 계산 메소드
	public static int getScore() {
		int score = 0;
		if (wheel[0][0] == 1) {
			score += 1;
		}
		if (wheel[1][0] == 1) {
			score += 2;
		}
		if (wheel[2][0] == 1) {
			score += 4;
		}
		if (wheel[3][0] == 1) {
			score += 8;
		}
		return score;
	}
}
