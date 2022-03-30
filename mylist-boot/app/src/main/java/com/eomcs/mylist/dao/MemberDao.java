package com.eomcs.mylist.dao;

import org.apache.ibatis.annotations.Mapper;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;
=======
>>>>>>> 7d3b44b0e571869df2bc955039281c445cd58f14
import com.eomcs.mylist.domain.Member;

@Mapper  
public interface MemberDao {

  int insert(Member member);

<<<<<<< HEAD
  Member findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

=======
>>>>>>> 7d3b44b0e571869df2bc955039281c445cd58f14
  //  List<Member> findAll();
  //
  //  Member findByNo(int no);
  //
  //  int update(Member member);
  //
  //  int delete(int no);

}











