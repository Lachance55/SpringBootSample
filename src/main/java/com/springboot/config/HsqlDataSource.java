package com.springboot.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Profile("hsql")
@Configuration
public class HsqlDataSource {

	//jdbc:hsqldb:mem:testdb
	@Bean
	public DataSource dataSource() {
		
		// Nerede kapatıldığı bi kontrol edilse iyi olur
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL).addScript("create-db.sql").addScript("insert-data.sql").build();
		return db;
	}

}