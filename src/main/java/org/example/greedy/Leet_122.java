package org.example.greedy;

public class Leet_122 {

    public int maxProfit(int[] prices) {
        int answer = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                answer += (prices[i + 1] - prices[i]);
            }
        }
        return answer;
    }
    
}
