package com.eomcs.mylist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eomcs.mylist.dao.MemberDao;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.MemberService;

@Service
public class DefaultMemberService implements MemberService {

  @Autowired
  MemberDao memberDao;

  @Override
  public int add(Member member) {
    return memberDao.insert(member);
  }

<<<<<<< HEAD
  @Override
  public Member get(String email, String password) {
    return memberDao.findByEmailAndPassword(email, password);
  }

=======
>>>>>>> 7d3b44b0e571869df2bc955039281c445cd58f14
}
