package com.example.firstinsmvc.member.dao;


import java.util.List;

import com.example.firstinsmvc.common.AbstractDao;
import com.example.firstinsmvc.member.entity.Member;

public interface MemberDao extends AbstractDao<Member> {

	List<Member> findByName(String name);

}
