package com.jungle.easy.day06;

import org.junit.Test;

/**
 * @Description Day06. 二分搜索技巧
 * 1.
 * @Author Jungle
 * @DATE 2022/5/16
 **/
public class PracticeDay06 {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void testSearch(){
        int[] ints = {-1,0,3,5,9,12};
        int search = search(ints, 9);
        System.out.println(search);
    }

    //
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            return  new int[]{lowerBound(nums,target),upperBound(nums,target)};
        }
        private int lowerBound(int[] nums, int target){
            int left = 0, right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] == target){
                    right = mid - 1;
                }else if(nums[mid] > target){
                    right = mid - 1;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }
            }
            if(left > nums.length - 1  || nums[left]  != target){
                return -1;
            }
            return left;
        }

        private int upperBound(int[] nums, int target){
            int left = 0, right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] == target){
                    left = mid + 1;
                }else if(nums[mid] > target){
                    right = mid - 1;
                }else if(nums[mid] < target){
                    left = mid + 1;
                }
            }
            if(right < 0  || nums[right]  != target){
                return -1;
            }
            return right;
        }
    }

}
