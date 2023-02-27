package programmercarl.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n,
 * return the number of tuples (i, j, k, l) such that:
 * <p>
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * Output: 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) +
 * 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) +
 * 0 = 0
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸
 * <p>
 * <p>
 * Related Topics 数组 哈希表 👍 754 👎 0
 */

public class P454FourSumIi {
    public static void main(String[] args) {
        Solution solution = new P454FourSumIi().new Solution();
        int[] num1 = new int[]{0,};
        int[] num2 = new int[]{0, 0};
        int[] num3 = new int[]{0, 0};
        int[] num4 = new int[]{0, 0};
        System.out.println(solution.fourSumCount(num1, num2, num3, num4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //执行耗时:143 ms,击败了60.46% 的Java用户
        //内存消耗:41.6 MB,击败了50.72% 的Java用户
        public int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int fourSumCount = 0;
            Map<Integer, Integer> map = new HashMap<>();
            //先搞num1,和num2 的和
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    int twoSumCount = nums1[i] + nums2[j];
                    int count = map.getOrDefault(twoSumCount, 0);//出现次数
                    map.put(twoSumCount, count + 1);
                }
            }
            //再搞num3 和num4 的和
            for (int k = 0; k < nums3.length; k++) {
                for (int n = 0; n < nums4.length; n++) {
                    //int twoSumCount = nums3[k] + nums4[n];
                    int diff = 0 - (nums3[k] + nums4[n]);
                    //查查看能和这两个数相加得0 的数，在不在map里面
                    if (map.containsKey(diff)) {
                        //很好，找到相加为0 的数了
                        //出现过了n次，就有n个组合
                        fourSumCount += map.get(diff);
                    }
                }
            }
            return fourSumCount;
        }

        //执行耗时:112 ms,击败了93.69% 的Java用户
        //内存消耗:41.3 MB,击败了83.06% 的Java用户
        //优化点，去掉了n3、n4 的map containsKey 判断，直接相加
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int n1 : nums1) {
                for (int n2 : nums2) {
                    map.put(n1 + n2, map.getOrDefault(n1 + n2, 0) + 1);
                }
            }
            int fourSumCount = 0;
            for (int n3 : nums3) {
                for (int n4 : nums4) {
                    fourSumCount += map.getOrDefault(-(n3 + n4), 0);
                }
            }
            return fourSumCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}