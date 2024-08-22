// BOJ 20055번 컨베이어 벨트 위의 로봇
// https://www.acmicpc.net/problem/20055

import java.util.Scanner;

public class Main {
	static int N;
	static int K;

	static int[][] belt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		belt = new int[2 * N + 1][2];
		for (int i = 1; i <= 2 * N; i++) {
			belt[i][0] = sc.nextInt();
		}

		int time = 0;
		boolean flag = true;
		while (flag) {
			time++;
			rotate();
			move();
			addRobot();
			if (getCount() >= K) {
				flag = false;
			}
		}

		// 결과 출력
		System.out.println(time);
	}

	// 벨트 회전 메소드
	public static void rotate() {
		// 한칸씩 시계 방향으로 벨트 회전
		belt[0][0] = belt[2 * N][0];
		for (int i = 2 * N; i > 0; i--) {
			belt[i][0] = belt[i - 1][0];
			belt[i][1] = belt[i - 1][1];
		}

		// 회전 이후 N번 칸의 위치에 로봇이 있다면 로봇을 내림
		if (belt[N][1] == 1) {
			belt[N][1] = 0;
		}

	}

	// 로봇 이동 메소드
	public static void move() {
		// N - 1번째 칸부터 1번 칸까지 순서대로 확인
		// 해당 칸에 로봇이 있다면 다음칸의 내구도 확인 후 이동
		for (int i = N - 1; i > 1; i--) {
			if (belt[i][1] == 1 && belt[i + 1][0] > 0 && belt[i + 1][1] != 1) {
				belt[i][1] = 0;
				belt[i + 1][1] = 1;

				belt[i + 1][0]--;
			}
		}

		// 이동 이후 N번 칸의 위치에 로봇이 있다면 로봇을 내림
		if (belt[N][1] == 1) {
			belt[N][1] = 0;
		}
	}

	// 로봇을 올리는 메소드
	public static void addRobot() {
		if (belt[1][0] != 0) {
			belt[1][1] = 1;
			belt[1][0]--;
		}
	}

	// 내구도가 0인 칸의 개수 파악
	public static int getCount() {
		int count = 0;
		for (int i = 1; i <= 2 * N; i++) {
			if (belt[i][0] == 0) {
				count++;
			}
		}
		return count;
	}
}
