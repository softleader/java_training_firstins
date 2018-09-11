package com.example.firstins.member.dao;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.firstins.common.AbstractDao;
import com.example.firstins.member.entity.Member;

public interface MemberDao extends AbstractDao<Member> {

	List<Member> findByName(String name);

	@Query("SELECT m FROM Member m WHERE m.name = ?1")
	List<Member> findByNameJpqlSample(String name);

	@Query(value = "SELECT * FROM MEMBER WHERE NAME = ?1", nativeQuery = true)
	List<Member> findByNameNativeSample(String name);

}
