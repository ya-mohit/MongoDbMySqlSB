package com.mohit.MongoDbMySqlSB;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class DatabaseConfigure {

	@Bean
	public DataSource dataSource() {
		JndiDataSourceLookup sourceLookup = new JndiDataSourceLookup();
		sourceLookup.setResourceRef(true);
		DataSource dataSource = sourceLookup.getDataSource("MySqlSB");
		return dataSource;
	}
	
	@Bean
	MongoClient mongoClient() throws NamingException{
		Context context = (Context) new InitialContext().lookup("java:comp/env");
		String connectionString = (String) context.lookup("MONGODB_URI");
		
		MongoClient mongoClient = MongoClients.create(connectionString);
		return mongoClient;
	}

	@Bean
	MongoTemplate mongoTemplate(MongoClient mongoClient) {
		return new MongoTemplate(mongoClient, "springBoot");		//Database Name
	}

//For MongoDB ->
	//server.xml :
		//<Environment name="MONGODB_URI" override="false" type="java.lang.String" 
		//value="mongodb+srv://USER:PASSWORD@cluster0.tsoxa.mongodb.net/DATABASENAME?retryWrites=true&amp;w=majority&amp;appName=CLUSTERNAME"/>
		
	
//For MySql ->
	//Add below property in context.xml
	//<ResourceLink name="Media" global="Media" type="javax.sql.DataSource" />
	
	//Add below property in <GlobalNamingResources> tag of server.xml
	//<Resource auth="Container" driverClassName="com.mysql.cj.jdbc.Driver" name="Media" password="Mysql@123" type="javax.sql.DataSource" url="jdbc:mysql://localhost:3306/sys" username="root"/>

}