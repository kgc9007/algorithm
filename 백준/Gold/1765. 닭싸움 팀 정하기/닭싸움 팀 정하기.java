// BOJ 1765번 닭싸움 팀 정하기
// https://www.acmicpc.net/problem/1765

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] parents;

	static List<Integer>[] enemies;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		parents = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parents[i] = i;
		}

		enemies = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			enemies[i] = new ArrayList<Integer>();
		}

		int M = Integer.parseInt(br.readLine());
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			String relation = st.nextToken();
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			if (relation.equals("F")) {
				union(p, q);
			} else {
				if (enemies[p].isEmpty()) {
					enemies[p].add(q);
				} else {
					union(enemies[p].get(0), q);
				}
				if (enemies[q].isEmpty()) {
					enemies[q].add(p);
				} else {
					union(enemies[q].get(0), p);
				}
			}
		}

		Set<Integer> team = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			team.add(find(i));
		}

		// 결과 출력
		System.out.println(team.size());

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
		parents[find(y)] = find(x);
	}
}
