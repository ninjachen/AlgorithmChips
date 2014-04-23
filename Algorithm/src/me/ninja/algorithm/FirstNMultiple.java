package me.ninja.algorithm;

/**
 * Created by ninja_chen on 14-4-24.
 *
 * 正整数序列Q中的每个元素都至少能被正整数a和b中的一个整除，现给定a和b，需要计算出Q中的前几项，例如，当a=3，b=5，N=6时，序列为3，5，6，9，10，12
 * (1)、设计一个函数void generate（int a,int b,int N ,int * Q）计算Q的前几项
 * (2)、设计测试数据来验证函数程序在各种输入下的正确性。
 */
public class FirstNMultiple {

    public static final  String separator = "------------------------------------------";
    public static void main(String[] args) {
        long[] result = generate(11, 13, 3);
        for (long l : result) {
            System.out.println(l);
        }
            System.out.println(separator);

        long[] result1 = generate(3, 5, 6);
        for (long l : result1) {
            System.out.println(l);
        }
            System.out.println(separator);

        long[] result2 = generate(111, 119, 13);
        for (long l : result2) {
            System.out.println(l);
        }
            System.out.println(separator);

    }

    public static long[] generate(int a, int b, int n) {
        if(a < 0 || b < 0)
            return null;

        long[] queue = new long[n];
        int atimes = 1, btimes = 1;

        for (int index = 0; index < n; index++) {
            queue[index] = a * atimes < b * btimes ? a * atimes++ : b * btimes++;
        }
        return queue;
    }
}
