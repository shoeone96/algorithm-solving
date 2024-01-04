package org.example.brute;

import java.util.ArrayList;
import java.util.List;

public class twoSum {

    public int[] twoSum(int[] nums, int target) {
        List<Integer> answer = new ArrayList<>();
        boolean [] visited = new boolean[nums.length];
        return backtracking(answer, nums, target, visited);
    }

    private int [] backtracking(List<Integer> answer, int[] nums, int target, boolean[] visited) {
        if(answer.size() == 2){
            if(nums[answer.get(0)] + nums[answer.get(1)] == target){
                return new int[]{answer.get(0), answer.get(1)};
            }
        } else {
            for(int i = 0; i < nums.length; i++){
                if(!visited[i]){
                    answer.add(i);
                    visited[i] = true;
                    int[] backtracking = backtracking(answer, nums, target, visited);
                    if(backtracking != null){
                        return backtracking;
                    }
                    answer.remove(answer.size() -1);
                    visited[i] = false;
                }
            }
        }
        return null;
    }

}
