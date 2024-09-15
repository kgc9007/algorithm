// BOJ 1941번 소문난 칠공주
// https://www.acmicpc.net/problem/1941

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static final int LENGTH = 5;
	static final int TOTAL_STUDENT = 25;

	static char[][] map = new char[5][5];

	static int[][] selected = new int[7][2];
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int r = 0; r < 5; r++) {
			String line = br.readLine();

			for (int c = 0; c < 5; c++) {
				map[r][c] = line.charAt(c);
			}
		}

		getCombination(0, 0);

		// 결과 출력
		System.out.println(count);
	}

	// 전체 학생 중 7명의 학생을 뽑는 메소드
	public static void getCombination(int idx, int selectedCount) {
		if (selectedCount == 7) {
			if (check(selectedCount) && bfs()) {
				count++;
			}
			return;
		}

		if (idx == 25) {
			return;
		}

		if (selectedCount >= 4 && !check(selectedCount)) {
			return;
		}

		for (int i = idx; i < 25; i++) {
			selected[selectedCount][0] = (i / 5);
			selected[selectedCount][1] = (i % 5);
			getCombination(i + 1, selectedCount + 1);
			selected[selectedCount][0] = -1;
			selected[selectedCount][1] = -1;
		}
	}

	// 임도연파가 이미 4명 이상인지 확인하는 메소드 - 백트래킹
	public static boolean check(int selectedCount) {
		int count = 0;
		for (int i = 0; i < selectedCount; i++) {
			if (map[selected[i][0]][selected[i][1]] == 'Y') {
				count++;
			}
			if (count == 4) {
				return false;
			}
		}

		return true;
	}

	// 선택된 7명의 학생이 모두 인접하고 있는지 확인하는 메소드 - bfs
	public static boolean bfs() {
		boolean[] visited = new boolean[7];
		Queue<Integer> queue = new LinkedList<>();
		visited[0] = true;
		queue.add(0);
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			int cr = selected[curr][0];
			int cc = selected[curr][1];

			for (int i = 0; i < 7; i++) {
				if (visited[i]) {
					continue;
				}

				int nr = selected[i][0];
				int nc = selected[i][1];

				if (Math.abs(cr - nr) + Math.abs(cc - nc) > 1) {
					continue;
				}

				visited[i] = true;
				queue.add(i);
			}
		}

		for (int i = 1; i < 7; i++) {
			if (!visited[i]) {
				return false;
			}
		}

		return true;
	}

}
