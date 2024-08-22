// BOJ 2437번 저울
// https://www.acmicpc.net/problem/2437

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (sum + 1 < arr[i]) {
				break;
			}

			sum += arr[i];
		}

		// 결과 출력
		System.out.println(sum + 1);

	}
}
