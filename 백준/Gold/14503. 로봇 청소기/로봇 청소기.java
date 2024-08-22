// BOJ 14503번 로봇 청소기

import java.util.Scanner;

public class Main {
	// 탐색, 이동을 위한 델타 배열
	// 상, 우, 하, 좌 (북, 동, 남, 서) 순
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int M;

	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 방의 크기 N, M 입력
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];

		// 로봇 청소기의 현재 위치와 현재 바라보고 있는 방향 D 입력
		int initR = sc.nextInt();
		int initC = sc.nextInt();
		int D = sc.nextInt();

		// 방의 상태 입력
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}

		// 작동 시작
		count = 0;
		solve(initR, initC, D);

		// 결과 출력
		System.out.println(count);

	}

	// 작동
	public static void solve(int r, int c, int d) {
		// 해당 칸이 아직 청소되지 않은 빈 칸 인 경우
		// 현재 칸 청소
		if (map[r][c] == 0 && !visited[r][c]) {
			count++;
			visited[r][c] = true;
		}

		// 주변 4칸에 청소되지 않은 빈 칸이 있는 경우
		// 반시계 방향으로 90도씩 회전하며
		// 청소되지 않은 빈 칸이 있으면 해당 방향을 바라보고 한 칸 이동
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int nextR = r + dr[d];
			int nextC = c + dc[d];
			if (check(nextR, nextC) && map[nextR][nextC] == 0 && !visited[nextR][nextC]) {
				solve(nextR, nextC, d);
				return;
			}
		}

		// 주변 4칸에 청소되지 않은 빈 칸이 없는 경우
		// 한 칸 후진
		int nextR = r - dr[d];
		int nextC = c - dc[d];

		if (check(nextR, nextC) && map[nextR][nextC] == 0) {
			solve(nextR, nextC, d);
			return;
		}

		// 벽에 막혀서 후진할 수 없다면 작동 중지
		if (check(nextR, nextC) && map[nextR][nextC] == 1) {
			return;
		}

	}

	// 경계 안에 있는지 확인
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
