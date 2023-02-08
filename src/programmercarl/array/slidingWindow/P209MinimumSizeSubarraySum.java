package programmercarl.array.slidingWindow;

/**
 * Given an array of positive integers nums and a positive integer target, return
 * the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem
 * constraint.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= target <= 10⁹
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁴
 * <p>
 * <p>
 * <p>
 * Follow up: If you have figured out the
 * O(n) solution, try coding another solution of which the time complexity is
 * O(n log(n)).
 * <p>
 * Related Topics 数组 二分查找 前缀和 滑动窗口 👍 1552 👎 0
 */

public class P209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new P209MinimumSizeSubarraySum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int answer = Integer.MAX_VALUE;
            int sum = 0;
            for (int low = 0, hight = 0; hight < nums.length; hight++) {
                sum += nums[hight];
                //判断滑动窗口总和>target,超出范围
                while (sum >= target) {//因为调整过一次后，还可能是sum 大于target，所以循环，一直到sum<target
                    int subLength = (hight - low) + 1;
                    answer = answer < subLength ? answer : subLength;
                    //调整左边界的大小，让总和小于target
                    sum -= nums[low];
                    low++;
                }
            }
            return answer == Integer.MAX_VALUE ? 0 : answer;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}