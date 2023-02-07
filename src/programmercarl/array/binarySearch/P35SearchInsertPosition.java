package programmercarl.array.binarySearch;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 1851 👎 0


public class P35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 7;
        System.out.println(solution.searchInsert(nums, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //二分法，找到第一个比target 大的数字，其坐标即为要插入的位置
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;// 定义一个【left,right】左闭右闭区间
            while (left <= right) {//当left==right，区间[left, right]依然有效，所以用 <=
                int mid = (right - left) / 2 + left;//防止大数据相加溢出
                if (nums[mid] == target) {//在数组中找到目标值，并返回其索引
                    return mid;
                } else if (nums[mid] < target) {//target 在右区间，所以[middle + 1, right]
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;// 如果一直没找到数据，最后循环结束后right< left。并且可保证【0，left-1】之间的数据均小于target
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}