package com.eomcs.lang.ex04;

//# 배열 - 배열 레퍼런스와 null
//
public class Exam0551 {
  public static void main(String[] args) {

    int[] arr1;
    arr1 = new int[5];

    // 배열 레퍼런스를 초기화시키고 싶다면 null로 설정하라.
    arr1 = null; // 0으로 설정. 즉 레퍼런스가 아무것도 가리키지 않음을 의미.  
    // 즉 쓸모가 없어져버린 arr1은 garbage가 되고 쌓인 garbage는 garbage collector가 수거해 간다 !!

    // 레퍼런스가 배열 인스턴스를 가리키지 않은 상태에서 사용하려 하면?
    System.out.println(arr1[0]); // NullPointerException 실행 오류!
  }
}
