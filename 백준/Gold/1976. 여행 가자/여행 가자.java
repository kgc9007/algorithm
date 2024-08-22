// BOJ 1976번 여행 가자
// https://www.acmicpc.net/problem/1976

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				int linked = Integer.parseInt(st.nextToken());

				if (linked == 1) {
					union(i, j);
				}
			}
		}

		boolean possible = true;
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		while (st.hasMoreTokens()) {
			int next = Integer.parseInt(st.nextToken());

			if (find(start) != find(next)) {
				possible = false;
				break;
			}
		}

		if (possible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	// find
	public static int find(int x) {
		if (x != parents[x]) {
			parents[x] = find(parents[x]);
		}
		return parents[x];
	}

	// union
	public static void union(int x, int y) {
		parents[find(x)] = find(y);
	}
}
