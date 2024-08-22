// BOJ 17142번 연구소 3
// https://www.acmicpc.net/problem/17142

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 상, 하, 좌, 우 탐색을 위한 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int[][] map;
	static int[][] visited;

	static int M;
	static List<int[]> virus;
	static boolean[] selected;

	static int minTime = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		virus = new ArrayList<int[]>();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt();
				if (map[r][c] == 2) {
					virus.add(new int[] { r, c });
				}
			}
		}

		selected = new boolean[virus.size()];
		getCombination(0, 0);

		// 결과 출력
		int result = (minTime != Integer.MAX_VALUE) ? minTime : -1;
		System.out.println(result);
	}

	// 조합
	public static void getCombination(int idx, int count) {
		if (count == M) {
			spread();
			return;
		}

		if (idx == virus.size()) {
			return;
		}

		selected[idx] = true;
		getCombination(idx + 1, count + 1);

		selected[idx] = false;
		getCombination(idx + 1, count);
	}

	// 바이러스가 퍼지는 시간 계산
	public static void spread() {
		visited = new int[N][N];
		bfs();

		int max = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] != 0) {
					continue;
				}

				if (visited[r][c] > max) {
					max = visited[r][c] - 1;
				} else if (visited[r][c] == 0) {
					return;
				}
			}
		}

		minTime = Math.min(minTime, max);
	}

	// bfs
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < selected.length; i++) {
			if (selected[i]) {
				queue.add(virus.get(i));
			    visited[virus.get(i)[0]][virus.get(i)[1]] = 1;
			}
		}

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (check(nr, nc) && visited[nr][nc] == 0 && map[nr][nc] != 1) {
					visited[nr][nc] = visited[r][c] + 1;
					queue.add(new int[] { nr, nc });
				}
			}
		}
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
