package com.example.firstinsmvc.member.dao;


import java.math.BigDecimal;
import java.util.List;

import com.example.firstinsmvc.common.AbstractDao;
import com.example.firstinsmvc.member.entity.Member;

public interface MemberDao extends AbstractDao<Member> {

	List<Member> findByName(String name);

	Member findByEmpNo(BigDecimal empNo);

}
