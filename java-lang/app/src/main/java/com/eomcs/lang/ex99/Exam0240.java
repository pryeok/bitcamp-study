package com.eomcs.lang.ex99;

//# 키보드 입력 받기 - 여러 종류의 데이터를 섞어 입력 받기
//
public class Exam0240 {
  public static void main(String[] args) { 
    
    java.util.Scanner keyboardScanner = new java.util.Scanner(System.in);

    System.out.print("나이? ");
    int age = keyboardScanner.nextInt();
    
    // keyboardScanner.nextLine(); // 남아 있는 빈 문자열의 한 줄(LF 코드)을 읽어서 버린다. !!!!!!!!!

    System.out.print("이름? ");
    String name = keyboardScanner.nextLine();

    keyboardScanner.close();

    System.out.printf("%d(%s)\n", age, name);
  }
}





























































