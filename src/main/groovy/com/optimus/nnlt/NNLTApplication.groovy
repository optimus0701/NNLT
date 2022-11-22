package com.optimus.nnlt

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan



@SpringBootApplication
@ComponentScan(basePackages = "com.optimus.nnlt.*")
@EntityScan("com.optimus.nnlt.*")
class NNLTApplication {
    static void main(String[] args) {
        SpringApplication.run(NNLTApplication, args)
    }
}
