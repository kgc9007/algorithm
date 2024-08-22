// BOJ 3190번 뱀

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 델타배열
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	// 보드의 크기 N, 사과의 개수 K
	static int N;
	static int K;
	static int[][] map;

	// 뱀의 위치를 저장할 큐 snake
	// 뱀의 머리를 저장할 배열 head
	// 뱀이 바라보고 있는 방향 D
	// D : 0 - 오른쪽, 1 - 아래쪽, 2 - 왼쪽, 3 - 위쪽
	static Queue<int[]> snake = new LinkedList<>();
	static int[] head;
	static int D = 0;

	// 게임 종료까지 걸린 시간 count
	static int count = 1;

	// 뱀의 방향 변환 정보를 저장할 큐
	static Queue<String[]> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 보드의 크기 N, 사과의 개수 K 입력
		N = sc.nextInt();
		K = sc.nextInt();

		// N * N 크기의 배열 map 생성 후 정보 입력
		// map[r][c] : 0 -> 빈 칸
		// map[r][c] : 1 -> 사과
		// map[r][c] : 2 -> 뱀
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			map[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
		}

		// 뱀의 방향 변환 정보 입력
		int L = sc.nextInt();
		for (int i = 0; i < L; i++) {
			queue.add(new String[] { sc.next(), sc.next() });
		}

		// 뱀의 현재 위치, 방향 설정 후 이동 경로 확인
		map[0][0] = 2;
		snake.add(new int[] { 0, 0 });
		head = new int[] { 0, 0 };
		D = 0;
		move();

		// 결과 출력
		System.out.println(count);

	}

	// 매 초마다 뱀이 이동
	/*
	 * 1. 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다. 
	 * 2. 벽이나 자기자신의 몸과 부딪히면 게임 종료. 
	 * 3. 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다. 
	 * 4. 만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다.
	 */
	public static void move() {
		// 현재 방향으로 머리를 이동
		head = new int[] { head[0] + dr[D], head[1] + dc[D] };
		snake.add(head);
		
		// 벽이나 자기자신의 몸과 부딪히면 종료
		if (!check(head[0], head[1]) || map[head[0]][head[1]] == 2) {
			return;
		}
		
		// 이동한 칸에 사과가 있다면, 그 칸의 사과는 없어지고 꼬리 이동 X
		if (map[head[0]][head[1]] == 1) {
			map[head[0]][head[1]] = 2;
		} 
		// 이동한 칸에 사과가 없다면, 몸길이를 줄여 꼬리가 위치한 칸을 비워준다.
		else {
			map[head[0]][head[1]] = 2;
			int[] tail = snake.poll();
			map[tail[0]][tail[1]] = 0;
		}
		
		// 방향 전환 정보가 남아있다면
		// 해당 시간에 방향 변환이 있는지 확인 후 방향 전환 실시
		if (!queue.isEmpty()) {
			changeDirection(count);
		}
		
		count++;
		move();
	}
	
	// 방향 전환 메소드
	public static void changeDirection(int time) {
		String[] info = queue.peek();
		// 해당 시간에 방향 전환이 있는 경우
		if (Integer.parseInt(info[0]) == time) {
			// 'L' 왼쪽으로 회전
			if (info[1].equals("L")) {
				D = (D + 3) % 4;
			} 
			// 'D' 오른쪽으로 회전
			else {
				D = (D + 1) % 4;
			}
			// 방향 전환 후 해당 정보 제거
			queue.poll();
		}
	}

	// 경계를 벗어났는지 확인하는 메소드
	public static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
