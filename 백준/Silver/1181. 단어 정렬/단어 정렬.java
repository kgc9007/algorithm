// https://st-lab.tistory.com/112 참고

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 배열 생성 후 입력
        String[] list = new String[N];

        for (int i=0; i<N; i++){
            list[i] = br.readLine();
        }

        // 조건 1. 길이가 짧은 순으로 정렬
        // 조건 2. 길이가 같으면 사전 순으로 정렬
        // comparator 인터페이스 사용
        // compare 메소드의 리턴값이 양수이면 두 객체의 위치 변환
        // -> 두 문자열의 길이가 다른 경우 앞의 문자열의 길이가 더 길면 위치 변환
        Arrays.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                else {
                    return o1.length()-o2.length();
                }
            }
        });

        // 조건 3. 중복된 단어는 하나만 남기고 제거
        // StringBuilder를 사용하여 배열에서 앞의 값과 다른 경우만 StringBuilder에 추가
        sb.append(list[0]).append('\n');

        for (int i=1; i<N; i++){
            // 문자열이 동일한지 확인하기 위해 equals 사용
            if (!list[i].equals(list[i-1])){
                sb.append(list[i]).append('\n');
            }
        }

        //StringBuilder 출력
        System.out.print(sb);

    }
}
