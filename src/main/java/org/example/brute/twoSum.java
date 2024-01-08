package org.example.brute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> index = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            index.putIfAbsent(nums[i], new ArrayList<>());
            index.get(nums[i]).add(i);
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum > target) {
                right--;
            } else if(sum < target) {
                left++;
            } else {
                if(nums[left] == nums[right]) {
                    return new int[]{index.get(nums[left]).get(0), index.get(nums[right]).get(1)};
                } else {
                    return new int[]{index.get(nums[left]).get(0), index.get(nums[right]).get(0)};
                }
            }
        }
        return null;
    }
}
