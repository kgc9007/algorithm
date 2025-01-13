import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        int totalWorks = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());;
        
        for (int work : works) {
            pq.add(work);
            totalWorks += work;
        }
        
        if (n >= totalWorks) {
            return answer;
        }
        
        while(n > 0) {
            int max = pq.poll();
            int next = pq.peek();
            
            if (max > next && n >= max - next) {
                n -= max - next;
                max = next;
                pq.add(max);
            } else {
                n--;
                max--;
                pq.add(max);
            }            
        }
        
        while (!pq.isEmpty()) {
            int num = pq.poll();
            answer += num * num;
        }
        
        return answer;
    }
    
    
}