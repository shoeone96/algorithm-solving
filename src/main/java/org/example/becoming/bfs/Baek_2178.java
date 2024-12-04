package org.example.becoming.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2178 {

    static int [][] move = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static int [][] maze;
    static boolean [][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        maze = new int [N][M];
        isVisited = new boolean [N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();
            for(int j = 0; j < M; j++){
                maze[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        Location start = new Location(0, 0);
        Queue<Location> queue = new ArrayDeque<>();
        queue.add(start);

        while(!queue.isEmpty()){
            Location poll = queue.poll();
            for(int i = 0; i < move.length; i++){
                int newRow = poll.row + move[i][0];
                int newCol = poll.col + move[i][1];
                if(validate(newRow, newCol) && !isVisited[newRow][newCol]){
                    if(newRow == maze.length -1 && newCol == maze[0].length -1){
                        System.out.println(maze[poll.row][poll.col] + 1);
                        return;
                    }

                    queue.add(new Location(newRow, newCol));
                    isVisited[newRow][newCol] = true;
                    maze[newRow][newCol] = maze[poll.row][poll.col] + 1;
                }
            }
        }
    }

    private static boolean validate(int newRow, int newCol) {
        if(newRow < 0 || newRow > maze.length -1 || newCol < 0 || newCol > maze[0].length -1){
            return false;
        }

        if(maze[newRow][newCol] == 0){
            return false;
        }

        return true;
    }

    static class Location {
        int row;
        int col;

        public Location(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }

}
