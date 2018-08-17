package com.example.firstins;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.firstins.member.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LectureW4SpringDataApplicationTests {

	@Value("${spring.datasource.driver-class-name}")
	private String dsJdbcDriver;

	@Value("${spring.datasource.url}")
	private String dsJdbcUrl;

	@Value("${spring.datasource.username}")
	private String dsUsername;

	@Value("${spring.datasource.password}")
	private String dsPassword;

	@Test
	public void jdbcExample() throws Exception {
		Class.forName(dsJdbcDriver);
		final Connection connection = DriverManager.getConnection(dsJdbcUrl, dsUsername, dsPassword);

		// Insert
		final PreparedStatement preparedStatement1 = connection
				.prepareStatement("INSERT INTO MEMBER (ID, NAME) VALUES (?, ?)");
		preparedStatement1.setLong(1, 1L);
		preparedStatement1.setString(2, "Rhys");
		final int inserted = preparedStatement1.executeUpdate();
		System.out.println("inserted row " + inserted);

		// Query
		final PreparedStatement preparedStatement2 = connection
				.prepareStatement("SELECT * FROM MEMBER");
		final ResultSet resultSet = preparedStatement2.executeQuery();
		if (resultSet.next()) {
			final Member member = new Member();
			member.setId(resultSet.getLong("id"));
			member.setName(resultSet.getString("name"));
			System.out.println(member.getId() + ")" +member.getName());
		}

	}

}
