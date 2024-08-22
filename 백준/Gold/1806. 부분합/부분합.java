// BOJ 1806번 부분합
// https://www.acmicpc.net/problem/1806

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int S = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] prefixSum = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
		}

		if (prefixSum[N] < S) {
			System.out.println(0);
		} else {
			int minLength = Integer.MAX_VALUE;

			int idx2 = 1;
			for (int idx1 = 0; idx1 < N; idx1++) {
				if (idx2 <= idx1) {
					idx2 = idx1 + 1;
				}
				while (idx2 <= N) {
					int sum = prefixSum[idx2] - prefixSum[idx1];
					if (sum >= S) {
						minLength = Math.min(idx2 - idx1, minLength);
						break;
					}
					idx2++;
				}
			}

			System.out.println(minLength);
		}

	}
}
