/**
 * java -XX:+PrintCommandLineFlags -version
 *
 * -XX:InitialHeapSize=199570112 -XX:MaxHeapSize=3193121792 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndivi
 * dualAllocation -XX:+UseParallelGC
 *
 * 无锁状态
 com.servi.study.juc._37_sync_principle.T object internals:
 OFFSET  SIZE   TYPE DESCRIPTION                         VALUE
 0     4        (object header)  markword                01 00 00 00 (00000001 00000000 00000000 00000000) (1)
 4     4        (object header)  markword                00 00 00 00 (00000000 00000000 00000000 00000000) (0)
 8     4        (object header)  class pointer           43 c1 00 f8 (01000011 11000001 00000000 11111000) (-134168253)
 12     4        (loss due to the next object alignment)  padding
 Instance size: 16 bytes
 Space losses: 0 bytes internal + 4 bytes external = 4 bytes total

 mark work 8个字节
 classpointer 4个字节


 加上虚拟机参数 -XX:-UseCompressedClassPointers
 com.servi.study.juc._37_sync_principle.T object internals:
 OFFSET  SIZE   TYPE DESCRIPTION                                 VALUE
 0     4        (object header)    markword                      01 00 00 00 (00000001 00000000 00000000 00000000) (1)
 4     4        (object header)    markword                      00 00 00 00 (00000000 00000000 00000000 00000000) (0)
 8     4        (object header)    class pointer                 c0 34 f6 19 (11000000 00110100 11110110 00011001) (435565760)
 12     4        (object header)   class pointer                 00 00 00 00 (00000000 00000000 00000000 00000000) (0)
 Instance size: 16 bytes
 Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
 */
package com.servi.study.juc._37_sync_principle;

import org.openjdk.jol.info.ClassLayout;

public class T01 {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o ).toPrintable());
    }
}
