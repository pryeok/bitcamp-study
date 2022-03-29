package com.eomcs.mylist.dao;

import org.apache.ibatis.annotations.Mapper;
import com.eomcs.mylist.domain.Member;

@Mapper  
public interface MemberDao {

  int insert(Member Member);

  //  List<Member> findAll();
  //
  //  Member findByNo(int no);
  //
  //  int update(Member Member);
  //
  //  int delete(int no);

}


