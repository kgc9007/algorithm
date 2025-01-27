import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        
        List<Integer> emptySpace = getEmptySpaceLengthList(n, stations, w);
        
        // for (int i = 0; i < emptySpace.size(); i++) {
        //     System.out.println(emptySpace.get(i));
        // }
        
        int answer = 0;
        
        int maxCoverage = 2 * w + 1;
        
        for (Integer length : emptySpace) {
            answer += length / maxCoverage;
            
            if (length % maxCoverage != 0) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public List<Integer> getEmptySpaceLengthList(int n, int[] stations, int w) {
        List<Integer> list = new ArrayList<>();
        
        int last = 0;
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < stations.length; i++) {
            left = stations[i] - w;
            right = stations[i] + w;
            
            if (last + 1 < left) {
                list.add(left - last - 1);
            }
            
            last = right;
        }
        
        if (last < n) {
            list.add(n - last);
        }
        
        return list;
        
    }
    
}