// 바이너리(binary) 파일을 텍스트 형식으로 저장하기
package com.eomcs.io.ex15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;

public class Exam0110 {
  public static void main(String[] args) throws Exception {

    Encoder encoder = Base64.getEncoder();

    File file = new File("./temp/ok_6351.jpg");
    FileInputStream in = new FileInputStream(file);
    FileWriter out = new FileWriter("./temp/photo.txt");

    byte[] buf = new byte[(int) file.length()];
    int len = in.read(buf);
    System.out.printf("읽은 바이트 수: %d\n", len);

    // 바이트 배열에 저장된 바이너리 데이터를 텍스트로 변환하기
    String encodedStr = encoder.encodeToString(Arrays.copyOf(buf, len));

    // 텍스트로 변환된 데이터를 파일로 출력하기
    out.write(encodedStr);

    in.close();
    out.close();

  }
}

// Base64 인코딩
// => 바이너리 데이터를 문자화시킨다.
// => 바이너리 값을 6비트식 잘라서(2의 6승) 
//    64진수(0 ~ 63)으로 만든 후 Base64 표에 정의된 대로
//    해당 값을 문자로 변환한다.
// => 보통 바이너리 데이터를 텍스트로 전송하고 싶을 때 많이 사용한다.
// => "ABC012가간" 문자열
//    414243303132EAB080EAB081(UTF-8 코드)
//    4142 ==> 0100000101000010... (2진수)
//    010000 010100 0010... (6비트씩 자른 것)
//    6비트로 자른 것을 다시 10진수로 표현하면 ==> 16 20 ...
//    16을 Base64 코드표에 따라 문자로 바꾸면 ==> Q
//    20을 Base64 코드표에 따라 문자로 바꾸면 ==> U
//  => 8bit -> 7bit = 네트워킹에서 8bit로 불가능할 때 7bit로 바꾸기 위해 Base64를 사용한다
//    ...
//    이런 식으로 문자열을 Base64로 바꾸면 결과는 다음과 같다.
//    QUJDMDEy6rCA6rCB6rCE