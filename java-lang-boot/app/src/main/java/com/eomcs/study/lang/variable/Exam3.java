// 변수 : 값을 저장할 메모리를 준비시키는 명령어
package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam3") // 클래스 이름이 같은 경우 충돌 방지
@RequestMapping("/lang/variable/exam3")
public class Exam3 {

  //변수 선언
  // 값을 저장할 메모리를 준비시키는 명령문
  @GetMapping("/test1")
  public String test1(String name, String tel, String gender) {
    return "클라이언트에게 받은 값 = " + name + "," + tel+ "," + gender;
  }


  // => http://localhost:8080/lang/variable/exam1/test2?b=100&s=32767&i=2100000000&l=9220000000000000000
  @GetMapping("/test2")
  public String test2(byte b, short s, int i, long l) {
    return "클라이언트에게 받은 값 = " + b + "," + s + "," + i + "," + l;
  }

  //부동소수점 변수 선언과 값의 범위
  //부동소수점 값을 저장하는 메모리를 준비시키는 명령문
  //메모리 크기에 따른 값의 유효범위
  // => http://localhost:8080/lang/variable/exam1/test3?f=987.6544&d=4375893.4389545645
  @GetMapping("/test3")
  public String test3(float f, double d) {
    return "클라이언트에게 받은 값 = " + f + " , " + d;
  }

  // => http://localhost:8080/lang/variable/exam3/test4?c=%EA%B0%81
  @GetMapping("/test4")
  public String test4(char c) {
    return "클라이언트에게 받은 값 = " + c;
  }

}
