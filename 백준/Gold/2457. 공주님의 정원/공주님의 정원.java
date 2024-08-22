// BOJ 2457번 공주님의 정원
// https://www.acmicpc.net/problem/2457

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 월/일 데이터를 1 ~ 365로 변환하기 위한 배열
		int[] monthToDate = new int[13];
		for (int i = 1; i < 12; i++) {
			if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
				monthToDate[i + 1] = monthToDate[i] + 31;
			} else if (i == 4 || i == 6 || i == 9 || i == 11) {
				monthToDate[i + 1] = monthToDate[i] + 30;
			} else {
				monthToDate[i + 1] = monthToDate[i] + 28;
			}
		}

		int N = Integer.parseInt(br.readLine()); // 꽃의 수 N
		int[][] flowers = new int[N][2]; // 꽃이 피는 날짜와 지는 날짜를 저장할 배열
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int startMonth = Integer.parseInt(st.nextToken());
			int startDate = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDate = Integer.parseInt(st.nextToken());

			// 0101 -> 1, 1231 -> 365 형태로 변환
			flowers[i][0] = monthToDate[startMonth] + startDate;
			flowers[i][1] = monthToDate[endMonth] + endDate;
		}

		// 정렬
		// 1. 피는 날짜가 빠른 순으로
		// 2. 지는 날짜가 느린 순으로
		Arrays.sort(flowers, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o1[0] - o2[0];
			}
		});

		// 3월 1일 ~ 11월 30일
		int start = monthToDate[3] + 1;
		int end = monthToDate[12] + 1;

		int count = 0; // 심어야 하는 꽃의 수
		int nextIdx = 0; // 다음으로 확인할 꽃의 번호(마지막으로 확인한 꽃의 번호 + 1)
		int lastDay = 0; // 꽃이 피어있는 가장 마지막 날(마지막 꽃이 지는 날)

		// 3월 1일 ~ 11월 30일까지 모두 꽃이 필 수 있는지 확인할 때까지 반복
		while (start < end) {
			boolean findNextFlower = false;

			for (int i = nextIdx; i < N; i++) {
				// 다음 꽃이 이전 꽃의 지는날보다 큰 경우
				if (flowers[i][0] > start) {
					break;
				}

				// 더 길게 피는 꽃을 찾은 경우
				// lastDay, nextIdx 갱신
				if (lastDay < flowers[i][1]) {
					findNextFlower = true;
					lastDay = flowers[i][1];
					nextIdx = i + 1;
				}
			}

			// 꽃이 계속해서 피어있을 수 있는 경우
			// count++, 다음으로 확인할 시작일(start)를 가장 마지막에 꽃이 지는 날짜로 변경
			if (findNextFlower) {
				count++;
				start = lastDay;
			} else {
				break;
			}
		}

		// 결과 출력
		if (lastDay < end) { // 가장 마지막에 핀 꽃이 11월 30일까지 피어있지 못하는 경우 0 출력
			System.out.println(0);
		} else { // 11월 30일까지 꽃이 피어있을 수 있다면 최소 개수 출력
			System.out.println(count);
		}

	}
}
