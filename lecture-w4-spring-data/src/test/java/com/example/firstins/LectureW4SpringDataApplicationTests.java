package com.example.firstins;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LectureW4SpringDataApplicationTests {

	@Value("spring.datasource.driver-class-name")
	private String dsJdbcDriver;

	@Value("spring.datasource.url")
	private String dsJdbcUrl;

	@Value("spring.datasource.username")
	private String dsUsername;

	@Value("spring.datasource.password")
	private String dsPassword;

	@Test
	public void test() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(dsJdbcUrl, dsUsername, dsPassword);

		final Statement statement = connection.createStatement();
	}

}
