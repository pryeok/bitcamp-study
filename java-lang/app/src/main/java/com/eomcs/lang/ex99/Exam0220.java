package com.eomcs.lang.ex99;

//# 키보드 입력 받기 - 문자열 한 줄 읽기
//
public class Exam0220 {
  public static void main(String[] args) {
    java.io.InputStream keyboard = System.in;
    java.util.Scanner keyboardScanner = new java.util.Scanner(keyboard);


    System.out.print("이름? ");
    System.out.println(keyboardScanner.nextLine());
    System.out.print("전화? ");
    System.out.println(keyboardScanner.nextLine());
    System.out.print("이메일? ");
    System.out.println(keyboardScanner.nextLine());
    System.out.print("나이? ");
    System.out.println(keyboardScanner.nextLine());
    System.out.print("재직여부? ");
    System.out.println(keyboardScanner.nextLine());

    keyboardScanner.close();
  }
}

