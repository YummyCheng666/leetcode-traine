package programmercarl.hashTable;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not
 * matter.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 3 <= nums.length <= 3000
 * -10⁵ <= nums[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 数组 双指针 排序 👍 5680 👎 0
 */

public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:514 ms,击败了5.03% 的Java用户
        //内存消耗:49.6 MB,击败了5.03% 的Java用户
        //hashmap 和set 去重
        public List<List<Integer>> threeSumSlow(int[] nums) {
            HashSet<List<Integer>> results = new HashSet<>();
            //先对数组排序
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 1; i++) {//先确定第一个数字
                if (i > 1 && nums[i] == nums[i - 1]) {//去重，数字一致，跳过
                    continue;
                }
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = i + 1; j < nums.length; j++) {//这是第二个数
                    //在map 里面找第三个数字，使i+j+？=0
                    if (map.containsKey(-nums[i] - nums[j])) {//找到了，转换list
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(-nums[i] - nums[j]);
                        list.add(nums[j]);
                        results.add(list);
                    } else {
                        map.put(nums[j], 1);//没找到，把当前数字放到数组中
                    }
                }
            }
            return new ArrayList<>(results);
        }

        //执行耗时:30 ms,击败了46.76% 的Java用户
        //内存消耗:48.3 MB,击败了39.40% 的Java用户
        //优化版本,双指针版本
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            Arrays.sort(nums);
            //确定第一个数字 num[i]
            for (int i = 0; i < nums.length; i++) {
                // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {//去重
                    continue;
                }
                //第二个数字 num[left],第三数字num[right]
                int left = i + 1;//left 从i+1 开始
                int right = nums.length - 1;//right 从数组结尾开始
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum > 0) {//总数大于0，从大数据开始调整，往下减少
                        right--;
                    } else if (sum < 0) {//总数小于0，从小数据开始调整，往上增加
                        left++;
                    } else {//刚刚好等于0
                        List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                        results.add(list);
                        //去重 left 和right 重复的话，会造成数据组重合，需去重
                        while (right > left && nums[right] == nums[right - 1]) {
                            // right 和前一个数据相等，跳过，指针往前走
                            right--;
                        }
                        while (right > left && nums[left] == nums[left + 1]) {
                            // left 和后一个数据相等，跳过，指针往后
                            left++;
                        }
                        //找完一组，继续往下找
                        left++;
                        right--;

                    }
                }

            }
            return results;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}