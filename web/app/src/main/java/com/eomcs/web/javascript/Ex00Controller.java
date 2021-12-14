package com.eomcs.web.javascript;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex00Controller {

  @RequestMapping("/javascript/ex01/exam05_1")
  public Object exam05_1() {
    return "console.log('okok)"; // UI 조각을 만들어 던진다!
  }

  @RequestMapping("/javascript/ex00/exam05_2")
  public Object exam05_2() {
    String[] names = {"홍길동", "임꺽정", "유관순"}; 
    return names; // 클라이언트에 보내는 것은 UI가 아니라 데이터를 만드는 것이다
  }
}
