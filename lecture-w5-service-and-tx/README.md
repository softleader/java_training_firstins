# Service & Transaction

## Prerequisite

從 [https://start.spring.io/](https://start.spring.io/) 產生專案:

- *Group* - `tw.com.firstins`
- *Artifact* - `week5`
- *Dependencies* - `Lombok`, `H2`, `JPA`

產生後以 Maven 專案匯入 Eclipse

### Entity

- 建立 package: `tw.com.firstins.week5.entity`
- 建立 Class: `tw.com.firstins.week5.entity.Member`, 包含
	- @Id @GeneratedValue Long id
	- String name

### Dao

- 建立 package: `tw.com.firstins.week5.dao`
- 建立 Class: `tw.com.firstins.week5.dao.MemberDao`, 包含
	- 以 Name 查詢多筆資料

## @Service

- 建立 package: `tw.com.firstins.week5.service`
- 建立 Class: `tw.com.firstins.week5.dao.MemberService`
- 調整 log 等級, 將 `org.springframework.beans` 改為 *debug*


### versus

- *ListableBeanFactory* vs. *@Autowired*
- *ConfigurableBeanFactory.SCOPE_SINGLETON* vs. *SCOPE_PROTOTYPE*
- *ScopedProxyMode.DEFAULT* vs. *TARGET_CLASS*

## AOP

[AOP Alliance (Java/J2EE AOP standards)](http://aopalliance.sourceforge.net/)

### How Spring implements AOP?

- 建立 package: `tw.com.firstins.week5.aop`
- 建立 Class: `tw.com.firstins.week5.aop.Say` with main method

	```java
	public void greeting() {
	  System.out.println("Hi");
	}
	```

該如何在印出 *Hi* 之前加入 *Shake hands* 及之後加入 *Bye* 呢?

## @Transactional

### propagation
