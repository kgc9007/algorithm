// BOJ 11054번 가장 긴 바이토닉 부분 수열
// https://www.acmicpc.net/problem/11054

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] LIS = new int[N];
		List<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		LIS[0] = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i] > list.get(list.size() - 1)) {
				list.add(arr[i]);
				LIS[i] = list.size();
			} else {
				int idx = binarySearch(list, arr[i]);
				list.set(idx, arr[i]);
				LIS[i] = idx + 1;
			}
		}

		int[] LDS = new int[N];
		list = new ArrayList<>();
		list.add(arr[N - 1]);
		LDS[N - 1] = 1;
		for (int i = N - 2; i >= 0; i--) {
			if (arr[i] > list.get(list.size() - 1)) {
				list.add(arr[i]);
				LDS[i] = list.size();
			} else {
				int idx = binarySearch(list, arr[i]);
				list.set(idx, arr[i]);
				LDS[i] = idx + 1;
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, LIS[i] + LDS[i] - 1);
		}

		// 결과 출력
		System.out.println(max);

	}

	// 이분탐색
	public static int binarySearch(List<Integer> list, int num) {
		int left = 0;
		int right = list.size() - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (num > list.get(mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}
}
