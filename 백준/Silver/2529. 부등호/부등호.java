// BOJ 2529번 부등호
// https://www.acmicpc.net/problem/2529

import java.util.Scanner;

public class Main {

	static int K;
	static char[] signs;
	static int[] result;
	static boolean[] selected;

	static String min = Long.toString(Long.MAX_VALUE);
	static String max = Long.toString(Long.MIN_VALUE);

	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		K = sc.nextInt();
		signs = new char[K];
		for (int i = 0; i < K; i++) {
			signs[i] = sc.next().charAt(0);
		}

		// result 초기화 후 최소값, 최대값 계산
		result = new int[K + 1];
		selected = new boolean[10];
		for (int i = 0; i < 10; i++) {
			selected[i] = true;
			result[0] = i;
			calculate(0);
			selected[i] = false;
		}

		System.out.println(max);
		System.out.println(min);
	}

	// 최소값, 최대값 구하기
	public static void calculate(int idx) {
		if (idx == K) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <= K; i++) {
				sb.append(result[i]);
			}
			String str = sb.toString();
			if (Long.parseLong(str) < Long.parseLong(min)) {
				min = str;
			}
			if (Long.parseLong(str) > Long.parseLong(max)) {
				max = str;
			}
			return;
		}

		if (signs[idx] == '>') {
			for (int i = 0; i < 10; i++) {
				if (!selected[i] && result[idx] > i) {
					selected[i] = true;
					result[idx + 1] = i;
					calculate(idx + 1);
					selected[i] = false;
				}
			}
		} else {
			for (int i = 0; i < 10; i++) {
				if (!selected[i] && result[idx] < i) {
					selected[i] = true;
					result[idx + 1] = i;
					calculate(idx + 1);
					selected[i] = false;
				}
			}
		}
	}
}
