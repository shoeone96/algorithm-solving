package org.example.becoming.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_1844 {

    private static int [][] move = {{0,-1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) {

    }

    public int solution(int[][] maps) {
        boolean [][] isVisited = new boolean[maps.length][maps[0].length];
        Queue<Location> queue = new ArrayDeque<>();
        Location location = new Location(0, 0);
        queue.add(location);
        isVisited[0][0] = true;

        while(!queue.isEmpty()){
            Location poll = queue.poll();
            if(poll.row == maps.length -1 && poll.col == maps[0].length -1){
                return maps[poll.row][poll.col];
            }
            for(int i = 0; i < move.length; i++) {
                int[] moveLocation = move[i];
                Location newLocation = new Location(poll.row + moveLocation[0],
                    poll.col + moveLocation[1]);
                if (validate(newLocation, maps) && !isVisited[newLocation.row][newLocation.col]){
                    queue.add(newLocation);
                    isVisited[newLocation.row][newLocation.col] = true;
                    maps[newLocation.row][newLocation.col] = maps[poll.row][poll.col] + 1;
                }
            }
        }

        return -1;
    }

    private boolean validate(Location newLocation, int [][] maps) {
        if(newLocation.row < 0 || newLocation.row >= maps.length || newLocation.col < 0 || newLocation.col >= maps[0].length){
            return false;
        }
        if(maps[newLocation.row][newLocation.col] == 0){
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
