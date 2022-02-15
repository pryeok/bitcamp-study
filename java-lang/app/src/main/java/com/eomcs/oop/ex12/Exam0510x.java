// 메서드 레퍼런스 - 스태틱 메서드 레퍼런스
package com.eomcs.oop.ex12;

public class Exam0510x {

  static class MyCalculator {
    public static int plus(int a, int b) {return a + b;}
    public static int minus(int a, int b) {return a - b;}
    public static int multiple(int a, int b) {return a * b;}
    public static int divide(int a, int b) {return a / b;}
  }

  interface Calculator {
    int compute(int x, int y);
  }

  public static void main(String[] args) {
    // 메서드 한 개짜리 인터페이스의 구현체를 만들 때,

    // 1) 로컬 클래스 활용
    class Calculatorimpl implements Calculator {
      @Override
      public int compute(int x, int y) {
        return MyCalculator.plus(x, y);
      }
    }
    Calculatorimpl c1 = new Calculatorimpl();
    System.out.println(c1.compute(200, 17));

    // 2) 익명 클래스 활용
    Calculator c2 = new Calculator() {
      @Override
      public int compute(int x, int y) {
        return MyCalculator.plus(x, y);
      }
    };

    System.out.println(c2.compute(200, 17));

    // 3) 람바 문법 활용
    Calculator c3 = (x, y) -> MyCalculator.plus(x, y);

    System.out.println(c3.compute(200, 17));

    // 4) 스태틱 메서드 레퍼런스
    Calculator c4 = MyCalculator::plus;

    System.out.println(c4.compute(200, 17));

  }
}


