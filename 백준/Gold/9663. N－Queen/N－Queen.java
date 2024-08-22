import java.util.Scanner;

public class Main {
    static int N;
    static boolean[][] board;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new boolean[N][N];

        solve(0);

        // 결과 출력
        System.out.println(count);
    }

    public static void solve(int r) {
        if (r == N) {
            count++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (isSafe(r, c)) {
                board[r][c] = true;
                solve(r + 1);
                board[r][c] = false; // 해당 위치에서 다른 경우를 탐색하기 위해 퀸을 제거
            }
        }
    }

    public static boolean isSafe(int r, int c) {
        // 같은 열에 퀸이 있는지 확인
        for (int i = 0; i < r; i++) {
            if (board[i][c]) {
                return false;
            }
        }

        // 왼쪽 위 대각선에 퀸이 있는지 확인
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        // 오른쪽 위 대각선에 퀸이 있는지 확인
        for (int i = r, j = c; i >= 0 && j < N; i--, j++) {
            if (board[i][j]) {
                return false;
            }
        }

        return true;
    }
}
