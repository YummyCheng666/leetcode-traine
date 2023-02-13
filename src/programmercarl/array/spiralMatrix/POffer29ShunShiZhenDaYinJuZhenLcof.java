package programmercarl.array.spiralMatrix;

import java.util.Arrays;

/**
 * English description is not available for the problem. Please switch to Chinese.
 * Related Topics 数组 矩阵 模拟 👍 493 👎 0
 */

public class POffer29ShunShiZhenDaYinJuZhenLcof {
    public static void main(String[] args) {
        Solution solution = new POffer29ShunShiZhenDaYinJuZhenLcof().new Solution();
        int[][] matrix = {{1, 2, 3}
        };
        System.out.print(Arrays.toString(solution.spiralOrder(matrix)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return new int[]{};
            }
            int row = matrix.length;
            int cols = matrix[0].length;

            int[] spiralOrder = new int[row * cols];
            int loopCount = (Math.min(row, cols) + 1) / 2;
            int circle = 0;
            int i = 0, j = 0;//定义矩阵起始位置
            int start = 0;
            int index = 0;
            while (circle++ < loopCount) {
                // 上行
                for (i = start, j = start; j < cols - circle; j++) {
                    spiralOrder[index++] = matrix[i][j];
                }
                // 右列
                for (i = start; i < row - circle; i++) {
                    spiralOrder[index++] = matrix[i][j];
                }
                //下行
                for (; j >= circle && index < row * cols; j--) {
                    spiralOrder[index++] = matrix[i][j];
                }
                //左列
                for (; i >= circle && index < row * cols; i--) {
                    spiralOrder[index++] = matrix[i][j];
                }
                start++;
            }
            //正方形矩阵特殊处理
            if (row == cols && row % 2 == 1) {
                spiralOrder[index] = matrix[row / 2][cols / 2];
            }

            return spiralOrder;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}