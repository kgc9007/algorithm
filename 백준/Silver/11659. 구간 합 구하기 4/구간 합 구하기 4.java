// BOJ 11659번 구간 합 구하기 4
// https://www.acmicpc.net/problem/11659

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 전체 수열의 길이
		int N = sc.nextInt();

		// 입력 횟수
		int M = sc.nextInt();

		// 누적합 배열
		int[] arr = new int[N + 1];
		// 누적합 배열 입력
		arr[0] = 0;
		for (int i = 1; i <= N; i++) {
			arr[i] = arr[i - 1] + sc.nextInt();
		}
		
		// 입력 횟수만큼 반복
		while (M-- > 0) {
			int S = sc.nextInt();
			int E = sc.nextInt();

			// 결과 출력
			System.out.println(arr[E] - arr[S - 1]);
		}

	}
}
