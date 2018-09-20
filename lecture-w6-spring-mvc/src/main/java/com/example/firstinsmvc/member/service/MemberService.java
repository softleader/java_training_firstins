package com.example.firstinsmvc.member.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstinsmvc.member.dao.MemberDao;
import com.example.firstinsmvc.member.entity.Member;

@Service
public class MemberService {

	@Autowired
	private MemberDao memberDao;

	public List<Member> getAll() {
		return memberDao.findAll();
	}

	public Optional<Member> getOne(Long id) {
		Objects.requireNonNull(id, "ID is null");
		return memberDao.findById(id);
	}

	public Member insert(Member member) {
		member.setId(null);
		return memberDao.save(member);
	}

	public Member update(Member member) {
		final Long id = Objects.requireNonNull(member.getId(), "id is required");
		// 因JPA Session的特性，建議不要使用非persistent狀態外的物件進行update
		// 因此此處會從db撈，並將可以更改的欄位寫入後儲存
		final Member dbMember = memberDao.findById(id).orElseThrow(() -> new RuntimeException("member not found, id:" + id));
		dbMember.setEmpNo(member.getEmpNo());
		dbMember.setName(member.getName());
		// 同上，因為JPA Session的特性，其實此處的save只有flush的作用
		return memberDao.save(dbMember);
	}

	public void delete(Member member) {
		final Long id = Objects.requireNonNull(member.getId(), "id is required");
		final Member dbMember = memberDao.findById(id).orElseThrow(() -> new RuntimeException("member not found, id:" + id));
		memberDao.delete(dbMember);
	}

}
