// BOJ 17143번 낚시왕
// https://www.acmicpc.net/problem/17143

import java.util.Scanner;

public class Main {
	// 델타배열
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 1, -1 };

	// 격자판의 크기 height, width
	// 격자판의 정보를 입력할 배열 map
	static int height;
	static int width;
	static int[][] map;

	// 상어의 수 M
	// 상어의 정보를 나타낼 배열 sharks
	static int M;
	static int[][] sharks;

	// 낚시왕의 현재 위치 now
	// 낚시왕이 잡은 상어 크기의 합 sum
	static int now;
	static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		height = sc.nextInt();
		width = sc.nextInt();
		M = sc.nextInt();

		map = new int[height + 1][width + 1];
		sharks = new int[M + 1][5];

		for (int i = 1; i <= M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int speed = sc.nextInt();
			int direction = sc.nextInt();
			int size = sc.nextInt();

			sharks[i][0] = r;
			sharks[i][1] = c;
			sharks[i][2] = speed;
			sharks[i][3] = direction;
			sharks[i][4] = size;

			map[r][c] = i;
		}

		now = 0;
		while (now < width) {
			now++;
			fishing();
			move();
		}

		// 결과 출력
		System.out.println(sum);

	}

	// 낚시
	// 낚시왕이 있는 열에 있는 상어 중 땅과 제일 가까운 상어를 잡는다.
	public static void fishing() {
		for (int r = 1; r <= height; r++) {
			if (map[r][now] != 0) {
				int sharkNum = map[r][now];

				sum += sharks[sharkNum][4];
				map[r][now] = 0;

				sharks[sharkNum][4] = 0;
				return;
			}
		}
	}

	// 상어 이동 메소드
	public static void move() {
		map = new int[height + 1][width + 1];
		for (int i = 1; i <= M; i++) {
			if (sharks[i][4] != 0) {
				int r = sharks[i][0];
				int c = sharks[i][1];
				int speed = sharks[i][2];
				int direction = sharks[i][3];

				int[] next = next(r, c, direction, speed);
				int nr = next[0];
				int nc = next[1];
				direction = next[2];

				if (map[nr][nc] == 0) {
					sharks[i][0] = nr;
					sharks[i][1] = nc;
					sharks[i][3] = direction;

					map[nr][nc] = i;
				} else {
					if (sharks[map[nr][nc]][4] > sharks[i][4]) {
						sharks[i][4] = 0;
					} else {
						sharks[i][0] = nr;
						sharks[i][1] = nc;
						sharks[i][3] = direction;

						sharks[map[nr][nc]][4] = 0;

						map[nr][nc] = i;
					}
				}
			}
		}
	}

	// 상어의 이동 후 위치와 방향을 구하는 메소드
	public static int[] next(int r, int c, int d, int s) {
		int nr = r;
		int nc = c;

		// 상, 하 방향 이동
		if (d == 1 || d == 2) {
			for (int i = 0; i < s; i++) {
				nr += dr[d];
				if (nr < 1) {
					d = 2;
					nr += 2 * dr[d];
				}
				if (nr > height) {
					d = 1;
					nr += 2 * dr[d];
				}
			}
		}
		// 좌, 우 방향 이동
		if (d == 3 || d == 4) {
			for (int i = 0; i < s; i++) {
				nc += dc[d];
				if (nc < 1) {
					d = 3;
					nc += 2 * dc[d];
				}
				if (nc > width) {
					d = 4;
					nc += 2 * dc[d];
				}
			}
		}

		return new int[] { nr, nc, d };
	}

}
