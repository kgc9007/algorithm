// BOJ 14889번 스타트와 링크

import java.util.Scanner;

public class Main {

	// 능력치 정보를 저장할 배열 info와 배열의 크기 N
	static int N;
	static int[][] info;
	static int teamSize;

	//
	static boolean[] isTeamA;
	
	// 두 팀의 능력치 차이의 최소값
	static int minDiff = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N 입력 후 info 생성
		N = sc.nextInt();
		info = new int[N][N];
		teamSize = N / 2;

		// info에 값 입력
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				info[r][c] = sc.nextInt();
			}
		}
		
		// 
		isTeamA = new boolean[N];
		
		divideTeam(0, 0);
		
		// 결과 출력
		System.out.println(minDiff);
	}
	
	public static void divideTeam(int idx, int count) {
		if (count == teamSize) {
			int sumA = 0;
			int sumB = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (isTeamA[i] && isTeamA[j]) {
						sumA += info[i][j];
					}
					if (!isTeamA[i] && !isTeamA[j]) {
						sumB += info[i][j];
					}
				}
			}
			
			minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
			return;
		}
		if (idx == N) {
			return;
		}
		
		
		// 해당 선수가 A팀에 포함되지 않는 경우
		divideTeam(idx + 1, count);
		
		// 해당 선수가 A팀에 포함되는 경우
		isTeamA[idx] = true;
		divideTeam(idx + 1, count + 1);
		// 해당 선수의 포함 여부를 초기화
		isTeamA[idx] = false;
	}
}
