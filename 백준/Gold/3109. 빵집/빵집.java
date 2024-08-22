// BOJ 3109번 빵집
// https://www.acmicpc.net/problem/3109

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 0, 1 };

	static int N;
	static int M;
	static char[][] map;

	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int r = 0; r < N; r++) {
			String str = br.readLine();

			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		int count = 0;
		visited = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			if (dfs(new int[] { r, 0 })) {
				count++;
			}
		}

		// 결과 출력
		System.out.println(count);
	}

	// dfs
	public static boolean dfs(int[] curr) {
		visited[curr[0]][curr[1]] = true;
		if (curr[1] == M - 1) {
			return true;
		}

		for (int d = 0; d < 3; d++) {
			int nr = curr[0] + dr[d];
			int nc = curr[1] + 1;

			if (nr < 0 || nr >= N) {
				continue;
			}

			if (map[nr][nc] == '.' && !visited[nr][nc] && dfs(new int[] { nr, nc })) {
				return true;
			}
		}

		return false;
	}
}
