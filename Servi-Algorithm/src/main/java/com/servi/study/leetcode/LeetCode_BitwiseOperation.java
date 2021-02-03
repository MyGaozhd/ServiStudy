package com.servi.study.leetcode;

/**
 * @author servi
 * @date 2021/2/3
 */
public class LeetCode_BitwiseOperation {

    public static void main(String[] args) {

        // 与运算
//        m1();
        // 或运算
//        m2();
        m3();
    }

    // 与运算：两个位都为1时，结果才为1；0&0=0 0&1=0 1&0=0 1&1=1
    public static void m1() {

        int a = 5;// 101
        int b = 1;// 001
        System.out.println("a=5,a=" + Integer.toBinaryString(a));
        System.out.println("b=1,b=" + Integer.toBinaryString(b));

        System.out.println("a&b=" + Integer.toBinaryString(a & b));

        // 1）清零-如果想将一个单元清零，即使其全部二进制位为0，只要与一个各位都为零的数值相与，结果为零。
        System.out.println("1）清零");
        a = 5;// 101
        b = 0;// 001
        System.out.println("a=5,a=" + Integer.toBinaryString(a));
        System.out.println("b=1,b=" + Integer.toBinaryString(b));

        System.out.println("a&b=" + Integer.toBinaryString(a & b));
        System.out.println("2) 取一个数的指定位");
        // 2）取一个数的指定位-比如取数 X=1010 1110 的低4位，只需要另找一个数Y，令Y的低4位为1，其余位为0，即Y=0000
        // 1111，
        // 然后将X与Y进行按位与运算（X&Y=0000 1110）即可得到X的指定位。
        a = Integer.parseInt("10101110", 2);
        b = Integer.parseInt("00001111", 2);

        System.out.println("a=" + a + ",a=" + Integer.toBinaryString(a));
        System.out.println("b=" + b + ",b=" + Integer.toBinaryString(b));

        System.out.println("a&b=" + Integer.toBinaryString(a & b));
        System.out.println("3)判断奇偶");
        // 3）判断奇偶-只要根据最未位是0还是1来决定，为0就是偶数，为1就是奇数。因此可以用if ((a & 1) == 0)代替if (a %
        // 2 == 0)来判断a是不是偶数。
        // 原理：二进制转十进制的方式 2N + 2N-1 + ... +
        // 2的0次幂。最后一位之前的数相加的和肯定是2的整数倍，最后一位如果是0就是+0，是1就+1，来确定奇偶数
        a = Integer.parseInt("111111110", 2);
        b = Integer.parseInt("111111111", 2);
        System.out.println("a=" + a + ",a=" + Integer.toBinaryString(a));
        System.out.println("b=" + b + ",b=" + Integer.toBinaryString(b));

        System.out.println("a是偶数？=" + ((a & 1) == 0));
        System.out.println("b是偶数？=" + ((b & 1) == 0));
    }

    // 或运算：两个位都为0时，结果才为0；0|0=0 0|1=1 1|0=1 1|1=1
    public static void m2() {

        int a = 5;// 101
        int b = 2;// 010
        System.out.println("a=5,a=" + Integer.toBinaryString(a));
        System.out.println("b=2,b=" + Integer.toBinaryString(b));

        System.out.println("a|b=" + (a | b) + ",a1b=" + Integer.toBinaryString(a | b));
        // 1）常用来对一个数据的某些位设置为1
        // 比如将数 X=1010 1110 的低4位设置为1，只需要另找一个数Y，令Y的低4位为1，其余位为0，即Y=0000
        // 1111，然后将X与Y进行按位或运算（X|Y=1010 1111）即可得到。
        System.out.println("1）常用来对一个数据的某些位设置为1");
        a = Integer.parseInt("0000011111", 2);
        b = Integer.parseInt("1111100000", 2);
        System.out.println("a=" + a + ",a=" + Integer.toBinaryString(a));
        System.out.println("b=" + b + ",b=" + Integer.toBinaryString(b));
        System.out.println("a|b=" + (a | b) + ",a|b=" + Integer.toBinaryString(a | b));
    }

    // 异或运算,参加运算的两个对象，如果两个相应位相同为0，相异为1。；0^0=0 0^1=1 1^0=1 1^1=0；
    // 任何数和0异或都是它本身
    public static void m3() {

        /**
         * 异或的几条性质:
         *
         * 1、交换律
         *
         * 2、结合律 (a^b)^c == a^(b^c)
         *
         * 3、对于任何数x，都有 x^x=0，x^0=x
         *
         * 4、自反性: a^b^b=a^0=a;
         */

        int a = 5;// 101
        int b = 2;// 010
        System.out.println("a=5,a=" + Integer.toBinaryString(a));
        System.out.println("b=2,b=" + Integer.toBinaryString(b));
        System.out.println("a^b=" + (a ^ b) + ",a^b=" + Integer.toBinaryString(a ^ b));

        // 1）翻转指定位
        // 比如将数 X=1010 1110 的低4位进行翻转，只需要另找一个数Y，令Y的低4位为1，其余位为0，即Y=0000
        // 1111，然后将X与Y进行异或运算（X^Y=1010 0001）即可得到。
        System.out.println("1）翻转指定位");
        a = Integer.parseInt("10101110", 2);
        b = Integer.parseInt("00001111", 2);
        System.out.println("a^b=" + (a ^ b) + ",a^b=" + Integer.toBinaryString(a ^ b));

        //2）与0相异或值不变 例如：1010 1110 ^ 0000 0000 = 1010 1110
        System.out.println("2）与0相异或值不变");
        a = Integer.parseInt("10101110", 2);
        b = Integer.parseInt("00000000", 2);
        System.out.println("a^b=" + (a ^ b) + ",a^b=" + Integer.toBinaryString(a ^ b));

        //3)交换两个数
        a = 5;
        b = 2;
        System.out.println("a=5,a=" + Integer.toBinaryString(a));
        System.out.println("b=2,b=" + Integer.toBinaryString(b));
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=2,a=" + Integer.toBinaryString(a));
        System.out.println("b=5,b=" + Integer.toBinaryString(b));
    }
}
