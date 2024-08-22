// BOJ 1991번 트리 순회
import java.util.Scanner;

public class Main {

	// 결과를 저장할 StringBuilder sb
	static StringBuilder sb;

	// 트리를 표현할 배열 생성
	// tree[i][0] -> V / tree[i][1] -> L / tree[i][2] -> R
	static char[][] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N개의 줄에 걸쳐 트리의 정보 입력
		int N = sc.nextInt();
		tree = new char[N][3];
		for (int i = 0; i < N; i++) {
			// V, L, R 순으로 입력
			// 자식 노드가 없는 경우 . 입력
			char V = sc.next().charAt(0);
			char L = sc.next().charAt(0);
			char R = sc.next().charAt(0);

			// 입력받은 정보를 배열에 저장
			tree[i][0] = V;
			if (L != '.') {
				tree[i][1] = L;
			}
			if (R != '.') {
				tree[i][2] = R;
			}

		}

		// 전위 순회 실시
		sb = new StringBuilder();
		preorder(0);
		// 결과 출력 - 전위 순회
		System.out.println(sb);

		// 중위 순회 실시
		sb = new StringBuilder();
		inorder(0);
		// 결과 출력 - 전위 순회
		System.out.println(sb);

		// 후위 순회 실시
		sb = new StringBuilder();
		postorder(0);
		// 결과 출력 - 전위 순회
		System.out.println(sb);

	}

	// 전위 순회
	// VLR
	public static void preorder(int idx) {
		sb.append(tree[idx][0]);

		if (tree[idx][1] != '\0') {
			for (int i = 0; i < tree.length; i++) {
				if (tree[idx][1] == tree[i][0]) {
					preorder(i);
				}
			}
		}

		if (tree[idx][2] != '\0') {
			for (int i = 0; i < tree.length; i++) {
				if (tree[idx][2] == tree[i][0]) {
					preorder(i);
				}
			}
		}

	}

	// 중위 순회
	// LVR
	public static void inorder(int idx) {
		if (tree[idx][1] != '\0') {
			for (int i = 0; i < tree.length; i++) {
				if (tree[idx][1] == tree[i][0]) {
					inorder(i);
				}
			}
		}

		sb.append(tree[idx][0]);

		if (tree[idx][2] != '\0') {
			for (int i = 0; i < tree.length; i++) {
				if (tree[idx][2] == tree[i][0]) {
					inorder(i);
				}
			}
		}

	}

	// 후위 순회
	// LRV
	public static void postorder(int idx) {
		if (tree[idx][1] != '\0') {
			for (int i = 0; i < tree.length; i++) {
				if (tree[idx][1] == tree[i][0]) {
					postorder(i);
				}
			}
		}

		if (tree[idx][2] != '\0') {
			for (int i = 0; i < tree.length; i++) {
				if (tree[idx][2] == tree[i][0]) {
					postorder(i);
				}
			}
		}

		sb.append(tree[idx][0]);

	}

}
