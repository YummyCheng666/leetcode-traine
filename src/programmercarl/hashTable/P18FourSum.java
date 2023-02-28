package programmercarl.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique
 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * <p>
 * <p>
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * <p>
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 200
 * -10⁹ <= nums[i] <= 10⁹
 * -10⁹ <= target <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 双指针 排序 👍 1512 👎 0
 */

public class P18FourSum {
    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        solution.fourSum(nums, target);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:15 ms,击败了55.17% 的Java用户
        //内存消耗:41.9 MB,击败了54.62% 的Java用户
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> results = new ArrayList<>();
            //安全判断
            if (nums == null || nums.length == 0) {
                return results;
            }
            Arrays.sort(nums);
            //四个指针，i，i+1，left，right
            for (int i = 0; i < nums.length; i++) {
                //剪枝操作
                if (nums[i] > 0 && nums[i] > target) {
                    break;
                }
                //去重操作
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                for (int j = i + 1; j < nums.length; j++) {
                    //再次剪枝
                    if (nums[j] >= 0 && nums[i] + nums[j] > target) {
                        break;
                    }
                    //去重
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    //定义left 和right
                    int left = j + 1;
                    int right = nums.length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                            results.add(list);
                            left++;
                            right--;
                            //去重
                            while (left < right && nums[left] == nums[left - 1]) {
                                left++;
                            }
                            while (left < right && nums[right] == nums[right + 1]) {
                                right--;
                            }
                        } else if (sum < target) {
                            left++;
                        } else if (sum > target) {
                            right--;
                        }
                    }
                }
            }
            return results;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}