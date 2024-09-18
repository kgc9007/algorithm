// BOJ 1092번 배
// https://www.acmicpc.net/problem/1092

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Integer[] cranes = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		List<Integer> boxes = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(cranes, Collections.reverseOrder());
		Collections.sort(boxes, Collections.reverseOrder());

		// 결과 출력
		System.out.println(getMinTimes(cranes, boxes));

	}

	// 최소 시간을 구하는 메소드
	public static int getMinTimes(Integer[] cranes, List<Integer> boxes) {
		if (boxes.get(0) > cranes[0]) {
			return -1;
		}

		int count = 0;

		while (!boxes.isEmpty()) {
			int boxIdx = 0;

			for (int i = 0; i < cranes.length; i++) {
				while (boxIdx < boxes.size()) {
					if (cranes[i] >= boxes.get(boxIdx)) {
						boxes.remove(boxIdx);
						break;
					}
					boxIdx++;
				}
			}

			count++;
		}

		return count;
	}
}
