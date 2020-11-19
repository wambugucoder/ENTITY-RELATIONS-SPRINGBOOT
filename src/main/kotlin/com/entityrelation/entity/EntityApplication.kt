package com.entityrelation.entity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication

class EntityApplication

fun main(args: Array<String>) {
    runApplication<EntityApplication>(*args)
}
