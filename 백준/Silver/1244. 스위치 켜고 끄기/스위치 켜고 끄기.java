import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 스위치 개수 N 입력
        int N = sc.nextInt();

        // N개의 스위치의 상태 입력
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        // 학생 수 입력
        int studentNum = sc.nextInt();

        // 학생 수만큼 반복
        while (studentNum-- > 0) {
            // a = 1 -> 남자, a = 2 -> 여자
            int a = sc.nextInt();
            // 숫자 입력
            int b = sc.nextInt();

            // 남자 -> 자기가 받은 수의 배수인 스위치 변경
            if (a == 1) {
                for (int i=b-1; i<N; i += b) {
                    if (arr[i] == 1) {
                        arr[i] = 0;
                    } else {
                        arr[i] = 1;
                    }
                }
            }
            // 여자 -> 자기가 받은 수와 같은 번호의 스위치를 중심으로
            // 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간의 스위치 변경
            // ex) 1 1 1 0 1 1 0 0 에서 4를 입력받으면 좌우 2칸씩 총 5칸 변경
            else {
                int center = b-1;
                int idx = 0;
                while (center-1-idx>=0 && center+1+idx<N) {
                    if (arr[center-1-idx]==arr[center+1+idx]) {
                        idx++;
                    } else {
                        break;
                    }
                }

                for (int i=center-idx; i<=center+idx; i++) {
                    if (arr[i] == 1) {
                        arr[i] = 0;
                    } else {
                        arr[i] = 1;
                    }
                }
            }

        }

        // 결과 출력
        for (int i=0; i<N; i++) {
            System.out.print(arr[i] + " ");

            if (i==19 || i==39 || i==59 || i==79){
                System.out.println("");
            }
        }

    }
}