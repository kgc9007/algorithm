// BOJ 2565번 전깃줄
// https://www.acmicpc.net/problem/2565

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		List<Integer> list = new ArrayList<>();
		list.add(arr[0][1]);
		for (int i = 1; i < N; i++) {
			if (list.get(list.size() - 1) < arr[i][1]) {
				list.add(arr[i][1]);
			} else {
				int idx = binarySearch(list, arr[i][1]);
				list.set(idx, arr[i][1]);
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

			if (num > list.get(mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}
}
