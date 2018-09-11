package com.example.firstins;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.firstins.member.dao.MemberDao;
import com.example.firstins.member.entity.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SessionTest {

	@Autowired
	private MemberDao memberDao;

	@Test
	@Commit
	@Transactional
	public void insert() {
		// data preparing
		final Member member = new Member();
		member.setName("AAA");

		// insert
		memberDao.save(member);
	}

	@Test
	@Commit
	@Transactional
	public void queryAndSet() {
		memberDao.findByName("AAA")
				.forEach(m -> m.setName("BBB"));
	}

}
