// BOJ 14502번 연구소

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    // 사방탐색을 위한 델타배열
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    // 지도의 가로, 세로 크기 N, M과 지도 정보를 저장할 배열 map
    static int N;
    static int M;
    static int[][] map;

    // 안전영역의 최대 크기 maxSafeArea
    static int maxSafeArea;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 지도의 크기 N, M 입력
        N = sc.nextInt();
        M = sc.nextInt();

        // N * M 크기의 지도에 정보 입력
        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = sc.nextInt();
            }
        }

        // 최대 안전영역의 크기 계산
        addWall(0, 0, 0);

        // 결과 출력
        System.out.println(maxSafeArea);
    }

    // 벽을 추가하는 메소드
    public static void addWall(int startr, int startc, int count) {
        if (count == 3) {
            int[][] tmp = new int[N][M];
            for (int r = 0; r < N; r++) {
                System.arraycopy(map[r], 0, tmp[r], 0, M);
            }

            spreadVirus();

            int safeArea = getSafeArea();
            maxSafeArea = Math.max(maxSafeArea, safeArea);

            map = tmp;

            return;
        }

        for (int r = startr; r < N; r++) {
            for (int c = (r == startr ? startc : 0); c < M; c++) {
                if (map[r][c] == 0) {
                    map[r][c] = 1;
                    addWall(r, c, count + 1);
                    map[r][c] = 0;
                }
            }
        }
    }

    // 바이러스 퍼뜨리는 메소드
    public static void spreadVirus() {
        Queue<int[]> queue = new LinkedList<>();

        // 바이러스 위치를 큐에 추가
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int r = tmp[0];
            int c = tmp[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                    map[nr][nc] = 2;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    // 안전영역의 크기를 계산하는 메소드
    public static int getSafeArea() {
        int safeArea = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0) {
                    safeArea++;
                }
            }
        }
        return safeArea;
    }
}
