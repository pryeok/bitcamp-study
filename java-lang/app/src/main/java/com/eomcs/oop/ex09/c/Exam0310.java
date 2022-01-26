// 디폴트 메서드의 다중 구현
package com.eomcs.oop.ex09.c;


public class Exam0310 {

  interface ProtocolA {
    void rule1();
    default void rule3() {
      System.out.println("**ProtocolA.rule3()**");
    }
  }

  interface ProtocolB {
    void rule2();
    default void rule3() {
      System.out.println("====> ProtocolB.rule3()");
    }
  }

  static class ProtocolImpl implements ProtocolA, ProtocolB {
    // ProtocolA 규칙 준수!
    @Override
    public void rule1() {
      System.out.println("ProtocolImpl.rule1()");
    }

    // ProtocolB 규칙 준수!
    @Override
    public void rule2() {
      System.out.println("ProtocolImpl.rule2()");
    }

    @Override
    public void rule3() {
      System.out.println("ProtocolImpl.rule3()");
    }
  }

  public static void main(String[] args) {
    ProtocolImpl obj = new ProtocolImpl();
    obj.rule1();
    obj.rule2();
    obj.rule3();
  }
}







