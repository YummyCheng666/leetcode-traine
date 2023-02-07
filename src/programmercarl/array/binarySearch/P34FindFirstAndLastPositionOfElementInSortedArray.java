package programmercarl.array.binarySearch;
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2103 👎 0


public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     *
     */
    class Solution {

        /**
         * 思路一：彻底二分，找左边界和右边界
         * 1、左边界，最后一个比target小的数据
         * 2、右边界，第一个比target大的数据
         * 3、考虑数组[2,2,2]，target =2 情况，左右边界是[-1,lenght+1];
         */
        public int[] searchRange(int[] nums, int target) {
            int leftBorder = getLeftBorder(nums, target);
            int rightBorder = getRightBorder(nums, target);
            //1、leftBorder ，rightBorder ==-2 ，说明未找到nums[i] == target，返回-1，-1
            if (leftBorder == -2 || rightBorder == -2) {
                return new int[]{-1, -1};
            }
            //leftBorder < rightBorder ,符合左右边界定义，返回，leftBorder+1,rightBorder-1
            if (rightBorder - leftBorder > 1) {//左右边界之间一定会间隔一个数字，否则就是没找到数据。例如：[5,7], target = 6
                return new int[]{leftBorder + 1, rightBorder - 1};
            }
            return new int[]{-1, -1};

        }

        public int getLeftBorder(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;//定义一个[left，right] 左闭右闭的空间
            int leftBorder = -2;
            //寻找左边第一个target 前的一个数字
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] >= target) {// 寻找左边界，就要在nums[middle] == target的时候更新right
                    right = mid - 1;
                    leftBorder = right;
                } else {
                    left = mid + 1;
                }
            }
            return leftBorder;
        }

        public int getRightBorder(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;//定义一个[left，right] 左闭右闭的空间
            int rightBorder = -2;
            //寻找右边第一个比target 大的数字
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] <= target) {//寻找右边界，就要在nums[middle] == target的时候更新left
                    left = mid + 1;
                    rightBorder = left;
                } else {
                    right = mid - 1;
                }
            }
            return rightBorder;
        }

        /**
         * 思路二：
         * 1、二分找到目标数据
         * 2、双指针左右滑动，找到边界
         */
        public int[] searchRange2(int[] nums, int target) {
            int targetIndex = binarySearch(nums, target);
            if (targetIndex == -1) { // nums 中不存在 target，直接返回 {-1, -1}
                return new int[]{-1, -1}; // 匿名数组
            }
            int left = targetIndex;
            int right = targetIndex;
            while (left - 1 >= 0 && nums[left - 1] == target) {//left 向左滑动，注意越界问题
                left--;
            }
            while (right + 1 <= nums.length - 1 && nums[right + 1] == target) {//right 向右滑动，注意越界
                right++;
            }
            return new int[]{left, right};
        }

        public int binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length;//尝试定义一个[left,right)左臂右开空间
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return -1;//没找到目标数据，返回-1
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}