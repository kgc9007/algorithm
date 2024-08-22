import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력, 큐 선언
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        // 큐에 값 입력
        for (int i=1; i<=N; i++) {
            queue.add(i);
        }
        
        // 카드가 1장 남을때까지 반복
        while (queue.size()>1) {
            queue.poll();
            queue.add(queue.poll());

        }
        
        // 결과 출력
        System.out.println(queue.poll());

    }
}
