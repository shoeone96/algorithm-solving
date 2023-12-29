package org.example.dfs;

class NumberOfIsland {
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int answer = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    answer++;
                }
            }
        }
        return answer;
    }

    private void dfs(char[][] grid, int row, int column) {
        grid[row][column] = '0';
        for (int i = 0; i < 4; i++) {
            if (validate(move[i], row, column, grid)) {
                int newRow = row + move[i][0];
                int newColumn = column + move[i][1];
                if(grid[newRow][newColumn] == '1'){
                    dfs(grid, newRow, newColumn);
                }
            }
        }
    }

    private boolean validate(int[] move, int row, int column, char[][] grid) {
        if (row + move[0] < 0 ||
                row + move[0] >= grid.length ||
                column + move[1] < 0 ||
                column + move[1] >= grid[0].length) {
            return false;
        }
        return true;
    }
}

