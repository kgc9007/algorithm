// BOJ 1365번 꼬인 전깃줄
// https://www.acmicpc.net/problem/1365

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

		List<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		for (int i = 1; i < N; i++) {
			if (list.get(list.size() - 1) < arr[i]) {
				list.add(arr[i]);
			} else {
				int idx = binarySearch(list, arr[i]);

				list.set(idx, arr[i]);
			}
		}

		// 결과 출력
		System.out.println(N - list.size());
	}

	// 이분탐색
	public static int binarySearch(List<Integer> list, int num) {
		int left = 0;
		int right = list.size() - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (list.get(mid) == num) {
				return mid;
			}

			if (list.get(mid) > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}
}