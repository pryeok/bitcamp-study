
package com.eomcs.study.lang.variable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("lang.variable.exam1") // 클래스 이름이 강튼 경우 충돌 방지
@RequestMapping("/literal/variable/exam1")
public class Exam1 {

  @GetMapping("/test1")
  public String test1(String name, String tel, String gender) {
    return "클라이언트에게 받은 값 = " + name + "," + tel + "," + gender;
  }
}
