// BOJ 2110번 공유기 설치
// https://www.acmicpc.net/problem/2110

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] house = new int[N];
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(house);

		int left = 1;
		int right = house[N - 1] - house[0] + 1;
		int result = 0;

		while (left < right) {
			int mid = (left + right) / 2;

			if (check(house, mid) < C) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		// 결과 출력
		System.out.println(left - 1);

	}

	public static int check(int[] arr, int maxLength) {
		int count = 1;
		int curr = arr[0];

		for (int i = 1; i < arr.length; i++) {
			int next = arr[i];
			if (next - curr >= maxLength) {
				count++;
				curr = next;
			}
		}

		return count;
	}
}
