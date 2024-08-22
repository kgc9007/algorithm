// BOJ 15486번 퇴사 2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		int N = sc.nextInt();
		int N = Integer.parseInt(br.readLine());
		int[][] info = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
//			info[i][0] = sc.nextInt();
//			info[i][1] = sc.nextInt();
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}

		// dp 배열 생성
		int[] dp = new int[N + 1];
		dp[0] = 0;

		// 1일차부터 N일동안의 일정 확인
		for (int i = 1; i <= N; i++) {
			// endDay : i일에 잡혀있는 상담이 끝나는 날
			int endDay = i + info[i][0] - 1;
			// i일에 잡혀있는 상담을 퇴사 전날까지 끝낼 수 있는 경우
			if (endDay <= N) {
				dp[endDay] = Math.max(dp[endDay], dp[i - 1] + info[i][1]);
				// dp[endDay] : 해당 상담을 하지 않는 경우(기존 값)
				// dp[i - 1] + info[i][1] : 해당 상담을 하는 경우
			}
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}

		// 결과 출력
		System.out.println(dp[N]);

	}
}
