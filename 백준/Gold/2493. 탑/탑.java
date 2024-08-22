// BOJ 2493번 탑
// https://www.acmicpc.net/problem/2493

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 탑의 개수 입력
//		int N = sc.nextInt();
		int N = Integer.parseInt(br.readLine());

		// 스택 생성
		Stack<int[]> stack = new Stack<>();

		// 결과를 저장할 문자열을 만들기위해 StringBuilder 생성
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			// 해당 탑의 높이
//			int height = sc.nextInt();
			int height = Integer.parseInt(st.nextToken());

			// 스택이 비어있지 않은 경우
			// - 스택에 저장된 모든 이전 탑을 확인하면서 레이저를 수신하는 탑(더 높은 탑) 확인
			while (!stack.isEmpty()) {
				// 현재 탑의 높이가 이전 탑보다 큰 경우
				// - 이전 탑 제거
				if (stack.peek()[1] < height) {
					stack.pop();
				}
				// 현재 탑의 높이가 이전 탑보다 작거나 같은 경우
				// - 현재 탑에서 발사한 레이저는 스택에 저장된 이전 탑에서 수신
				else {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
			}

			// 확인 이후 스택이 비어있는 경우
			// - 새로 추가하는 탑이 현재까지의 모든 탑보다 큰 경우이므로 이전 탑에서 수신 X
			if (stack.isEmpty()) {
				sb.append("0 ");
			}

			// 다음 탑에서 비교를 위해 스택에 현재 탑 추가
			stack.push(new int[] { i, height });
		}

		// 결과 출력
		System.out.println(sb);

	}

}
