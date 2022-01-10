package com.eomcs.mylist.controller;

import java.io.FileWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList;

//1) 생성자에서 FileReader 객체를 준비한다.
//2) 파일에서 문자를 읽어 출력한다.
//3) 파일을 더이상 읽을 수 없으면 반복문을 종료한다.
//4) 파일에서 읽은 문자를 버퍼에 담았다가 줄바꿈 코드를 만나면 출력한다. 
//5) 한 줄 출력한 다음에 버퍼를 비운다.
//6) 한 줄의 CSV 데이터를 읽어 분석한 후 Contact 객체에 담아서 목록에 추가한다.
//7) CSV 데이터로 Contact 객체를 초기화시키는 일을 Contact 객체의 생성자로 옮긴다.
//8) Contact 클래스의 valueOf() 스태틱 메서드를 사용하여 CSV 데이터로 객체를 생성한다.
//9) while 문 정리!
//
@RestController 
public class TodoController {

  ArrayList todoList;

  public TodoController() throws Exception {
    todoList = new ArrayList();
    System.out.println("TodoController() 호출됨!");

    com.eomcs.io.FileReader2 in = new com.eomcs.io.FileReader2("todos.csv");

    StringBuilder buf = new StringBuilder();
    int c;
    while ((c = in.read()) != -1) {// 파일에서 한 문자를 읽는다. 더이상 읽을 문자가 없으면 반복문을 종료하다.
      if (c == '\n') { // 만약 읽은 문자가 줄바꿈 명령이라면, 지금까지 읽은 CSV 데이터를 분석하여 Contact 객체에 담는다.
        todoList.add(Todo.valueOf(buf.toString())); // 파일에서 읽은 CSV 데이터로 객체를 초기화시킨후 목록에 등록한다.
        buf.setLength(0); // 다음 데이터를 읽기 위해 버퍼를 초기화시킨다.

      } else { // 문자를 읽을 때 마다 버퍼이 임시 보관한다.
        buf.append((char) c);
      }
    }

    in.close();
  }
  @RequestMapping("/todo/list")
  public Object list() {
    return todoList.toArray(); 
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) {
    todoList.add(todo);
    return todoList.size();
  }

  @RequestMapping("/todo/update")
  public Object update(int index, Todo todo) {
    if (index < 0 || index >= todoList.size()) {
      return 0;
    }

    Todo old = (Todo) todoList.get(index);
    todo.setDone(old.isDone()); // 기존의 체크 정보를 그대로 가져가야 한다.

    return todoList.set(index, todo) == null ? 0 : 1;
  }

  @RequestMapping("/todo/check")
  public Object check(int index, boolean done) {
    if (index < 0 || index >= todoList.size()) {
      return 0;  // 인덱스가 무효해서 설정하지 못했다.
    }

    ((Todo) todoList.get(index)).setDone(done);
    return 1; // 해당 항목의 상태를 변경했다.
  }

  @RequestMapping("/todo/delete")
  public Object delete(int index) {
    if (index < 0 || index >= todoList.size()) {
      return 0;
    }

    todoList.remove(index);
    return 1;
  }

  @RequestMapping("/todo/save")
  public Object save() throws Exception {
    FileWriter out = new FileWriter("todos.csv"); // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 생성된다.

    Object[] arr = todoList.toArray();
    for (Object obj : arr) {
      Todo todo = (Todo) obj;
      out.write(todo.toCsvString() + "\n");
    }

    out.close();
    return arr.length;
  }
}







