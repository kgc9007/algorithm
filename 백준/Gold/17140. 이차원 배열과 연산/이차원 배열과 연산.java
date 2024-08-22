// BOJ 17140번 이차원 배열과 연산
// https://www.acmicpc.net/problem/17140

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int K;
	static int[][] arr;

	static int maxR = 3;
	static int maxC = 3;

	static int[] counting;

	static int time;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		arr = new int[101][101];
		for (int r = 1; r <= 3; r++) {
			for (int c = 1; c <= 3; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		time = 0;
		while (!check() && time <= 100) {
			time++;
			if (maxR >= maxC) {
				calculationR();
			} else {
				calculationC();
			}
		}

		// 결과 출력
		if (time == 101) {
			System.out.println(-1);
		} else {
			System.out.println(time);
		}
	}

	// r연산
	public static void calculationR() {
		maxC = 2;
		int[][] copy = new int[101][101];
		for (int r = 1; r < 101; r++) {
			copy[r] = Arrays.copyOf(arr[r], 101);
		}

		arr = new int[101][101];
		for (int r = 1; r < 101; r++) {
			counting = new int[101];
			int max = 0;
			for (int c = 1; c < 101; c++) {
				counting[copy[r][c]]++;
				max = Math.max(counting[copy[r][c]], max);
			}

			int idx = 1;
			int count = 1;
			while (count <= max) {
				for (int i = 1; i < 101; i++) {
					if (idx > 100) {
						break;
					}
					if (counting[i] == count) {
						arr[r][idx++] = i;
						arr[r][idx++] = count;
					}
				}
				count++;
			}
			maxC = Math.max(maxC, idx - 1);
		}
	}

	// c연산
	public static void calculationC() {
		maxR = 2;
		int[][] copy = new int[101][101];
		for (int r = 1; r < 101; r++) {
			copy[r] = Arrays.copyOf(arr[r], 101);
		}

		arr = new int[101][101];
		for (int c = 1; c < 101; c++) {
			counting = new int[101];
			int max = 0;
			for (int r = 1; r < 101; r++) {
				counting[copy[r][c]]++;
				max = Math.max(counting[copy[r][c]], max);
			}

			int idx = 1;
			int count = 1;
			while (count <= max) {
				for (int i = 1; i < 101; i++) {
					if (idx > 100) {
						break;
					}
					if (counting[i] == count) {
						arr[idx++][c] = i;
						arr[idx++][c] = count;
					}
				}
				count++;
			}
			maxR = Math.max(maxR, idx - 1);
		}
	}

	// A[N][M]의 값이 K인지 확인하는 메소드
	public static boolean check() {
		return arr[N][M] == K;
	}
}
