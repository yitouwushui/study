package com.yitouwushui.arithmetic.letcode;

import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by yitouwushui on 2019/12/12.
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "aab12232432cadvd";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = 1;
        for (int left = 0, right = 0; right < chars.length; right++) {
            char cRight = chars[right];
            if (hashMap.containsKey(cRight)) {
                // left不能前移，如果right碰到了left之前的相同值,取大的
                left = Math.max(left, hashMap.get(cRight) + 1);
            }
            hashMap.put(cRight, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

}
