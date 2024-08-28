// BOJ 7570번 줄 세우기
// https://www.acmicpc.net/problem/7570

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 숫자의 개수 N

		int[] DP = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			DP[num] = 1;
			if (DP[num - 1] != 0) { // 이번에 입력된 숫자보다 1 작은 수가 이미 입력된 경우
				// 1씩 커지는 부분수열의 길이 = num - 1까지 1씩 커지는 부분수열의 길이 + 1
				DP[num] = DP[num - 1] + 1;
			}
		}

		// 가장 긴 1씩 증가하는 부분수열의 길이 확인
		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, DP[i]);
		}

		// 결과 출력
		System.out.println(N - max);
	}
}
