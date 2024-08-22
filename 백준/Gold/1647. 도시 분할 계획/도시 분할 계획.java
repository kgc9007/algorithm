import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 크루스칼 알고리즘
// Union-Find
public class Main {
	static int[] p;
	static int[] rank;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		// 간선 정보 입력
		int[][] edges = new int[M][3];
		for (int i = 0; i < M; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}

		// 간선의 가중치가 작은 순으로(오름차순) 정렬
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		// 대표 배열, 랭크 배열 생성
		p = new int[N + 1];
		rank = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		// [크루스칼 알고리즘]
		// N - 1개의 간선이 선택될때까지 연결 실시
		// 1. 가중치가 작은 순으로
		// 2. 단, 사이클이 발생하면 X
		int sum = 0;
		int count = 0;
		int max = 0;
		for (int i = 0; i < M; i++) {
			int x = edges[i][0];
			int y = edges[i][1];

			if (find(x) != find(y)) {
				union(x, y);
				sum += edges[i][2];
				count++;

				max = Math.max(edges[i][2], max);
			}

			if (count == N - 1) {
				break;
			}
		}

		// 결과 출력
		int result = sum - max;
		System.out.println(result);
	}

	// 해당 원소가 속한 집합의 대표자를 찾는 메소드
	public static int find(int x) {
		if (p[x] != x) {
			p[x] = find(p[x]);
		}
		return p[x];
	}

	// 두 원소가 속한 집합을 합치는 메소드
	// 랭크가 큰 집합을 부모로 설정
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
