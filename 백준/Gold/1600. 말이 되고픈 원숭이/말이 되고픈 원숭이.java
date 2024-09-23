// BOJ 1600번 말이 되고픈 원숭이
// https://www.acmicpc.net/problem/1600

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int r;
		int c;
		int knightMoveCount;
		int time;

		Node(int r, int c, int knightMoveCount, int time) {
			this.r = r;
			this.c = c;
			this.knightMoveCount = knightMoveCount;
			this.time = time;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[] kdr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] kdc = { -2, -1, 1, 2, 2, 1, -1, -2 };

	static int K;
	static int H;
	static int W;
	static int[][] map;

	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];
		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < W; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int result = -1;

		visited = new boolean[H][W][K + 1];
		Queue<Node> queue = new LinkedList<>();
		visited[0][0][0] = true;
		queue.add(new Node(0, 0, 0, 0));

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			int r = curr.r;
			int c = curr.c;
			int knightMoveCount = curr.knightMoveCount;
			int time = curr.time;

			if (r == H - 1 && c == W - 1) {
				result = time;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
					continue;
				}

				if (map[nr][nc] == 1 || visited[nr][nc][knightMoveCount]) {
					continue;
				}

				visited[nr][nc][knightMoveCount] = true;
				queue.add(new Node(nr, nc, knightMoveCount, time + 1));
			}

			if (knightMoveCount == K) {
				continue;
			}

			for (int d = 0; d < 8; d++) {
				int nr = r + kdr[d];
				int nc = c + kdc[d];

				if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
					continue;
				}

				if (map[nr][nc] == 1 || visited[nr][nc][knightMoveCount + 1]) {
					continue;
				}

				visited[nr][nc][knightMoveCount + 1] = true;
				queue.add(new Node(nr, nc, knightMoveCount + 1, time + 1));
			}
		}

		// 결과 출력
		System.out.println(result);
	}
}
