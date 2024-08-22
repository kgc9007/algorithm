// BOJ 11559번 Puyo Puyo
// https://www.acmicpc.net/problem/11559

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 델타 배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N = 12;
	static int M = 6;
	static char[][] map = new char[N][M];

	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int r = 0; r < N; r++) {
			String line = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = line.charAt(c);
			}
		}

		boolean isEnd = false;
		int time = -1;
		while (!isEnd) {
			time++;
			visited = new boolean[N][M];
			isEnd = true;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c] != '.' && !visited[r][c]) {
						boolean exploded = bfs(r, c, map[r][c]);

						if (exploded) {
							isEnd = false;
						}
					}
				}
			}
			move();
		}

		// 결과 출력
		System.out.println(time);

	}

	// bfs
	public static boolean bfs(int startr, int startc, char color) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { startr, startc });

		List<int[]> list = new ArrayList<>();
		int count = 0;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			int r = curr[0];
			int c = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (check(nr, nc) && !visited[nr][nc] && map[nr][nc] == color) {
					count++;
					visited[nr][nc] = true;
					list.add(new int[] { nr, nc });

					queue.add(new int[] { nr, nc });
				}
			}
		}

		// 4개 이상 연결되지 않았다면
		// 1. 변화 X
		// 2. false 반환
		if (count < 4) {
			return false;
		}

		// 4개 이상 연결되어 있다면
		// 1. 뿌요들이 터지고 -> map 배열 변경
		// 2. true 반환
		for (int i = 0; i < list.size(); i++) {
			map[list.get(i)[0]][list.get(i)[1]] = '.';
		}
		return true;
	}

	// 뿌요들이 터진 후 남은 뿌요들이 이동하는 메소드
	public static void move() {
		for (int c = 0; c < M; c++) {
			List<Character> list = new ArrayList<>();
			for (int r = N - 1; r >= 0; r--) {
				if (map[r][c] != '.') {
					list.add(map[r][c]);
				}
			}

			int idx = N - 1;
			for (int i = 0; i < list.size(); i++) {
				map[idx--][c] = list.get(i);
			}
			for (int i = list.size(); i < N; i++) {
				map[idx--][c] = '.';
			}
		}
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
