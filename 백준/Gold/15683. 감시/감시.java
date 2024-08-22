// BOJ 15683번 감시
// https://www.acmicpc.net/problem/15683

import java.util.Scanner;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int M;
	static int[][] maps;

	static boolean[][] visited;

	static int[][] cctv;

	static int[] directions;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		int totalCamera = 0;
		maps = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				maps[r][c] = sc.nextInt();
				if (maps[r][c] >= 1 && maps[r][c] < 6) {
					totalCamera++;
				}
			}
		}

		cctv = new int[totalCamera][3];
		int idx = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (maps[r][c] >= 1 && maps[r][c] < 6) {
					cctv[idx][0] = r;
					cctv[idx][1] = c;
					cctv[idx][2] = maps[r][c];
					idx++;
				}
			}
		}

		directions = new int[totalCamera];
		getPermutation(0);

		// 결과 출력
		System.out.println(min);

	}

	// 순열 계산 메소드
	// - 순열을 완성한 후 사각지대의 최소 크기 계산
	public static void getPermutation(int idx) {
		if (idx == directions.length) {
			int blindSpotSize = getBlindSpotSize();

			min = Math.min(min, blindSpotSize);
			return;
		}

		if (cctv[idx][2] == 1) { // 1번 CCTV인 경우
			for (int i = 1; i <= 4; i++) { // 1 : 상, 2 : 하, 3 : 좌, 4 : 우
				directions[idx] = i;
				getPermutation(idx + 1);
			}
		} else if (cctv[idx][2] == 2) { // 2번 CCTV인 경우
			for (int i = 1; i <= 2; i++) { // 1 : 상하, 2 : 좌우
				directions[idx] = i;
				getPermutation(idx + 1);
			}
		} else if (cctv[idx][2] == 3) { // 3번 CCTV인 경우
			for (int i = 1; i <= 4; i++) { // 1 : 상우, 2 : 우하, 3 : 하좌, 4 : 좌상
				directions[idx] = i;
				getPermutation(idx + 1);
			}
		} else if (cctv[idx][2] == 4) { // 4번 CCTV인 경우
			for (int i = 1; i <= 4; i++) { // 1 : 상좌우, 2 : 상하우, 3 : 하좌우, 4 : 상하좌
				directions[idx] = i;
				getPermutation(idx + 1);
			}
		} else {
			directions[idx] = 1;
			getPermutation(idx + 1);
		}
	}

	// 사각지대의 크기 계산 메소드
	// - 각 CCTV의 방향을 정한 후 사각지대 크기 계산
	public static int getBlindSpotSize() {
		visited = new boolean[N][M];

		for (int i = 0; i < directions.length; i++) {
			int r = cctv[i][0];
			int c = cctv[i][1];

			if (cctv[i][2] == 1) {
				check(directions[i], r, c);
			} else if (cctv[i][2] == 2) {
				if (directions[i] == 1) {
					check(1, r, c);
					check(2, r, c);
				} else {
					check(3, r, c);
					check(4, r, c);
				}
			} else if (cctv[i][2] == 3) {
				if (directions[i] == 1) {
					check(1, r, c);
					check(4, r, c);
				} else if (directions[i] == 2) {
					check(2, r, c);
					check(4, r, c);
				} else if (directions[i] == 3) {
					check(2, r, c);
					check(3, r, c);
				} else {
					check(1, r, c);
					check(3, r, c);
				}
			} else if (cctv[i][2] == 4) {
				if (directions[i] == 1) {
					check(1, r, c);
					check(3, r, c);
					check(4, r, c);
				} else if (directions[i] == 2) {
					check(1, r, c);
					check(2, r, c);
					check(4, r, c);
				} else if (directions[i] == 3) {
					check(2, r, c);
					check(3, r, c);
					check(4, r, c);
				} else {
					check(1, r, c);
					check(2, r, c);
					check(3, r, c);
				}
			} else {
				check(1, r, c);
				check(2, r, c);
				check(3, r, c);
				check(4, r, c);
			}
		}

		int count = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (maps[r][c] == 0 && !visited[r][c]) {
					count++;
				}
			}
		}

		return count;
	}

	// CCTV의 방향에 맞게 CCTV가 감시하고 있는 구역 체크
	public static void check(int direction, int r, int c) {
		int d = direction - 1;
		int nr = r + dr[d];
		int nc = c + dc[d];

		while (!isOut(nr, nc) && maps[nr][nc] != 6) {
			visited[nr][nc] = true;

			nr += dr[d];
			nc += dc[d];
		}
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean isOut(int r, int c) {
		return r < 0 || r >= N || c < 0 || c >= M;
	}
}
