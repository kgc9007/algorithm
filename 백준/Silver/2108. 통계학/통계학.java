import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 숫자의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        int min = 4000;
        int max = -4000;
        int sum = 0;
        int[] counting = new int[8001];

        // N개의 수 입력
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            // 기존 최대치보다 크거나 최소치보다 작은 수 입력시 최대, 최소 갱신
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
            // 숫자의 합 계산
            sum += num;
            // counting 배열을 통해 각 숫자의 입력 횟수 저장
            counting[num+4000]++;
        }

        // 산술평균 계산
        int mean = (int)Math.round((double)sum/N);

        // 범위 계산
        int range = max-min;

        // 중앙값, 최빈값 계산
        int median = 0;
        int cnt = 0;

        int mode = 0;
        int maxCount = 0;
        boolean flag = false;

        for (int i=0; i<counting.length; i++) {
            // maxCount가 가장 큰 값에 대응되는 수 -> 최빈수
            if (counting[i]>maxCount) {
                maxCount = counting[i];
                mode = i-4000;
                flag = true;
            }
            // 최빈값이 여러개 이면 -> counting[i] == maxCount
            // 최빈값 중 두 번째로 작은 값을 출력 -> flag가 true일 때
            else if (counting[i] == maxCount && flag == true) {
                mode = i-4000;
                flag = false;
            }

            // 작은수부터 N/2+1번째 수 -> 중앙값
            if (counting[i] != 0) {
                while (counting[i] != 0) {
                    cnt++;
                    counting[i]--;

                    if (cnt == N / 2 + 1) {
                        median = i - 4000;
                    }
                }
            }
        }
        // sb에 결과 추가
        sb.append(mean).append('\n');
        sb.append(median).append('\n');
        sb.append(mode).append('\n');
        sb.append(range).append('\n');

        System.out.println(sb);
    }
}
