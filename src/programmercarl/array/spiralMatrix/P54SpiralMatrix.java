package programmercarl.array.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * <p>
 * Related Topics 数组 矩阵 模拟 👍 1298 👎 0
 */

public class P54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        int[][] matrix = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}};
        List<Integer> spiralOrder = solution.spiralOrder(matrix);
        for (int o : spiralOrder) {
            System.out.print(o + "___");
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /* 这题没啥好说的，老实遍历，注意边界
         * 注意：循环不变量，每一次循环：每一行，一列 的最后一个数字 作为下一行一列的开头，数据处理方式就统一了
         * 例如：第一圈，遍历行 仅处理1，2，遍历列：3，6，遍历底：9，8，遍历左列：7，4，然后：开始第二圈
         * 先解决转几圈的问题，每圈都上下左右同时获取数据，那么圈数应该是行、列 最小值+1
         * 同时读取数据时，由于每一次都去取到 倒数第二个数就停止，导致奇数正方形矩阵的中心点无法读取，中心点需特殊处理
         */

        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> spiralOrder = new ArrayList<>();
            // 先解决转几圈的问题，每圈都上下左右同时获取数据，那么圈数应该是行、列 最小值+1
            // 同时读取数据时，由于每一次都去取到 倒数第二个数就停止，导致奇数正方形矩阵的中心点无法读取，中心点需特殊处理
            int m = matrix.length;//行
            int n = matrix[0].length;//列
            int loopCount = (Math.min(m, n) + 1) / 2;//圈数应该是行、列最小值+1
            int skip = 1;//需要控制每一条边遍历的长度，每次循环收缩一位
            int top = 0;
            int left = 0;
            while (loopCount-- > 0) {
                //顶部从左往右读取
                for (int i = left; i < n - skip; i++) {
                    spiralOrder.add(matrix[top][i]);
                }
                //右边从上往下读取
                for (int j = top; j < m - skip; j++) {
                    spiralOrder.add(matrix[j][n - skip]);
                }
                // 下部从右边往左边读取，防止最后一行数据重复读取
                for (int k = n - skip; k > left && spiralOrder.size() < m * n; k--) {
                    spiralOrder.add(matrix[m - skip][k]);
                }
                //从下往上读取左边界,并且防止最后一列数据读取重复
                for (int l = m - skip; l > top && spiralOrder.size() < m * n; l--) {
                    spiralOrder.add(matrix[l][left]);
                }
                //一个循环搞完，顶部起始位置调整，循环调整，skip 调整
                top++;
                left++;
                skip++;
            }
            // 循环搞完，特殊处理奇数矩形中心点
            if (spiralOrder.size() < m * m && m == n && m % 2 == 1) {
                int mid = m / 2;
                spiralOrder.add(matrix[mid][mid]);
            }
            return spiralOrder;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}