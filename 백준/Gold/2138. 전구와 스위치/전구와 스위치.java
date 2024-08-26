// BOJ 2138번 전구와 스위치
// https://www.acmicpc.net/problem/2138

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 전구의 개수 입력
		int N = sc.nextInt();

		String curr = sc.next(); // 전구들의 초기 상태
		String target = sc.next(); // 만들고자 하는 전구들의 상태

		// 1. 첫번째 스위치를 누르지 않는 경우
		char[] currArr1 = curr.toCharArray();
		int count1 = 0;
		// 두번째 전구부터 순서대로 확인
		// i - 1번째 전구가 만들고자 하는 상태와 다르다면 i번째 스위치를 누르고 count++
		// N - 1번째 전구까지 반복 후 마지막 전구의 상태가 만들고자 하는 상태와 다르다면
		// -> count1을 최대값 이상으로 변경(불가능)
		for (int i = 1; i < N; i++) {
			if (currArr1[i - 1] != target.charAt(i - 1)) {
				count1++;

				if (currArr1[i] == '0') {
					currArr1[i] = '1';
				} else {
					currArr1[i] = '0';
				}

				if (i < N - 1) {
					if (currArr1[i + 1] == '0') {
						currArr1[i + 1] = '1';
					} else {
						currArr1[i + 1] = '0';
					}
				}
			}
		}
		if (currArr1[N - 1] != target.charAt(N - 1)) {
			count1 = 100001;
		}

		// 2. 첫번째 스위치를 누르는 경우
		// 첫번째, 두번재 전구의 상태를 변경한 후 시작
		char[] currArr2 = curr.toCharArray();
		if (currArr2[0] == '0') {
			currArr2[0] = '1';
		} else {
			currArr2[0] = '0';
		}
		if (currArr2[1] == '0') {
			currArr2[1] = '1';
		} else {
			currArr2[1] = '0';
		}
		int count2 = 1;
		// 두번째 전구부터 순서대로 확인
		// i - 1번째 전구가 만들고자 하는 상태와 다르다면 i번째 스위치를 누르고 count++
		// N - 1번째 전구까지 반복 후 마지막 전구의 상태가 만들고자 하는 상태와 다르다면
		// -> count2을 최대값 이상으로 변경(불가능)
		for (int i = 1; i < N; i++) {
			if (currArr2[i - 1] != target.charAt(i - 1)) {
				count2++;

				if (currArr2[i] == '0') {
					currArr2[i] = '1';
				} else {
					currArr2[i] = '0';
				}

				if (i < N - 1) {
					if (currArr2[i + 1] == '0') {
						currArr2[i + 1] = '1';
					} else {
						currArr2[i + 1] = '0';
					}
				}
			}
		}
		if (currArr2[N - 1] != target.charAt(N - 1)) {
			count2 = 100001;
		}

		// 결과 출력
		// - 두 경우 모두 불가능 -> -1 출력
		// - 둘 중 하나라도 가능하다면 최소값 출력
		if (count1 == 100001 && count2 == 100001) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(count1, count2));
		}

	}

}
