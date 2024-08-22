import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 수의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // -1,000,000~1,000,000까지 특성 수가 있는지를 저장하는 배열 counting 생성
        int[] counting = new int[2000001];

        // N개의 수를 입력 받아 counting 배열에 저장
        // ex) -1,000,000 입력 -> counting[0]의 값 ++
        // ex) 0 입력 -> counting[1000000]의 값 ++
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            counting[num + 1000000]++;
        }

        // counting 배열을 0번부터 확인하면서 그 숫자가 있으면 sb에 저장
        for (int i=0; i<counting.length; i++) {
            if (counting[i] != 0) {
                sb.append(i-1000000).append('\n');
            }
        }

        // 결과 출력
        System.out.println(sb);
    }
}
