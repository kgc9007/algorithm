// BOJ 2470번 두 용액
// https://www.acmicpc.net/problem/2470

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

		int left = 0;
		int right = N - 1;

		int minDiff = Integer.MAX_VALUE;
		int resultLeft = 0;
		int resultRight = N - 1;

		while (left < right) {
			int sum = arr[left] + arr[right];

			if (Math.abs(sum) < minDiff) {
				minDiff = Math.abs(sum);

				resultLeft = left;
				resultRight = right;
			}

			if (sum > 0) {
				right--;
			} else if (sum < 0) {
				left++;
			} else {
				break;
			}
		}

		System.out.println(arr[resultLeft] + " " + arr[resultRight]);
	}
}
