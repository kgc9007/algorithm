// BOJ 2230번 수 고르기
// https://www.acmicpc.net/problem/2230

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int minDiff = Integer.MAX_VALUE;

		int idx2 = 1;
		for (int idx1 = 0; idx1 < N; idx1++) {
			if (idx2 <= idx1) {
				idx2 = idx1 + 1;
			}
			while (idx2 < N) {
				int diff = arr[idx2] - arr[idx1];
				if (diff >= M) {
					minDiff = Math.min(diff, minDiff);
					break;
				}
				idx2++;
			}
		}

		// 결과 출력
		System.out.println(minDiff);

	}
}
