package 练习;

/**
 * @Author: ruan
 * Date: 2021/10/14 19:31
 * @Description:
 */
public class Test {
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                if(ans[i] + ans[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }

        return ans;
    }
}
