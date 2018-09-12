# Service & Transaction

## Prerequisite

#### Create Project

從 [https://start.spring.io/](https://start.spring.io/) 產生專案:

- *Group* - `tw.com.firstins`
- *Artifact* - `week5`
- *Dependencies*
	- `Lombok`
	- `H2`
	- `JPA`

產生後以 Maven 專案匯入 Eclipse

#### Create Entity

- 建立 package: `tw.com.firstins.week5.entity`
- 建立 class: `tw.com.firstins.week5.entity.Member`, 包含以下 field
	- @Id @GeneratedValue Long id
	- String name

#### Create Dao

- 建立 package: `tw.com.firstins.week5.dao`
- 建立 interface: `tw.com.firstins.week5.dao.MemberDao`, 包含以下 method
	- 以 Name 查詢多筆 Member 資料

## @Service

Service 是一種 Component, Spring Framework 在啟動時會掃描所有 Component, 建立成 Bean 並管理其生命週期, 程式調用等所有事宜

- 建立 package: `tw.com.firstins.week5.service`
- 建立 class: `tw.com.firstins.week5.service.MemberService`
- 調整 log 等級:
	- 將 `org.springframework` 改為 warm
	- 將 `org.springframework.beans` 改為 *debug*

> [Common application properties](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#common-application-properties)

#### Retrieve Bean

- *ListableBeanFactory*
- *@Autowired*

#### Life Cycle

- *InitializingBean*
- *DisposableBean*
- *@PostConstruct*
- *@PreDestroy*

#### @Scope

- *ConfigurableBeanFactory.SCOPE_SINGLETON* 
- *ConfigurableBeanFactory.SCOPE_PROTOTYPE*
- *ScopedProxyMode.DEFAULT*
- *ScopedProxyMode.TARGET_CLASS*

## AOP

[AOP Alliance (Java/J2EE AOP standards)](http://aopalliance.sourceforge.net/)

### How Spring implements AOP?

- 建立 package: `tw.com.firstins.week5.aop`
- 建立 class: `tw.com.firstins.week5.aop.Say` with main method

	```java
	public void greeting() {
	  System.out.println("Hi");
	}
	```

該如何在印出 *Hi* 之前加入 *Shake hands* 及之後加入 *Bye* 呢?

## @Transactional

- 調整 log 等級:
	- 將 `org.springframework.orm.jpa.JpaTransactionManager` 開成 *debug*

### propagation

- 建立 class: `tw.com.firstins.week5.service.RegistryService`

| 常用 Propagation | 說明 |
|-----|-----|
| REQUIRED | 沿用當前 Tx，當前沒有則建立新的 Tx |
| REQUIRES_NEW | 建立新的 Tx, 若當前有 Tx 則將之暫停 |
| SUPPORTS | 沿用當前的 Tx, 若當前沒有則不啟動 Tx |

### Exception Controls

故意在 `tw.com.firstins.week5.service.RegistryService#registry` 中製造例外:

```java
System.out.println(1 / 0);
```

