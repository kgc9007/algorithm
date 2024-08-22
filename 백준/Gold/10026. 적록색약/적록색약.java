// BOj 10026번 적록색약

import java.util.Scanner;

public class Main {
	// 사방탐색을 위한 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	// 그림의 크기 N, 그림의 각 그리드의 색을 저장할 배열 map
	static int N;
	static char[][] map;

	// dfs를 위한 방문배열
	static boolean[][] visited;

	// 적록색약이 아닌 사람이 봤을때 구역의 수 countNormal
	// 적록색약인 사람이 봤을때 구역의 수 countBlind
	static int countNormal;
	static int countBlind;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 그림의 크기 N 입력 후 map 배열 초기화
		N = sc.nextInt();
		map = new char[N][N];

		// 정보 입력
		for (int r = 0; r < N; r++) {
			String line = sc.next();
			for (int c = 0; c < N; c++) {
				map[r][c] = line.charAt(c);
			}
		}

		// visited 초기화 후
		// 적록색약이 아닌 사람이 봤을 때의 구역의 수 계산
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) {
					countNormal++;
					dfsNormal(r, c, map[r][c]);
				}
			}
		}

		// visited 초기화 후
		// 적록색약인 사람이 봤을 때의 구역의 수 계산
		visited = new boolean[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!visited[r][c]) {
					countBlind++;
					dfsBlind(r, c, isBlue(map[r][c]));
				}
			}
		}
		
		// 결과 출력
		System.out.printf("%d %d", countNormal, countBlind);
	}

	// dfs
	// - 적록색약이 아닌 사람이 보는 경우
	public static void dfsNormal(int r, int c, char color) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc) && !visited[nr][nc] && map[nr][nc] == color) {
				visited[nr][nc] = true;
				dfsNormal(nr, nc, color);
			}
		}
	}

	// dfs
	// - 적록색약인 사람이 보는 경우
	public static void dfsBlind(int r, int c, boolean isBlue) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc) && !visited[nr][nc] && isBlue(map[nr][nc]) == isBlue) {
				visited[nr][nc] = true;
				dfsBlind(nr, nc, isBlue);
			}
		}
	}

	// 적록색약인 경우 빨강-초록 구분 X
	// -> 파란색인지 아닌지 확인하는 메소드
	public static boolean isBlue(char color) {
		return color == 'B';
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
