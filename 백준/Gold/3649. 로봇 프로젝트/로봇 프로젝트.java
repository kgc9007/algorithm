// BOJ 3649번 로봇 프로젝트
// https://www.acmicpc.net/problem/3649

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str;
		while ((str = br.readLine()) != null) {
			int X = Integer.parseInt(str);
			int N = Integer.parseInt(br.readLine());

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}

			if (N < 2) {
				sb.append("danger ").append('\n');
				continue;
			}
			Arrays.sort(arr);

			int targetLength = X * 10000000;

			int left = 0;
			int right = N - 1;
			boolean possible = false;
			while (left < right) {
				int sum = arr[left] + arr[right];
				if (sum == targetLength) {
					sb.append("yes ").append(arr[left]).append(" ").append(arr[right]).append('\n');
					possible = true;
					break;
				}

				if (sum > targetLength) {
					right--;
				} else if (sum < targetLength) {
					left++;
				}
			}
			if (!possible) {
				sb.append("danger ").append('\n');
			}

		}

		System.out.println(sb);
	}
}
