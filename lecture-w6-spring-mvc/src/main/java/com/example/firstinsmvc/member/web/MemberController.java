package com.example.firstinsmvc.member.web;

import com.example.firstinsmvc.common.Detail;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstinsmvc.member.entity.Member;
import com.example.firstinsmvc.member.service.MemberService;

@CrossOrigin // 因為spring-mvc與view啟動的origin不同，要允許Cross-Origin Resource Sharing. (https://www.baeldung.com/spring-cors)
@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping
	public ResponseEntity<List<Member>> query() {
		return ResponseEntity.ok(memberService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Member> query(@PathVariable Long id) {
		final Member member = memberService.getOne(id).orElseThrow(() -> new RuntimeException("data not found, id:" + id));

		return ResponseEntity.ok(member);
	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody Member member) {
		final Detail detail = memberService.validation(member);
		if (StringUtils.isEmpty(detail.getMessage())) {
			detail.setStatusCode("200");
			detail.setData(memberService.insert(member));
			return ResponseEntity.ok(detail);
		}
    return ResponseEntity.badRequest().body(detail);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Member member) {
    final Detail detail = memberService.validation(member);
    if (StringUtils.isEmpty(detail.getMessage())) {
			detail.setStatusCode("200");
			detail.setData(memberService.update(member));
			return ResponseEntity.ok(detail);
    }
    return ResponseEntity.badRequest().body(detail);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestBody Member member) {
		memberService.delete(member);
		return ResponseEntity.ok().build();
	}

}
