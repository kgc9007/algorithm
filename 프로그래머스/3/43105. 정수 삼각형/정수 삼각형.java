class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        
        for (int r = 0; r < triangle.length; r++) {
            for (int c = 0; c <= r; c++) {
                dp[r][c] = triangle[r][c];
            }
        }
        
        dp[1][0] += dp[0][0];
        dp[1][1] += dp[0][0];
        for (int r = 2; r < triangle.length; r++) {
            dp[r][0] += dp[r - 1][0];
            dp[r][r] += dp[r - 1][r - 1];
        }

        for (int r = 2; r < triangle.length; r++) {
            for (int c = 1; c < r; c++) {
                dp[r][c] += Math.max(dp[r - 1][c - 1], dp[r - 1][c]);
            }
        }
        
        int answer = 0;
        
        for (int c = 0; c < triangle.length; c++) {
            answer = Math.max(answer, dp[triangle.length - 1][c]);
        }
        
        return answer;
    }
}