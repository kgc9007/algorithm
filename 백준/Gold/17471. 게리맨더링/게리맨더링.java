// BOJ 17471번 게리맨더링

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	// 전체 인구수 totalPopulation
	// 각 지역의 인구수 population
	// 구역의 개수 N
	// 각 구역의 연결 여부를 포현할 인접행렬(2차원 배열) graph
	static int totalPopulation;
	static int[] population;
	static int N;
	static boolean[][] graph;
	static boolean[] visited;

	// 분할 결과
	// true -> 1번 선거지역, false -> 2번 선거지역
	static boolean[] result;

	// 두 선거구의 인구 차이의 최솟값 minDiff
	static int minDiff;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 구역의 개수 N
		N = sc.nextInt();

		// 각 구역의 인구수를 저장할 배열 population 생성
		// 전체 인구수 계산
		population = new int[N];
		for (int i = 0; i < N; i++) {
			population[i] = sc.nextInt();
			totalPopulation += population[i];
		}

		// canDevide = false, minDiff = totalPopulation으로 초기화
		minDiff = totalPopulation;

		// 각 구역의 연결 여부를 표현할 인접행렬(2차원 배열) 생성
		graph = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			// 해당 지역과 인접하고 있는 지역의 수 K
			int K = sc.nextInt();

			// 각 지역의 연결 여부를 입력받고 배열에 저장
			while (K-- > 0) {
				int area = sc.nextInt();

				graph[i][area - 1] = true;
				graph[area - 1][i] = true;
			}
		}

		// 선거구역 배정 실시
		result = new boolean[N];
		devide(0);

		// 결과 출력
		System.out.println(minDiff == totalPopulation ? -1 : minDiff);
	}

	// 선거구를 나누고 인구수 차이를 계산하는 메소드
	public static void devide(int idx) {
		// 모든 지역을 다 배정한 경우
		if (idx == N) {
			// 가능한 방법으로 나누었는지 확인
			visited = new boolean[N];
			if (check()) {
				// 두 선거 구역의 인구 수 차이 비교
				// minDiff 갱신
				int sumA = 0;
				int sumB = 0;
				for (int i = 0; i < N; i++) {
					if (result[i]) {
						sumA += population[i];
					} else {
						sumB += population[i];
					}
				}
				minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
			}
			return;
		}

		// 지역 배정이 아직 남아있는 경우

		// 1. 해당 구역을 포함하게 하고 다음 지역 배정
		result[idx] = true;
		devide(idx + 1);

		// 2. 해당 구역을 포함하지 않게 하고 다음 지역 배정
		result[idx] = false;
		devide(idx + 1);
	}

	// 선거구를 나눈 방법이 가능한지 아닌지 확인하는 메소드
	public static boolean check() {
		// 1. 모든 구역이 동일한 선거구역인지 확인
		boolean isAllSame = true;
		for (int i = 0; i < N; i++) {
			if (result[0] != result[i]) {
				isAllSame = false;
				break;
			}
		}
		// 모두 동일하다면 false 반환
		if (isAllSame) {
			return false;
		}

		// 2. 모두 동일하지 않다면 선거구의 모든 지역이 서로 연결되어있는지 확인
		// 2-1. result[i] = true인 경우 : 1번 지역구로 배정된 경우
		for (int i = 0; i < N; i++) {
			if (result[i]) {
				dfs(i);
				break;
			}
		}
		// 2-2. result[i] = false인 경우 : 2번 지역구로 배정된 경우
		for (int i = 0; i < N; i++) {
			if (!result[i]) {
				dfs(i);
				break;
			}
		}

		// dfs 이후 아직 방문하지 않은 노드가 있으면 false반환
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				return false;
			}
		}

		return true;
	}

	// dfs
	// 동일 선거지역의 모든 지역구가 연결되어있는지 확인하기 위해 그래프 탐색 메소드 생성
	public static void dfs(int i) {
		visited[i] = true;
		for (int j = 0; j < N; j++) {
			if (graph[i][j] && !visited[j] && result[j] == result[i]) {
				dfs(j);
			}
		}
	}
}
