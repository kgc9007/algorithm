import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 전체 수열의 길이 (최대값) N 입력
        int N = Integer.parseInt(br.readLine());

        // 수열을 만들 수 있는지를 possible에 저장
        // 크기 N의 배열 stack
        // idx : 다음에 연산(push, pop)을 수행할 stack의 위치
        // numToPush : 다음에 stack에 push할 숫자, 초기값 1
        boolean possible = true;
        int[] stack = new int[N];
        int idx = 0;
        int numToPush = 1;

        // N 만큼 반복
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            // 입력받은 숫자가 다음에 스택에 push할 숫자보다 크거나 같다면
            // -> 현재 스택에 push되어있지 않음
            // -> 부족한 만큼(numToPush가 num이 될 때 까지) push 반복
            // -> push를 실시할 때마다 다음 push할 숫자와 push할 위치 ++
            // -> sb에 push 기록
            if (num >= numToPush) {
                for (int i = numToPush; i<=num; i++) {
                    stack[idx] = numToPush;
                    idx++; numToPush++;
                    sb.append("+").append('\n');
                }
            }
            // 스택의 최상단의 숫자(stack[idx-1])가 주어진 숫자(num) 보다 크다면
            // -> 주어진 수열 생성 불가능
            // -> possible을 false로 변경, 반복 중지
            else if (num < stack[idx-1]) {
                possible = false;
                break;
            }
            // 수열을 만들 수 있고
            // 스택의 최상단의 숫자(stack[idx-1])가 주어진 숫자(mnum)이면
            // -> pop 연산 실시, 스택의 최상단의 위치(idx) --, sb에 pop 기록
            idx--;
            sb.append("-").append('\n');

        }
        
        // 수열 생성 가능여부에 따라 sb 혹은 NO 출력
        if (possible){
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
