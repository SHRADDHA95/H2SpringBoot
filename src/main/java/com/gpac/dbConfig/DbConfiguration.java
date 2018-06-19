package com.gpac.dbConfig;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource(value = "classpath:application.properties")
@Import(DatasourceConfigBean.class)
public class DbConfiguration {

	@Autowired
	private DatasourceConfigBean config;
	@Autowired Environment environment; 

	//@Bean("dataSource")
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println("TEST : "+ environment.getProperty("spring.jpa.hibernate.ddl-auto"));
		dataSource.setDriverClassName(config.getDriverClassName());
		dataSource.setUrl(config.getUrl());
		dataSource.setUsername(config.getUsername());
		dataSource.setPassword(config.getPassword());
		return dataSource;
	}

	//@Bean("hibernateProperties")
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", config.getDialect());
		properties.put("hibernate.show_sql", config.isShowSql());
		properties.put("hibernate.hbm2ddl", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.current_session_context_class", "thread");
		return properties;
	}
	
	@Bean
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

	@Bean("sessionFactory")
	public LocalSessionFactoryBean hibernateSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setPackagesToScan("com.gpac.model");
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
}
