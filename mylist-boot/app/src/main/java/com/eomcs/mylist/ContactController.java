package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 이 클래스를 인식한다.

public class ContactController {

  @RequestMapping("/contact/list")
  public Object list() {
    String[] contacts = {
        "aaa1, aaa@test.com, 1111, 비트캠프",
        "aaa2, aaa@test.com, 1111, 비트캠프",
        "aaa3, aaa@test.com, 1111, 비트캠프",
        "aaa4, aaa@test.com, 1111, 비트캠프",
        "aaa5, aaa@test.com, 1111, 비트캠프",
    };
    return contacts;
  }

  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel,String company) {
    String contact = name + "," + email + "," + tel + "," + company;
    return contact;
  }

}
