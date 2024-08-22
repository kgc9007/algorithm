// BOJ 17144번 미세먼지 안녕!

import java.util.Scanner;

public class Main {
	// 사방탐색을 위한 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	// 방의 크기 R * C, T 초 후 상태 확인
	static int R;
	static int C;
	static int T;
	static int[][] room;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 방의 크기 R, C 와 시간 T 입력
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();

		// 방의 정보 입력
		room = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				room[r][c] = sc.nextInt();
			}
		}

		int upperR = 0;
		int lowerR = 0;
		for (int r = 0; r < R; r++) {
			if (room[r][0] == -1) {
				upperR = r;
				lowerR = r + 1;
				break;
			}
		}

		// T초동안 미세먼지 확산, 공기청정기 동작
		while (T-- > 0) {
			spread();
			cleanUpper(upperR);
			cleanLower(lowerR);
		}

		// 남아있는 미세먼지 양 확인
		int remainDust = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (room[r][c] > 0) {
					remainDust += room[r][c];
				}
			}
		}

		// 결과 출력
		System.out.println(remainDust);

	}

	// 1. 미세먼지 확산 메소드
	public static void spread() {
		// 미세먼지가 확산되는 양을 표시할 배열 change
		int[][] change = new int[R][C];

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				// 해당 위치에 미세먼지가 있다면
				if (room[r][c] > 0) {
					int dust = room[r][c]; // 미세먼지의 양
					int dustOfSpread = dust / 5; // 확산되는 미세먼지의 양
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (check(nr, nc) && room[nr][nc] != -1) {
							change[nr][nc] += dustOfSpread;
							change[r][c] -= dustOfSpread;
						}
					}
				}
			}
		}

		// 미세먼지 확산
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				room[r][c] += change[r][c];
			}
		}
	}

	// 2. 공기청정기 작동 메소드
	// 2-1. 반시계 방향(윗부분)
	public static void cleanUpper(int upperR) {
		// 반시계 방향 바람
		int[] windr = { -1, 0, 1, 0 };
		int[] windc = { 0, 1, 0, -1 };

		int nr = upperR - 1;
		int nc = 0;

		int d = 0;
		while (!(nr == upperR && nc == 1)) {
			int prevR = nr;
			int prevC = nc;
			nr += windr[d];
			nc += windc[d];
			if (nr < 0 || nr > upperR || nc < 0 || nc >= C) {
				nr = prevR;
				nc = prevC;
				d++;
				nr += windr[d];
				nc += windc[d];
			}
			room[prevR][prevC] = room[nr][nc];
		}
		room[upperR][1] = 0;
	}

	// 2-2. 시계 방향(아랫부분)
	public static void cleanLower(int lowerR) {
		// 반시계 방향 바람
		int[] windr = { 1, 0, -1, 0 };
		int[] windc = { 0, 1, 0, -1 };

		int nr = lowerR + 1;
		int nc = 0;

		int d = 0;
		while (!(nr == lowerR && nc == 1)) {
			int prevR = nr;
			int prevC = nc;
			nr += windr[d];
			nc += windc[d];
			if (nr < lowerR || nr >= R || nc < 0 || nc >= C) {
				nr = prevR;
				nc = prevC;
				d++;
				nr += windr[d];
				nc += windc[d];
			}
			room[prevR][prevC] = room[nr][nc];
		}
		room[lowerR][1] = 0;
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
