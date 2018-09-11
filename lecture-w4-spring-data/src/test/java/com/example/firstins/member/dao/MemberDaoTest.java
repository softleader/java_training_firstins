package com.example.firstins.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.firstins.member.entity.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberDaoTest {

	@Value("${spring.datasource.driver-class-name}")
	private String dsJdbcDriver;

	@Value("${spring.datasource.url}")
	private String dsJdbcUrl;

	@Value("${spring.datasource.username}")
	private String dsUsername;

	@Value("${spring.datasource.password}")
	private String dsPassword;

	@Autowired
	private MemberDao memberDao;

	@Before
	public void firstGap() {
		System.out.println("====================================================================");
	}
	@After
	public void lastGap() {
		System.out.println("====================================================================");
	}

	/**
	 * JDBC測試
	 */
	@Test
	public void jdbcExample() throws Exception {
		// connection preparing
		try (Connection connection = DriverManager.getConnection(dsJdbcUrl, dsUsername, dsPassword)) {
			// insert
			final String insertSql = "INSERT INTO MEMBER (ID, NAME) VALUES (?, ?)";
			try (PreparedStatement preparedStatement1 = connection.prepareStatement(insertSql)) {

				// insert Matt
				preparedStatement1.setLong(1, 1L);
				preparedStatement1.setString(2, "Matt");
				final int inserted1 = preparedStatement1.executeUpdate();
				System.out.println("inserted row " + inserted1);

				// insert Rhys
				preparedStatement1.setLong(1, 2L);
				preparedStatement1.setString(2, "Rhys");
				final int inserted2 = preparedStatement1.executeUpdate();
				System.out.println("inserted row " + inserted2);
			}

			// query all
			final String querySql = "SELECT * FROM MEMBER";
			try (PreparedStatement preparedStatement2 = connection.prepareStatement(querySql);
				 ResultSet resultSet = preparedStatement2.executeQuery()) {

				final List<Member> members = new ArrayList<>();
				while (resultSet.next()) {
					final Member member = new Member();
					member.setId(resultSet.getLong("id"));
					member.setName(resultSet.getString("name"));
					members.add(member);
					System.out.println(ToStringBuilder.reflectionToString(member, ToStringStyle.SHORT_PREFIX_STYLE));
				}
			}
		}

	}

	/**
	 * SpringDataJpa測試
	 */
	@Test
	public void jpaExample() {
		// data preparing
		final Member matt = new Member();
		final String mattName = "Matt";
		matt.setName(mattName);

		final Member rhys = new Member();
		final String rhysName = "Rhys";
		rhys.setName(rhysName);

		// insert
		memberDao.save(matt);
		memberDao.save(rhys);

		// query all
		memberDao.findAll().forEach(m ->
				System.out.println(ToStringBuilder.reflectionToString(m, ToStringStyle.SHORT_PREFIX_STYLE)));

		// query by rhysName
		System.out.print("Query(method):\t");
		memberDao.findByName(mattName).forEach(m ->
				System.out.println(ToStringBuilder.reflectionToString(m, ToStringStyle.SHORT_PREFIX_STYLE)));
		System.out.print("Query(jpql):\t");
		memberDao.findByNameJpqlSample(mattName).forEach(m ->
				System.out.println(ToStringBuilder.reflectionToString(m, ToStringStyle.SHORT_PREFIX_STYLE)));
		System.out.print("Query(native):\t");
		memberDao.findByNameNativeSample(mattName).forEach(m ->
				System.out.println(ToStringBuilder.reflectionToString(m, ToStringStyle.SHORT_PREFIX_STYLE)));
	}

}
