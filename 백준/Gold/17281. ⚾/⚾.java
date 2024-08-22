// BOJ 17281번 ⚾
// https://www.acmicpc.net/problem/17281

import java.util.Scanner;

public class Main {
	// 전체 이닝 수 N
	static int N;

	// 이닝 별 각 선수가 얻는 결과 result
	// result[i][j] = i 이닝에 j 선수가 얻는 결과
	static int[][] result;

	// 타순
	static int[] order;
	static boolean[] visited;

	// 현재 상태
	static boolean[] base;
	static int outCount;
	static int nowHitterNumber;

	// 얻을 수 있는 최대 점수
	static int maxScore = 0;

	static int score;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		result = new int[N + 1][10];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 9; j++) {
				result[i][j] = sc.nextInt();
			}
		}

		// 타순 초기화
		order = new int[10];
		visited = new boolean[10];

		// 순열 생성(최대 점수 계산)
		getPermutation(1);

		// 결과 출력
		System.out.println(maxScore);
	}

	// 순열
	public static void getPermutation(int idx) {
		// 타순이 결정되면 해당 타순으로 게임 진행
		if (idx == 10) {
			play();
			return;
		}

		// 1번 선수는 4번 타자 고정
		if (idx == 4) {
			order[idx] = 1;
			getPermutation(idx + 1);
		} else {
			for (int i = 2; i <= 9; i++) {
				if (visited[i]) {
					continue;
				}
				visited[i] = true;
				order[idx] = i;
				getPermutation(idx + 1);
				visited[i] = false;
			}
		}

	}

	// 구해진 타순대로 경기를 진행하고 점수를 반환하는 메소드
	public static void play() {
		score = 0;
		nowHitterNumber = 1;

		for (int inning = 1; inning <= N; inning++) {
			base = new boolean[4];
			outCount = 0;
			while (outCount < 3) {
				int no = result[inning][order[nowHitterNumber]];
				hit(no);
			}
		}

		maxScore = Math.max(score, maxScore);
	}

	public static void hit(int no) {
		switch (no) {
		case 0:
			out();
			break;
		case 1:
			hitSingle();
			break;
		case 2:
			hitDouble();
			break;
		case 3:
			hitTriple();
			break;
		case 4:
			homerun();
			break;
		default:
			break;
		}

		nowHitterNumber++;
		if (nowHitterNumber == 10) {
			nowHitterNumber = 1;
		}
	}

	// 안타!
	public static void hitSingle() {
		if (base[3]) {
			score++;
			base[3] = false;
		}
		if (base[2]) {
			base[3] = true;
			base[2] = false;
		}
		if (base[1]) {
			base[2] = true;
			base[1] = false;
		}
		base[1] = true;
	}

	// 2루타!
	public static void hitDouble() {
		if (base[3]) {
			score++;
			base[3] = false;
		}
		if (base[2]) {
			score++;
			base[2] = false;
		}
		if (base[1]) {
			base[3] = true;
			base[1] = false;
		}
		base[2] = true;
	}

	// 3루타!
	public static void hitTriple() {
		if (base[3]) {
			score++;
			base[3] = false;
		}
		if (base[2]) {
			score++;
			base[2] = false;
		}
		if (base[1]) {
			score++;
			base[1] = false;
		}
		base[3] = true;
	}

	// 홈런!
	public static void homerun() {
		for (int i = 1; i < 4; i++) {
			if (base[i]) {
				score++;
			}
		}
		score++;
		base = new boolean[4];
	}

	// 아웃
	public static void out() {
		outCount++;
	}

}
