package com.goldmoon.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class QuerydslConfig {

    @PersistenceContext(unitName = "masterPU")
    EntityManager masterEntityManager;

    @Bean("masterJpaQueryFactory")
    public JPAQueryFactory masterJpaQueryFactory() {
        return new JPAQueryFactory(masterEntityManager);
    }

}