import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] info = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			info[i][0] = sc.nextInt();
			info[i][1] = sc.nextInt();
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
			
			// i일과 i-1일의 dp배열 값 비교 후 큰 값으로 갱신
			// -> dp[i] : i일까지의 얻을 수 있는 최대 수익
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}

		// 결과 출력
		System.out.println(dp[N]);

	}
}
