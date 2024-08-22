// BOJ 1182번 부분수열의 합
// https://www.acmicpc.net/problem/1182

import java.util.Scanner;

public class Main {
	static int N;
	static int S;
	static int[] arr;
	static boolean[] selected;

	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 부분집합 구하기
		getPowerset(0);

		// S = 0이라면 공집합도 포함하여 count가 계산되었으니 1개 경우 제외
		if (S == 0) {
			count--;
		}

		// 결과 출력
		System.out.println(count);

	}

	// 부분집합 구하기
	public static void getPowerset(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (selected[i]) {
					sum += arr[i];
				}
			}
			if (sum == S) {
				count++;
			}
			return;
		}

		selected[idx] = true;
		getPowerset(idx + 1);

		selected[idx] = false;
		getPowerset(idx + 1);
	}
}
