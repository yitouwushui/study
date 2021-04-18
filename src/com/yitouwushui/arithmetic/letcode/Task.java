package com.yitouwushui.arithmetic.letcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yitouwushui on 2021/4/8.
 */
public class Task {
    public static void main(String[] args) {
        int[] taskTime = new int[5];
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        int[] resultTime = new int[5];

        int taskLength = taskTime.length;
        int currentTime = 0;
        int currentCompleteTaskCount = 0;
        int index = 0;

        while (currentCompleteTaskCount != taskLength) {
            // 获取依赖数组0
            ArrayList<Integer> relyOn = hashMap.get(index);
            // 默认没有前置依赖
            boolean relyOnComplete = true;
            for (int i = 0; i < relyOn.size(); i++) {
                if (resultTime[i] == 0) {
                    // 前置依赖没有处理结果时间，代表没有完成
                    relyOnComplete = false;
                }
            }
            if (relyOnComplete) { // 如果前置依赖完成了，或者没有，则可以处理当前任务
                // 累加消耗时间
                currentTime += taskTime[index];
                // 完成任务+1
                currentCompleteTaskCount++;
                // 填充结果时间
                resultTime[index] = currentTime;
            }
            if (index == taskLength - 1) {
                // 遍历到最后一个数，重新遍历
                index = 0;
            } else {
                index++;
            }
        }
//        return resultTime;

    }
}
