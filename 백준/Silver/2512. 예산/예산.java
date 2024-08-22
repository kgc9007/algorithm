// BOJ 2512번 예산
// https://www.acmicpc.net/problem/2512

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] needs = new int[N];
		for (int i = 0; i < N; i++) {
			needs[i] = sc.nextInt();
		}

		int budget = sc.nextInt();

		// 결과 출력
		System.out.println(getMax(N, needs, budget));

	}

	public static int getMax(int N, int[] needs, int budget) {
		int sum = 0;
		int max = 0;

		for (int i = 0; i < N; i++) {
			sum += needs[i];
			max = Math.max(max, needs[i]);
		}

		// 모든 예산요청이 배정될 수 있는 경우 요청의 최대값 반환
		if (sum <= budget) {
			return max;
		}

		int left = 1;
		int right = max;
		int mid = (left + right) / 2;

		while (left <= right) {
			mid = (left + right) / 2;
			sum = 0;
			
			for (int i = 0; i < N; i++) {
				if (needs[i] < mid) {
					sum += needs[i];
				} else {
					sum += mid;
				}
			}

			if (sum > budget) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return left - 1;
	}
}
