package com.optimus.nnlt.config

import com.optimus.nnlt.service.UserService
import com.optimus.nnlt.service.impl.UserServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = "com.optimus.nnlt.repository")
class JpaConfig {
    @Bean
    UserService userService() {
        return new UserServiceImpl();
    }
}
