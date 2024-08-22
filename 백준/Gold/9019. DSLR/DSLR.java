// BOJ 9019번 DSLR
// https://www.acmicpc.net/problem/9019

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static boolean[] visited;
	static String[] command;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (T-- > 0) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			solve(A, B);
			
			// 결과 출력
			System.out.println(command[B]);
		}
	}

	public static void solve(int start, int target) {
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[10001];
		command = new String[10001];

		visited[start] = true;
		command[start] = "";
		queue.add(start);

		while (!queue.isEmpty()) {
			int tmp = queue.poll();

			if (tmp == target) {
				return;
			}

			if (!visited[commandD(tmp)]) {
				visited[commandD(tmp)] = true;
				command[commandD(tmp)] = command[tmp] + "D";
				queue.add(commandD(tmp));
			}
			if (!visited[commandS(tmp)]) {
				visited[commandS(tmp)] = true;
				command[commandS(tmp)] = command[tmp] + "S";
				queue.add(commandS(tmp));
			}
			if (!visited[commandL(tmp)]) {
				visited[commandL(tmp)] = true;
				command[commandL(tmp)] = command[tmp] + "L";
				queue.add(commandL(tmp));
			}
			if (!visited[commandR(tmp)]) {
				visited[commandR(tmp)] = true;
				command[commandR(tmp)] = command[tmp] + "R";
				queue.add(commandR(tmp));
			}
		}
	}

	// 명령어 D 실행 메소드
	// n을 두 배로 변경, 9999보다 크다면 10000으로 나눈 나머지
	public static int commandD(int n) {
		return (n * 2) % 10000;
	}

	// 명령어 S 실행 메소드
	// n을 n - 1로 변경, n이 0이라면 9999
	public static int commandS(int n) {
		if (n == 0) {
			return 9999;
		}
		return n - 1;
	}

	// 명령어 L 실행 메소드
	// n의 각 자릿수를 왼편으로 회전
	public static int commandL(int n) {
		return (n % 1000) * 10 + (n / 1000);
	}

	// 명령어 R 실행 메소드
	// n의 각 자릿수를 오른편으로 회전
	public static int commandR(int n) {
		return (n / 10) + (n % 10) * 1000;
	}

}
