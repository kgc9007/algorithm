// BOJ 2138번 전구와 스위치
// https://www.acmicpc.net/problem/2138

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 전구의 개수 입력
		String curr = br.readLine(); // 전구들의 초기 상태
		String target = br.readLine(); // 만들고자 하는 전구들의 상태

		boolean[] currArr1 = new boolean[N + 1]; // 원본 상태배열 1
		boolean[] currArr2 = new boolean[N + 1]; // 원본 상태배열 2
		boolean[] targetArr = new boolean[N + 1];
		for (int i = 0; i < N; i++) {
			if (curr.charAt(i) == '1') {
				currArr1[i] = true;
			}
			if (target.charAt(i) == '1') {
				targetArr[i] = true;
			}
		}
		currArr2 = Arrays.copyOf(currArr1, N + 1);

		// 1. 첫번째 스위치를 누르지 않는 경우
		// 두번째 전구부터 순서대로 확인
		// i - 1번째 전구가 만들고자 하는 상태와 다르다면 i번째 스위치를 누르고 count++
		// N - 1번째 전구까지 반복 후 마지막 전구의 상태가 만들고자 하는 상태와 다르다면
		// -> count1을 최대값 이상으로 변경(불가능)
		int count1 = 0;
		for (int i = 1; i < N; i++) {
			if (currArr1[i - 1] != targetArr[i - 1]) {
				count1++;
				currArr1[i - 1] = !currArr1[i - 1];
				currArr1[i] = !currArr1[i];
				currArr1[i + 1] = !currArr1[i + 1];
			}
		}

		if (currArr1[N - 1] != targetArr[N - 1]) {
			count1 = Integer.MAX_VALUE;
		}

		// 2. 첫번째 스위치를 누르는 경우
		// -> 첫번째, 두번재 전구의 상태를 변경한 후 시작
		int count2 = 1;
		currArr2[0] = !currArr2[0];
		currArr2[1] = !currArr2[1];
		// 두번째 전구부터 순서대로 확인
		// i - 1번째 전구가 만들고자 하는 상태와 다르다면 i번째 스위치를 누르고 count++
		// N - 1번째 전구까지 반복 후 마지막 전구의 상태가 만들고자 하는 상태와 다르다면
		// -> count2을 최대값 이상으로 변경(불가능)
		for (int i = 1; i < N; i++) {
			if (currArr2[i - 1] != targetArr[i - 1]) {
				count2++;
				currArr2[i - 1] = !currArr2[i - 1];
				currArr2[i] = !currArr2[i];
				currArr2[i + 1] = !currArr2[i + 1];
			}
		}

		if (currArr2[N - 1] != targetArr[N - 1]) {
			count2 = Integer.MAX_VALUE;
		}

		// 결과 출력
		// - 두 경우 모두 불가능 -> -1 출력
		// - 둘 중 하나라도 가능하다면 최소값 출력
		if (count1 == Integer.MAX_VALUE && count2 == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(count1, count2));
		}
	}
}
