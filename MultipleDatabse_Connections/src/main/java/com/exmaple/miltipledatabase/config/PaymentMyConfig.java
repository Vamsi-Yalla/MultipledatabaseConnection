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
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.exmaple.miltipledatabase.model.Payment_Service;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", 
basePackages = "com.exmaple.miltipledatabase.mySql.repository", transactionManagerRef = "paymentTransaction")
public class PaymentMyConfig {
	
	
    @Bean(name = "datasource")
	@ConfigurationProperties(prefix = "spring.payment.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}


	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean eniManagerFactoryBean(EntityManagerFactoryBuilder builder,@Qualifier("datasource") DataSource dataSource) {
//		Map<String,Object> properties= new HashMap<>();
//		properties.put("hibernate.hbm2ddl.auto","update");
//		properties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		return builder.dataSource(dataSource).
				//properties(properties).
				packages(Payment_Service.class).persistenceUnit("paymentDb").build();
	}
	
	
	@Bean(name = "paymentTransaction")
	public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory eniEntityManagerFactory) {
		return new JpaTransactionManager(eniEntityManagerFactory);
	}
	
}
