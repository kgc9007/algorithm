// BOJ 14940번 쉬운 최단거리

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 사방탐색을 위한 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int N;
	static int M;
	static int[][] map;

	// bfs를 위한 Queue
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == 2) {
					queue.add(new int[] { r, c });
				}
			}
		}

		bfs();

		// 결과 출력
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					sb.append(0 + " ");
				} else {
					sb.append(map[r][c] - 2 + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	// bfs
	// 배열 dist에 거리 입력
	public static void bfs() {
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int r = tmp[0];
			int c = tmp[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (check(nr, nc) && map[nr][nc] == 1) {
					map[nr][nc] = map[r][c] + 1;
					queue.add(new int[] { nr, nc });
				}
			}
		}
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
