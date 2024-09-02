// BOJ 1700번 멀티탭 스케줄링
// https://www.acmicpc.net/problem/1700

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Set<Integer> use = new HashSet<>();
		int count = 0;
		for (int i = 0; i < K; i++) {
			int curr = arr[i];

			if (use.contains(curr)) {
				continue;
			}

			if (use.size() < N) {
				use.add(curr);
				continue;
			}

			List<Integer> list = new ArrayList<>();
			for (int j = i; j < K; j++) {
				if (use.contains(arr[j]) && !list.contains(arr[j])) {
					list.add(arr[j]);
				}
			}

			if (list.size() < N) {
				for (int u : use) {
					if (!list.contains(u)) {
						use.remove(u);
						break;
					}
				}
			} else {
				use.remove(list.get(list.size() - 1));
			}

			use.add(curr);
			count++;
		}

		// 결과 출력
		System.out.println(count);
	}
}
