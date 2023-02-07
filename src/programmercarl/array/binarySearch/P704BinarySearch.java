package programmercarl.array.binarySearch;
//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
//
// Related Topics 数组 二分查找 👍 1118 👎 0


public class P704BinarySearch {

    class Solution {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1; //定义target在左闭右闭的区间里，[left, right]

            while (left <= right) {//当left==right，区间[left, right]依然有效，所以用 <=
                int mid = (right - left) / 2 + left;// 防止溢出 等同于(left + right)/2
                if (nums[mid] == target) {//数组中找到目标值，直接返回下标
                    return mid;
                } else if (nums[mid] > target) {//target 在左区间，所以[left, mid - 1]
                    right = mid - 1;
                } else {//target 在右区间，所以[middle + 1, right]
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

}