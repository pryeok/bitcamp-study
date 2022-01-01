package com.eomcs.oop.ex02;

// # 사용자 정의 데이터 타입 + 클래스 메서드
//
public class Exam0120 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;

    // Score 데이터 값을 다룰 수 있는 새 연산자를 정의해 보자.
    // - 다음 메서드는 Score 객체의 국,영,수 값의 합계와 평균을 계산하는 연산자이다.
    public static void calculate(Score score) {
      score.sum = score.kor + score.eng + score.math;
      score.average = score.sum / 3f;
    }

  }

  public static void main(String[] args) {

    Score s = new Score();
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 90;
    s.math = 85;

    // 다음은 Score의 값을 다루는 연산자가 없을 때의 예이다.
    // core.sum = score.kor + score.eng + score.math; 0
    // score.average = score.sum / 3f;

    // 사용자 정의 데이터 타입의 값을 연산자를 사용하여 다뤄보자!
    Score.calculate(s);

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.average);
  }
}

