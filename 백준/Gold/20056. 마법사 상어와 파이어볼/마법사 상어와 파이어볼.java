// BOJ 20056번 마법사 상어와 파이어볼
// https://www.acmicpc.net/problem/20056

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	// 델타 배열
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	// 격자의 크기 N, 파이어볼의 개수 M, 이동 명령 횟수 K
	static int N;
	static int M;
	static int K;

	// 격자의 정보를 나타낼 배열 map
	// map[r][c][0] : 해당 좌표에 있는 파이어볼의 무게의 합
	// map[r][c][1] : 해당 좌표에 있는 파이어볼의 속력의 합
	// map[r][c][2] : 해당 좌표에 있는 파이어볼의 방향
	// map[r][c][3] : 해당 좌표에 있는 파이어볼의 개수
	static int[][][] map;

	// 파이어볼의 정보를 저장할 리스트
	static List<int[]> fireballs = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();

			fireballs.add(new int[] { r, c, m, s, d });
		}

		while (K-- > 0) {
			move();
		}

		// 결과 출력
		System.out.println(getMass());

	}

	// 파이어볼 이동 명령
	public static void move() {
		for (int i = 0; i < fireballs.size(); i++) {
			int r = fireballs.get(i)[0];
			int c = fireballs.get(i)[1];
			int m = fireballs.get(i)[2];
			int s = fireballs.get(i)[3];
			int d = fireballs.get(i)[4];

			int nr = nextr(r + dr[d] * s);
			int nc = nextc(c + dc[d] * s);

			fireballs.set(i, new int[] { nr, nc, m, s, d });
		}

		map = new int[N + 1][N + 1][4];

		for (int i = 0; i < fireballs.size(); i++) {
			int r = fireballs.get(i)[0];
			int c = fireballs.get(i)[1];
			int m = fireballs.get(i)[2];
			int s = fireballs.get(i)[3];
			int d = fireballs.get(i)[4];

			if (map[r][c][3] == 0) {
				map[r][c][0] = m;
				map[r][c][1] = s;
				map[r][c][3] = 1;

				map[r][c][2] = d;
			} else {
				map[r][c][0] += m;
				map[r][c][1] += s;
				map[r][c][3]++;

				if ((d % 2 == 1 && map[r][c][2] % 2 == 0) || (d % 2 == 0 && map[r][c][2] % 2 == 1)) {
					map[r][c][2] = -1;
				}
			}
		}

		fireballs = new ArrayList<>();
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (map[r][c][3] == 1) {
					int m = map[r][c][0];
					int s = map[r][c][1];
					int d = map[r][c][2];
					fireballs.add(new int[] { r, c, m, s, d });
				} else if (map[r][c][3] > 1) {
					int m = map[r][c][0] / 5;
					int s = map[r][c][1] / map[r][c][3];

					if (m == 0) {
						continue;
					}

					if (map[r][c][2] != -1) {
						fireballs.add(new int[] { r, c, m, s, 0 });
						fireballs.add(new int[] { r, c, m, s, 2 });
						fireballs.add(new int[] { r, c, m, s, 4 });
						fireballs.add(new int[] { r, c, m, s, 6 });
					} else {
						fireballs.add(new int[] { r, c, m, s, 1 });
						fireballs.add(new int[] { r, c, m, s, 3 });
						fireballs.add(new int[] { r, c, m, s, 5 });
						fireballs.add(new int[] { r, c, m, s, 7 });
					}
				}
			}
		}
	}

	// 1번 행과 N번 행 연결
	public static int nextr(int r) {
		while (r > N) {
			r -= N;
		}
		while (r < 1) {
			r += N;
		}
		return r;
	}

	// 1번 열과 N번 열 연결
	public static int nextc(int c) {
		while (c > N) {
			c -= N;
		}
		while (c < 1) {
			c += N;
		}
		return c;
	}

	// 남아있는 파이어볼의 질량의 합을 구하는 메소드
	public static int getMass() {
		int sum = 0;
		for (int i = 0; i < fireballs.size(); i++) {
			sum += fireballs.get(i)[2];
		}
		return sum;
	}
}
