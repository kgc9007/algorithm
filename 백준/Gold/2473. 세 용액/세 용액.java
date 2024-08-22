// BOJ 2473번 세 용액
// https://www.acmicpc.net/problem/2473

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);
		long[] result = new long[3];
		long minDiff = Long.MAX_VALUE;
		for (int i = 0; i < N - 2; i++) {
			int left = i + 1;
			int right = N - 1;
			while (left < right) {
				long sum = arr[i] + arr[left] + arr[right];
				if (Math.abs(sum) < minDiff) {
					minDiff = (long) Math.abs(sum);
					result[0] = arr[i];
					result[1] = arr[left];
					result[2] = arr[right];
				}

				if (sum > 0) {
					right--;
				} else if (sum < 0) {
					left++;
				} else {
					result[0] = arr[i];
					result[1] = arr[left];
					result[2] = arr[right];
					break;
				}
			}
		}

		Arrays.sort(result);
		System.out.print(result[0] + " " + result[1] + " " + result[2]);
	}
}
