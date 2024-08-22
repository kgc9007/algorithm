// BOJ 1931번 회의실 배정

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 회의의 수 N 입력
		int N = sc.nextInt();

		// 회의의 정보(시작시간, 종료시간) 입력
		int[][] time = new int[N][2];

		for (int i = 0; i < N; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}

		// 정렬
		// 1. 회의 시작이 빠른 순으로
		// 2. 회의 시작 시간이 같다면 종료 시간이 빠른 순으로
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		
		// 총 회의 진행 수 count, 이전 회의 종료 시간 prevEndTime
		// count = 0, prevEndTime = 0으로 초기화
		int count = 0;
		int prevEndTime = 0;

		for (int i = 0; i < N; i++) {
			// 이전 회의가 종료되었다면
			// count++, prevEndTime 갱신
			if (prevEndTime <= time[i][0]) {
				count++;
				prevEndTime = time[i][1];
			}
		}

		// 결과 출력
		System.out.println(count);
	}
}
