package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 이 클래스를 인식한다.

public class T1ContactController {

  String[] rainbows = new String[7];     // 인스턴스 배열 변수
  int size = 0;

  @RequestMapping("/rainbow/list")
  public Object list() {
    String[] arr = new String[size];  // 배열에 저장된 값만 복사할 새 배열을 만든다.
    for (int i=0; i<size; i++) {
      arr[i] = rainbows[i];  //전체 배열에서 값이 들어 있는 항목만 복사한다.
    }
    return arr;  // 복사한 항목들을 담고 있는 새 배열을 리턴한다.
  }

  @RequestMapping("/rainbow/add")
  public Object add(String name, String price, String year,String grade) {
    String rainbow = name + "," + price + "," + year + "," + grade;
    rainbows[size++]= rainbow;
    return size;
  }

  @RequestMapping("/rainbow/get")
  public Object get(String name) {
    for (int i = 0; i < size; i++) {
      if (rainbows[i].split(",")[0].equals(name)) { // 예) "u1, u1@test.com, 1111, 비트캠프"
        return rainbows[i];
      }
    }        
    return "";
  }

  @RequestMapping("/rainbow/update")
  public Object update(String name, String price, String year, String grade) {
    String rainbow = name + "," + price + "," + year + "," + grade;
    for (int i = 0; i < size; i++) {
      if (rainbows[i].split(",")[1].equals(name)) { 
        rainbows[i] = rainbow;
        return 1;
      }
    }

    return 0;
  }

  @RequestMapping("/rainbow/delete")
  public Object delete(String name) {
    for (int i = 0; i < size; i++) {
      if (rainbows[i].split(",")[1].equals(name)) { // 예) "u1@test.com"
        // 현재 위치의 다음 항목에서 배열 끝까지 반복하며 앞으로 값을 당겨온다.
        for (int j = i + 1; j < size; j++) {
          rainbows[j - 1] = rainbows[j];
        }
        size--;
        return 1;
      }
    }
    return 0;
  }
}
