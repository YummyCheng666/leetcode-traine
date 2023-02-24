package programmercarl.hashTable;

import java.util.HashSet;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any
 * order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * <p>
 * <p>
 * Related Topics 数组 哈希表 双指针 二分查找 排序 👍 726 👎 0
 */

public class P349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //查重用hash
        //执行耗时:2 ms,击败了94.66% 的Java用户
        //	内存消耗:41.4 MB,击败了77.49% 的Java用户
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
                return new int[]{};
            }
            HashSet<Integer> num1Set = new HashSet<>();
            for (int num : nums1) {
                num1Set.add(num);
            }
            HashSet<Integer> num2Set = new HashSet<>();
            for (int num : nums2) {
                if (num1Set.contains(num)) {
                    num2Set.add(num);
                }
            }
            int[] array = new int[num2Set.size()];
            int index = 0;
            for (int num : num2Set) {
                array[index++] = num;
            }
            return array;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}