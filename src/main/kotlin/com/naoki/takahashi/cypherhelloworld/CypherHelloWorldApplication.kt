package com.naoki.takahashi.cypherhelloworld

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class CypherHelloWorldApplication {
    @GetMapping("/")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String): HelloWorld {
        return HelloWorld(
            message = "Hello, $name"
        )
    }
}

fun main(args: Array<String>) {
    runApplication<CypherHelloWorldApplication>(*args)
}
