// BOJ 2630번 색종이 만들기

import java.util.Scanner;

public class Main {

	static int[][] paper;

	static int whiteCount;
	static int blueCount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		paper = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				paper[r][c] = sc.nextInt();
			}
		}

		cut(0, 0, N);

		// 결과 출력
		System.out.println(whiteCount);
		System.out.println(blueCount);

	}

	public static void cut(int startr, int startc, int length) {
		if (length == 1) {
			if (paper[startr][startc] == 0) {
				whiteCount++;
			} else {
				blueCount++;
			}
			return;
		}

		for (int r = startr; r < startr + length; r++) {
			for (int c = startc; c < startc + length; c++) {
				// 모두 같은 색이 아니라면
				if (paper[r][c] != paper[startr][startc]) {
					length /= 2;
					cut(startr, startc, length);
					cut(startr, startc + length, length);
					cut(startr + length, startc, length);
					cut(startr + length, startc + length, length);
					return;
				}
			}
		}

		if (paper[startr][startc] == 0) {
			whiteCount++;
		} else {
			blueCount++;
		}

	}
}
