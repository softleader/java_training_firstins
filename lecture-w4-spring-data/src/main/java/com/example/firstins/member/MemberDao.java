package com.example.firstins.member;


import java.util.List;

import com.example.firstins.common.AbstractDao;

public interface MemberDao extends AbstractDao<Member> {

	List<Member> findByName(String name);

}
