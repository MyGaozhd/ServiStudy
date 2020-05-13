package com.servi.study.interview;

/**
 * "C:\Program Files\Java\jdk1.8.0_91\bin\javap.exe" -c com.servi.study.interview._00
 * Compiled from "_00.java"
 * public class com.servi.study.interview._00 {
 *   public com.servi.study.interview._00();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: ldc           #2                  // String abc
 *        2: astore_1
 *        3: ldc           #3                  // String def
 *        5: astore_2
 *        6: ldc           #2                  // String abc
 *        8: astore_3
 *        9: new           #4                  // class java/lang/StringBuilder
 *       12: dup
 *       13: invokespecial #5                  // Method java/lang/StringBuilder."<init>":()V
 *       16: aload_1
 *       17: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *       20: aload_2
 *       21: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *       24: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 *       27: astore        4
 *       29: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       32: aload_1
 *       33: aload_3
 *       34: if_acmpne     41
 *       37: iconst_1
 *       38: goto          42
 *       41: iconst_0
 *       42: invokevirtual #9                  // Method java/io/PrintStream.println:(Z)V
 *       45: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       48: new           #4                  // class java/lang/StringBuilder
 *       51: dup
 *       52: invokespecial #5                  // Method java/lang/StringBuilder."<init>":()V
 *       55: aload_1
 *       56: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *       59: aload_2
 *       60: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 *       63: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 *       66: ldc           #10                 // String abcdef
 *       68: if_acmpne     75
 *       71: iconst_1
 *       72: goto          76
 *       75: iconst_0
 *       76: invokevirtual #9                  // Method java/io/PrintStream.println:(Z)V
 *       79: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       82: aload         4
 *       84: ldc           #10                 // String abcdef
 *       86: if_acmpne     93
 *       89: iconst_1
 *       90: goto          94
 *       93: iconst_0
 *       94: invokevirtual #9                  // Method java/io/PrintStream.println:(Z)V
 *       97: ldc           #2                  // String abc
 *       99: astore        5
 *      101: ldc           #3                  // String def
 *      103: astore        6
 *      105: ldc           #10                 // String abcdef
 *      107: astore        7
 *      109: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *      112: aload         7
 *      114: ldc           #10                 // String abcdef
 *      116: if_acmpne     123
 *      119: iconst_1
 *      120: goto          124
 *      123: iconst_0
 *      124: invokevirtual #9                  // Method java/io/PrintStream.println:(Z)V
 *      127: return
 * }
 *
 * Process finished with exit code 0
 */
public class _00 {
    public static void main(String[] args) {
        String a = "abc";
        String b = "def";
        String c = "abc";
        String d = a + b;
        System.out.println(a == c);//true
        System.out.println(a + b == "abcdef");//false
        System.out.println(d == "abcdef");//false

        final String e = "abc";
        final String f = "def";
        String h = e + f;

        System.out.println(h == "abcdef");//true
    }
}
