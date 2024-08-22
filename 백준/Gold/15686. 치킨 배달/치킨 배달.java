// BOJ 13686번 치킨 배달
// https://www.acmicpc.net/problem/15686

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;

	static List<int[]> house = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	static boolean[] isRemained;
	
	static int minSumOfDistance = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

//		N = sc.nextInt();
//		M = sc.nextInt();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
//				map[r][c] = sc.nextInt();
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1) {
					house.add(new int[] { r, c });
				} else if (map[r][c] == 2) {
					chicken.add(new int[] { r, c });
				}
			}
		}
		
		isRemained = new boolean[chicken.size()];
		solve(0, 0);
		
		// 결과 출력
		System.out.println(minSumOfDistance);
		
	}
	
	// 
	public static void solve(int idx, int count) {		
		if (count == M) {
			int sum = 0;
			for (int i = 0; i < house.size(); i++) {
				int minDistance = Integer.MAX_VALUE;
				for (int j = 0; j < isRemained.length; j++) {
					if(isRemained[j]) {
						int distanceR = Math.abs(house.get(i)[0] - chicken.get(j)[0]);
						int distanceC = Math.abs(house.get(i)[1] - chicken.get(j)[1]);
						minDistance = Math.min(minDistance, distanceR + distanceC);
					}
				}
				sum += minDistance;
				
				// 기존 최소값을 갱신할 수 없다면 조기에 종료 (백트래킹)
				if (sum >= minSumOfDistance) {
					return;
				}
			}
			minSumOfDistance = Math.min(minSumOfDistance, sum);
			return;
		}
		
		if (idx == isRemained.length) {
			return;
		}
		
		isRemained[idx] = true;
		solve(idx + 1, count + 1);
		
		
		isRemained[idx] = false;
		solve(idx + 1, count);
	}
}
