import java.util.Scanner;

public class Main {

	static int[][] map;
	static int N;
	static int X;
	static int count;
	static boolean[][] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 1;
		int testCase = 0;
		while (T-- > 0) {
			testCase++;

			
			N = sc.nextInt();
			X = sc.nextInt();

			map = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			
			count = 0;
			solve();

			// 결과 출력
			System.out.print(count);

		}
	}

	public static void solve() {
	
		for (int r = 0; r < N; r++) {
			
			used = new boolean[N][N];
			
			boolean canConstruct = true;
			
			int height = map[r][0];
			for (int c = 1; c < N; c++) {
				if (map[r][c] > height + 1 || map[r][c] < height - 1) {
					canConstruct = false;
					break;
				}
				
				if (map[r][c] == height - 1) {
					
					boolean flag = true;
					for (int i = 0; i < X; i++) {
						if (c + i >= N || map[r][c] != map[r][c + i]) {
							flag = false;
							break;
						}
					}
					
					if (flag) {
						
						for(int i = 0; i < X; i++) {
							used[r][c + i] = true;
						}
						c += X - 1;
						height -= 1;
					}
					
					else {
						canConstruct = false;
						break;
					}
				}
				
				if (map[r][c] == height + 1) {
					
					boolean flag = true;
					for (int i = -1; i >= -X; i--) {
						if (c + i < 0 || map[r][c - 1] != map[r][c + i] || used[r][c + i]) {
							flag = false;
							break;
						}
					}

					if (flag) {
						height += 1;
					}

					else {
						canConstruct = false;
						break;
					}
				}
			}
			if (canConstruct) {
				count++;
			}
		}
		
		
		for (int c = 0; c < N; c++) {
			
			used = new boolean[N][N];
			
			boolean canConstruct = true;
			
			int height = map[0][c];
			for (int r = 1; r < N; r++) {
				if (map[r][c] > height + 1 || map[r][c] < height - 1) {
					canConstruct = false;
					break;
				}
			
				if (map[r][c] == height - 1) {
					
					boolean flag = true;
					for (int i = 0; i < X; i++) {
						if (r + i >= N || map[r][c] != map[r + i][c]) {
							flag = false;
							break;
						}
					}
					
					if (flag) {
						
						for(int i = 0; i < X; i++) {
							used[r + i][c] = true;
						}
						r += X - 1;
						height -= 1;
					}
					
					else {
						canConstruct = false;
						break;
					}
				}
		
				if (map[r][c] == height + 1) {
					
					boolean flag = true;
					for (int i = -1; i >= -X; i--) {
						if (r + i < 0 || map[r - 1][c] != map[r + i][c] || used[r + i][c]) {
							flag = false;
							break;
						}
					}
				
					if (flag) {
						height += 1;
					}
					
					else {
						canConstruct = false;
						break;
					}
				}
			}
			if (canConstruct) {
				count++;
			}
		}
		

		
	}
}