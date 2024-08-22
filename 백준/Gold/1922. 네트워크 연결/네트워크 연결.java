// BOJ 1922번 네트워크 연결
// https://www.acmicpc.net/problem/1922

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int[] p;
	static int[] rank;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] edges = new int[M][3];
		for (int i = 0; i < M; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}

		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		p = new int[N + 1];
		rank = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		int sum = 0;
		int count = 0;
		for (int i = 0; i < M; i++) {
			int x = edges[i][0];
			int y = edges[i][1];
			
			if (find(x) != find(y)) {
				union(x, y);
				sum += edges[i][2];
				count++;
			}
			
			if (count == N - 1) {
				break;
			}
		}
		
		// 결과 출력
		System.out.println(sum);
	}

	public static int find(int x) {
		if (p[x] != x) {
			p[x] = find(p[x]);
		}
		return p[x];
	}

	public static void union(int x, int y) {
		if (rank[x] > rank[y]) {
			p[find(y)] = find(x);
		} else {
			p[find(x)] = find(y);
			
			if (rank[x] == rank[y]) {
				rank[y]++;
			}
		}
		
		return;
	}
}
