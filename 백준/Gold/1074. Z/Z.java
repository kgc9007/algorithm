// BOJ 1074번 Z

import java.util.Scanner;

public class Main {

	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		// result = 0으로 초기화 후 재귀함수 실행
		result = 0;
		solve(r, c, N);
		
		// 결과 출력
		System.out.println(result);
	}

	// 재귀함수
	// 4등분 후 찾으려는 칸이 어느 위치에 해당하는지 확인
	// 해당 사분면을 새로운 N/2 * N/2 크기의 2차원 배열로 생각하고 다시 탐색
	// N == 0이 되면 종료
	public static void solve(int r, int c, int N) {
		if (N == 0) {
			return;
		}
		
		N = N - 1;
		int length = (int)Math.pow(2, N);
		// 왼쪽 위에 위치하는 경우 (2 사분면)
		if (r < length && c < length) {
			solve(r, c, N);
		}
		// 오른쪽 위에 위치하는 경우 (1 사분면)
		else if (r < length && c >= length) {
			result += length * length;
			solve(r, c - length, N);
		}
		// 왼쪽 아래 위치하는 경우 (3 사분면)
		else if (r >= length && c < length) {
			result += 2 * length * length;
			solve(r - length, c, N);			
		}
		// 오른쪽 아래 위치하는 경우 (4 사분면)
		else {
			result += 3 * length * length;
			solve(r - length, c - length, N);			
		}
	}
}
