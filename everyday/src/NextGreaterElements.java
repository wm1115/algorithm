/**
 *给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 *数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 *如果不存在，则输出 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

/**
 *2021/03/06
 *循环数组寻找下一个更大的元素暴力求解
 *用了两层for循环
 */
public class NextGreaterElements {

    public static void main(String[] args) {
        int[] result = nextGreaterElements(new int[]{1, 2, 1});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int f = nums[i];
            Boolean b = false;
            //从需要判定的元素开始，遍历整个nums数组，这段是补上了下面那段循环漏掉的数组后半段。
            //因为更大的元素有可能该元素的后面，也有可能出现在该元素的前面，
            for (int k = i; k < n; k++) {
                if (nums[k] > f) {
                    b = true;
                    result[i] = nums[k];
                    break;
                }
            }
            if (b == true) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (nums[j] > f) {
                    result[i] = nums[j];
                    break;
                } else
                    result[i] = -1;
            }
        }
        return result;
    }
}
