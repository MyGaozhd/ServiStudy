package com.servi.study.javabase.callerclass;

public class Test {
    public static void main(String[] args) {
        new T();
        new TT();
    }

   static class TT{
        public TT(){
            new T();
        }
    }
}
