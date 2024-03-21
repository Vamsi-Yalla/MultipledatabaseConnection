package com.exmaple.miltipledatabase.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.exmaple.miltipledatabase.model.Order_Service;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "orderEnityManagerFactory", 
basePackages = "com.exmaple.miltipledatabase.postgres.repository", transactionManagerRef = "orderTransaction")
public class OrderPostgresConfig {

 @Primary
 @Bean(name = "orderdatasorce")	
 @ConfigurationProperties(prefix = "spring.order.datasource")
 public DataSource dataSource() {
	return DataSourceBuilder.create().build();
}	
 @Primary
 @Bean(name ="orderEnityManagerFactory" )
 public LocalContainerEntityManagerFactoryBean eniManagerFactoryBean(@Qualifier("orderdatasorce")DataSource dataSource, EntityManagerFactoryBuilder entityBuilder) {
//	 Map<String,Object> properties= new HashMap<>();
//		properties.put("hibernate.hbm2ddl.auto","update");
//		properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect ");
	 return entityBuilder.dataSource(dataSource).
			 //properties(properties).
			 packages(Order_Service.class).persistenceUnit("orderDB").build();
}
 @Primary
 @Bean(name = "orderTransaction")
 public PlatformTransactionManager transactionManager(@Qualifier("orderEnityManagerFactory") EntityManagerFactory enitityFactory) {
	return new JpaTransactionManager(enitityFactory);
}
 
}
