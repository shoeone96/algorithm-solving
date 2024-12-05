package org.example.becoming.dfs;

public class Solution_43162 {

    public static void main(String[] args) {
        Solution_43162 solution43162 = new Solution_43162();
        int[][] arr = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution43162.solution(3, arr));;
    }
    private static boolean[] isVisited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new boolean[computers.length];
        for(int i = 0; i < computers.length; i++){
            if(!isVisited[i]){
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int i, int[][] computer) {
        isVisited[i] = true;
        for(int j = 0; j < computer.length; j++){
            if(!isVisited[j] && computer[i][j] == 1){
                dfs(j, computer);
            }
        }
    }

}
