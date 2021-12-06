package com.eomcs.lang.ex04;

//# 값 저장과 메모리 크기 - 작은 크기의 메모리 값을 큰 크기의 메모리에 저장할 수 있다.
//
public class Exam0910 {
  public static void main(String[] args) {

    byte b = 100; // 1byte
    short v1 = b; // 1byte ==> 2byte

    short s = 100; // 2byte (-32768 ~ 32767)
    int v2 = s; // 2byte ==> 4byte

    int i = 98765678; // 4byte (-21억 ~ +21억)
    long v3 = i; // 4byte ==> 8byte

    long l = 98765678; // 8byte(-922경 ~ 922경)

    char c = 100; // 2byte
    // short x1 = c; //  char(0 ~ 65535) ==> short(-327678 ~ 32767) // 값의 범위가 맞지 않아 컴파일 오류!!!!!
  }
}