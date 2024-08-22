// BOJ 1043번 거짓말
// https://www.acmicpc.net/problem/1043

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int knowCount = Integer.parseInt(st.nextToken());
		int[] knowPeople = new int[knowCount];
		for (int i = 0; i < knowCount; i++) {
			int num = Integer.parseInt(st.nextToken());

			knowPeople[i] = num;
		}

		List<Integer>[] party = new List[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			party[i] = new ArrayList<>();

			int peopleCount = Integer.parseInt(st.nextToken());

			int x = Integer.parseInt(st.nextToken());
			party[i].add(x);

			while (st.hasMoreTokens()) {
				int y = Integer.parseInt(st.nextToken());

				party[i].add(y);
				union(y, x);
			}
		}

		int count = 0;
		for (int i = 0; i < M; i++) {
			boolean possible = true;
			for (int j = 0; j < party[i].size(); j++) {
				for (int k = 0; k < knowCount; k++) {
					if (find(party[i].get(j)) == find(knowPeople[k])) {
						possible = false;
						break;
					}
				}
			}
			if (possible) {
				count++;
			}
		}

		// 결과 출력
		System.out.println(count);
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
