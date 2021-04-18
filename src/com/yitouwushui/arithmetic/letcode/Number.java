package com.yitouwushui.arithmetic.letcode;

import java.util.Queue;
import java.util.Scanner;

public class Number {

    public static void main(String[] args) {
        Number numberClass = new Number();
        try {
            int[] numbers;
            Scanner sc = new Scanner(System.in);
            int length = Integer.parseInt(sc.nextLine());
            numbers = new int[length];
            for (int i = 0; i < length; i++) {
                String numberStr = sc.nextLine();
                numbers[i] = numberClass.transformNumber(Integer.parseInt(numberStr));
            }
            sc.close();
            for (int number : numbers) {
                System.out.println(number);
            }
        } catch (Exception e) {
            System.out.println("输入数据有误");
        }
    }

    public int[] transform(int[] numbers) {
        if (numbers.length < 2 || numbers[0] != numbers.length - 1) {
            return numbers;
        }
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = transformNumber(numbers[i]);
        }
        return numbers;
    }

    public int transformNumber(int n) {
        int count = 0;
        while (n != 0) {
            while (n % 3 == 0) {
                n = n / 3;
                count++;
            }
            if ((n != 1 && checkNumberBinaryOf1Count(n) == 1) || (n % 2 == 0 && n % 3 != 1)) {
                while (n % 2 == 0) {
                    n = n / 2;
                    count++;
                }
            }
            if (n != 0) {
                n = n - 1;
                count++;
            }
        }
        return count;
    }

    public int checkNumberBinaryOf1Count(int n) {
        int tem = n;
        int res = 0;
        while (tem != 0) {
            tem = (tem - 1) & tem;
            res++;
        }
        return res;

    }

}
