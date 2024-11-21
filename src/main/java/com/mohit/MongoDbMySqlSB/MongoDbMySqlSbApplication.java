package com.mohit.MongoDbMySqlSB;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@SpringBootApplication
public class MongoDbMySqlSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbMySqlSbApplication.class, args);
	}
	
	@Bean
	public DataSource dataSource() {
		JndiDataSourceLookup sourceLookup = new JndiDataSourceLookup();
		sourceLookup.setResourceRef(true);
		DataSource dataSource = sourceLookup.getDataSource("MySqlSB");
		return dataSource;
	}
	

}
