// BOJ 14499번 주사위 굴리기
// https://www.acmicpc.net/problem/14499

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[][] map;
	
	static int nowr;
	static int nowc;
	
	// 주사위의 상태를 나타낼 배열
	// dice[1] : 윗면, dice[2] : 북쪽을 바라보는 면, dice[3] : 동쪽을 바라보는 면
	// dice[4] : 서쪽을 바라보는 면, dice[5] : 남쪽을 바라보는 면, dice[6] : 바닥과 닿아있는 면
	// dice[0] : 주사위를 굴린 후 정보 수정시 임시로 사용(tmp 변수)
	static int[] dice = new int[7];
	
	static List<Integer> order = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		
		nowr = sc.nextInt();
		nowc = sc.nextInt();
		
		int K = sc.nextInt();
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < K; i++) {
			order.add(sc.nextInt());
		}
		
		// 명령 실행
		for (int i = 0; i < K; i++) {
			roll(order.get(i));
		}
	}
	
	public static void roll(int direction) {
		switch (direction) {
		case 1:
			east();
			break;
		case 2:
			west();
			break;
		case 3:
			north();
			break;
		case 4:
			south();
			break;
		default:
			break;
		}
	}
	
	// 오른쪽(동쪽)으로 이동
	public static void east() {
		int nextr = nowr;
		int nextc = nowc + 1;
		
		// 이동시키려는 칸이 지도 바깥이면 해당 명령 무시
		if (!check(nextr, nextc)) {
			return;
		}
		
		// 주사위 위치 수정
		nowc++;
		// 주사위 정보 수정
		dice[0] = dice[1];
		dice[1] = dice[4];
		dice[4] = dice[6];
		dice[6] = dice[3];
		dice[3] = dice[0];
		dice[0] = 0;
		
		change(nextr, nextc);
	}

	// 왼쪽(서쪽)으로 이동
	public static void west() {
		int nextr = nowr;
		int nextc = nowc - 1;
		
		// 이동시키려는 칸이 지도 바깥이면 해당 명령 무시
		if (!check(nextr, nextc)) {
			return;
		}
		
		// 주사위 위치 수정
		nowc--;
		// 주사위 정보 수정
		dice[0] = dice[1];
		dice[1] = dice[3];
		dice[3] = dice[6];
		dice[6] = dice[4];
		dice[4] = dice[0];
		dice[0] = 0;
		
		change(nextr, nextc);
	}

	// 위쪽(북쪽)으로 이동
	public static void north() {
		int nextr = nowr - 1;
		int nextc = nowc;
		
		// 이동시키려는 칸이 지도 바깥이면 해당 명령 무시
		if (!check(nextr, nextc)) {
			return;
		}
		
		// 주사위 위치 수정
		nowr--;
		// 주사위 정보 수정
		dice[0] = dice[1];
		dice[1] = dice[5];
		dice[5] = dice[6];
		dice[6] = dice[2];
		dice[2] = dice[0];
		dice[0] = 0;
		
		change(nextr, nextc);
	}

	// 위쪽(북쪽)으로 이동
	public static void south() {
		int nextr = nowr + 1;
		int nextc = nowc;
		
		// 이동시키려는 칸이 지도 바깥이면 해당 명령 무시
		if (!check(nextr, nextc)) {
			return;
		}
		
		// 주사위 위치 수정
		nowr++;
		// 주사위 정보 수정
		dice[0] = dice[1];
		dice[1] = dice[2];
		dice[2] = dice[6];
		dice[6] = dice[5];
		dice[5] = dice[0];
		dice[0] = 0;
		
		change(nextr, nextc);
	}
	
	// 지도와 주사위 아랫면의 숫자 변경 메소드
	public static void change(int r, int c) {
		// 이동한 칸에 쓰여 있는 수가 0이면 
		// 주사위의 바닥면에 쓰여 있는 숫자를 지도의 해당 칸에 복사
		if (map[r][c] == 0) {
			map[r][c] = dice[6];
		}
		// 이동한 칸에 쓰여 있는 수가 0이 아니면
		// 해당 칸의 숫자를 주사위의 바닥면에 복사, 칸에 쓰여 있는 수를 0으로 변경
		else {
			dice[6] = map[r][c];
			map[r][c] = 0;
		}
		
		// 주사위의 상단에 쓰여있는 수 출력
		System.out.println(dice[1]);
	}
	
	
	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
