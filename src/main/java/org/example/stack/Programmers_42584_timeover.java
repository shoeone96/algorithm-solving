package org.example.stack;

public class Programmers_42584_timeover {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stock[] stocks = new Stock[prices.length];
        for(int i = 0; i < stocks.length; i++){
            stocks[i] = new Stock();
        }

        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j < i; j++){
                if(!stocks[j].isFinished){
                    stocks[j].second++;
                    if(prices[j] > prices[i]){
                        stocks[j].isFinished = true;
                    }
                }
            }
        }

        for(int i = 0; i < answer.length; i++){
            answer[i] = stocks[i].second;
        }

        return answer;
    }

    class Stock{
        int second;
        boolean isFinished;
    }
}
