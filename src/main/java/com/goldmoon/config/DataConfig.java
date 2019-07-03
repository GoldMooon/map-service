package com.goldmoon.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EntityScan(
        basePackageClasses = {Jsr310JpaConverters.class}
)
@EnableJpaRepositories(
        basePackages = "com.goldmoon", entityManagerFactoryRef = "masterEntityManagerFactory"
)
@EnableJpaAuditing
public class DataConfig {

    @Primary
    @Bean(name = "masterDataSource")
    public DataSource masterDataSource() {
        return new HikariDataSource(this.hikariConfig());
    }

    @Bean(name = "hikariConfig")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Primary
    @Bean("masterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory(@Qualifier("masterDataSource") DataSource masterDataSource, JpaVendorAdapter jpaVendorAdapter) {
        return this.createEntityManagerFactoryBean(masterDataSource(), jpaVendorAdapter(), "com.goldmoon", "masterPU");
    }

    @Primary
    @Bean("masterEntityManager")
    public EntityManager masterEntityManager(@Qualifier("masterEntityManagerFactory") EntityManagerFactory masterEntityManagerFactory) {
        return masterEntityManagerFactory.createEntityManager();
    }

    @Primary
    @Bean("transactionManager")
    PlatformTransactionManager masterTransactionManager(@Qualifier("masterEntityManagerFactory") EntityManagerFactory masterEntityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(masterEntityManagerFactory);
        return jpaTransactionManager;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setDatabase(Database.H2);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        return hibernateJpaVendorAdapter;
    }

    private LocalContainerEntityManagerFactoryBean createEntityManagerFactoryBean(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter, String packagesToScan, String persistenceUnitName) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setJpaVendorAdapter(jpaVendorAdapter);
        em.setPackagesToScan(packagesToScan);
        em.setPersistenceUnitName(persistenceUnitName);
        return em;
    }
}