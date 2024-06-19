package com.bekprotek.bekprotek.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "com.bekprotek.bekprotek.entities")
@EnableJpaRepositories("com.bekprotek.bekprotek.repositories")
public class HibernateConfig {
}