// BOJ 16949번 벽 부수고 이동하기 4
// https://www.acmicpc.net/problem/16946

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N;
	static int M;
	static int[][] map;

	static boolean[][] visited;

	static int[][] result;
	static Map<Integer, Integer> idxCountMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();

			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}

		visited = new boolean[N][M];
		result = new int[N][M];
		int idx = 1;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0 && !visited[r][c]) {
					bfs(new int[] { r, c }, idx++);
				}
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					sb.append(0);
				} else {
					int count = 1;

					Set<Integer> set = new HashSet<>();

					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
							continue;
						}

						if (map[nr][nc] == 0) {
							set.add(result[nr][nc]);
						}
					}

					for (Integer id : set) {
						count += idxCountMap.get(id);
					}

					sb.append(count % 10);
				}
			}
			sb.append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

	// [BFS]
	public static void bfs(int[] start, int idx) {
		Queue<int[]> queue1 = new LinkedList<>();
		Queue<int[]> queue2 = new LinkedList<>();
		int count = 0;

		visited[start[0]][start[1]] = true;
		queue1.add(start);
		queue2.add(start);

		while (!queue1.isEmpty()) {
			int[] curr = queue1.poll();
			count++;

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
					continue;
				}

				if (map[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue1.add(new int[] { nr, nc });
					queue2.add(new int[] { nr, nc });
				}
			}
		}

		while (!queue2.isEmpty()) {
			int[] curr = queue2.poll();

			result[curr[0]][curr[1]] = idx;
		}

		idxCountMap.put(idx, count);
	}
}