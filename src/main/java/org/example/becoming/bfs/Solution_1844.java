package org.example.becoming.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_1844 {

    private static int [][] move = {{0,-1}, {-1, 0}, {0, 1}, {1, 0}};

    public int solution(int[][] maps) {
        boolean [][] isVisited = new boolean[maps.length][maps[0].length];
        Queue<Location> queue = new ArrayDeque<>();
        Location location = new Location(0, 0);
        queue.add(location);
        isVisited[0][0] = true;

        while(!queue.isEmpty()){
            Location poll = queue.poll();
            for(int i = 0; i < move.length; i++) {
                int newRow = poll.row + move[i][0];
                int newCol = poll.col + move[i][1];
                if (validate(newRow, newCol, maps) && !isVisited[newRow][newCol]){
                    if(newRow == maps.length -1 && newCol == maps[0].length -1){
                        return maps[poll.row][poll.col] + 1;
                    }
                    Location newLocation = new Location(newRow, newCol);
                    queue.add(newLocation);
                    isVisited[newLocation.row][newLocation.col] = true;
                    maps[newLocation.row][newLocation.col] = maps[poll.row][poll.col] + 1;
                }
            }
        }

        return -1;
    }

    private boolean validate(int newRow, int newCol, int [][] maps) {
        if(newRow < 0 || newRow > maps.length -1 || newCol < 0 || newCol > maps[0].length -1){
            return false;
        }

        if(maps[newRow][newCol] == 0){
            return false;
        }

        return true;
    }

    class Location{
        int row;
        int col;
        public Location(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

}
