package org.example.Demo;

import java.util.Arrays;

/**
 * @author redA
 * @时间: 2024年10月22日 下午7:33
 */
public class Solution {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * 输入一个整数数组，判断这个整数数组是否可分
     * @param input_array int整型 一维数组 整数数组
     * @return bool布尔型
     */
    public boolean checkArray(int[] input_array) {
        // write code here
        int sum = Arrays.stream(input_array).sum();
        if(sum%2==0){
            return  false;
        }
        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i=0;i<input_array.length;i++){
            for(int j=target;j>=input_array[i];j--){
                dp[j] = dp[j]||dp[j-input_array[i]];
            }
        }
        return dp[target];
    }
}
