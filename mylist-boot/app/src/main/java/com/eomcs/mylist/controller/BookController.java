package com.eomcs.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController 
public class BookController {

  ArrayList bookList;

  public BookController() throws Exception {
    bookList = new ArrayList();
    System.out.println("BookController() 호출됨!");

    try {

      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("books.ser2")));

      // 목록이 통째로 serialize 되었을 경우, 한 번에 목록을 읽으면 된다.
      bookList = (ArrayList) in.readObject(); // 단 기존의 생성한 ArrayList 객체는 버린다.
      in.close();

    } catch (Exception e) {   //try 돌려보다가 예외가 catch(발견)되었을 때 break !!
      System.out.println("도서록 데이터를 로딩하는 중 오류 발생!");
    }
  }

  @RequestMapping("/book/list")
  public Object list() {
    return bookList.toArray(); 
  }

  @RequestMapping("/book/add")
  public Object add(Book book) {
    bookList.add(book);
    return bookList.size();
  }


  @RequestMapping("/book/get")
  public Object get(int index) {
    if (index < 0 || index >= bookList.size()) {
      return "";
    }
    return bookList.get(index);
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.set(index, book) == null ? 0 : 1;
  }

  @RequestMapping("/book/delete")
  public Object delete(int index) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.remove(index) == null ? 0 : 1;
  }

  @RequestMapping("/book/save")
  public Object save() throws Exception {

    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("books.ser2")));

    // 목록 자체를 serialize 할 수도 있다
    out.writeObject(bookList);

    out.close();
    return bookList.size();
  }
}





