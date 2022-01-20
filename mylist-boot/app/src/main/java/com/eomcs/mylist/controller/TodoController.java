package com.eomcs.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList;

@RestController 
public class TodoController {

  ArrayList todoList;

  public TodoController() throws Exception {
    todoList = new ArrayList();
    System.out.println("TodoController() 호출됨!");

    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("todos.ser2")));

      // 목록이 통째로 serialize 되었을 경우, 한 번에 목록을 읽으면 된다.
      todoList = (ArrayList) in.readObject();  // 단 기존의 생성한 ArrayList 객체는 버린다.
      in.close();

    } catch (Exception e) {
      System.out.println("해야할 일 데이터를 로딩하는 중 오류 발생!");
    }
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

    todoList.remove(index); // 메서드 이름으로 코드의 의미를 짐작할 수 있다. 이것이 메서드로 분리하는 이유이다.
    return 1;
  }

  @RequestMapping("/todo/save")
  public Object save() throws Exception {

    // 데이터를 바이너리 형식으로 저장하기 위해 !!!
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("todos.ser2")));

    // 다음과 같이 목록 자체를 serialize 할 수도 있다
    out.writeObject(todoList);

    out.close();
    return todoList.size();
  }
}






