// BOJ 2667번 단지번호붙이기

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	// 사방탐색을 위한 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	// 지도 정보 map, 크기 N
	// DFS를 위한 방문 정보 visited
	static int[][] map;
	static int N;

	// 단지별 수를 저장할 리스트
	// 각 단지별 집의 수 count와 총 단지 수 totalCount
	static List<Integer> list = new ArrayList<>();
	static int count;
	static int totalCount = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		// map, visited 생성
		map = new int[N][N];

		// 지도 정보 입력
		for (int r = 0; r < N; r++) {
			String line = sc.next();
			for (int c = 0; c < N; c++) {
				map[r][c] = line.charAt(c) - '0';
			}
		}

		// 탐색 실시
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 해당 위치에 집이 있으면
				// count = 0으로 초기화, totalCount(총 단지수)를 증가시키고 dfs 실시
				if (map[r][c] == 1) {
					map[r][c] = 0;
					count = 0;
					totalCount++;
					dfs(r, c);
					list.add(count);
				}
			}
		}

		// 각 단지내 집의 수를 오름차순으로 정렬
		Collections.sort(list);

		// 결과 출력
		System.out.println(totalCount);
		for (int i = 0; i < totalCount; i++) {
			System.out.println(list.get(i));
		}

	}

	// dfs 함수 구현
	// 주변에 집이 없다면 리스트에 해당 단지의 집의 수 추가
	public static void dfs(int r, int c) {
		count++;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (check(nr, nc) && map[nr][nc] == 1) {
				map[nr][nc] = 0;
				dfs(nr, nc);
			}
		}
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
