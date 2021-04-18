package com.yitouwushui.arithmetic.letcode;

/**
 * Created by yitouwushui on 2021/3/9.
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        removeDuplicates("abbaca");

    }

    public static String removeDuplicates(String s) {
        if (s == null) {
            return "";
        }
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == c) {
                stack.deleteCharAt(top);
                top--;
            } else {
                stack.append(c);
                top++;
            }
            System.out.println(stack.toString());
        }
        return stack.toString();
    }

}