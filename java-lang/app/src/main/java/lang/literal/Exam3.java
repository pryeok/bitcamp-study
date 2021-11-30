// 리터럴: 정수 리터럴이 표현할 수 있는 값의 범위
package lang.literal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lang/literal/exam3")
public class Exam3 {

  @GetMapping("/test1")
  public String test1() {
    return "정수: " + 21_4748_3647;
    // 문자열과 숫자를 더하면?
    // => 문자열 + (숫자 --> 문자열) = 한 개의 문자열로 합친다.
  }

}



