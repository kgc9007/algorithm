// BOJ 1516번 게임 개발
// https://www.acmicpc.net/problem/1516

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] structureTime = new int[N + 1];
		int[] inDegree = new int[N + 1];
		List<Integer>[] adj = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			structureTime[i] = Integer.parseInt(st.nextToken());

			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());

				if (num == -1) {
					break;
				}

				adj[num].add(i);
				inDegree[i]++;
			}
		}

		int[] dp = new int[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int next : adj[curr]) {
				dp[next] = Math.max(dp[next], dp[curr] + structureTime[curr]);

				inDegree[next]--;

				if (inDegree[next] == 0) {
					queue.add(next);
				}
			}
		}

		// 결과 출력
		for (int i = 1; i <= N; i++) {
			System.out.println(dp[i] + structureTime[i]);
		}
	}
}
