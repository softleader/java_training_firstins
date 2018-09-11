package com.example.firstinsmvc.web;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstinsmvc.member.dao.MemberDao;
import com.example.firstinsmvc.member.entity.Member;

@CrossOrigin // 因為spring-mvc與view啟動的origin不同，要允許Cross-Origin Resource Sharing. (https://www.baeldung.com/spring-cors)
@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberDao memberDao;

	@GetMapping
	public ResponseEntity<List<Member>> query() {
		return ResponseEntity.ok(memberDao.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Member> query(@PathVariable Long id) {
		final Member member = memberDao.findById(id).orElseThrow(() -> new RuntimeException("member not found, id:" + id));
		return ResponseEntity.ok(member);
	}

	@PostMapping
	public ResponseEntity<Member> insert(@RequestBody Member member) {
		member.setId(null);
		memberDao.save(member);
		return ResponseEntity.ok(member);
	}

	@PutMapping
	public ResponseEntity<Member> update(@RequestBody Member member) {
		final Long id = Objects.requireNonNull(member.getId(), "id is required");
		final Member dbMember = memberDao.findById(id).orElseThrow(() -> new RuntimeException("member not found, id:" + id));
		dbMember.setEmpNo(member.getEmpNo());
		dbMember.setName(member.getName());
		memberDao.save(dbMember);
		return ResponseEntity.ok(dbMember);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestBody Member member) {
		final Long id = Objects.requireNonNull(member.getId(), "id is required");
		final Member dbMember = memberDao.findById(id).orElseThrow(() -> new RuntimeException("member not found, id:" + id));
		memberDao.delete(dbMember);
		return ResponseEntity.ok().build();
	}

}
