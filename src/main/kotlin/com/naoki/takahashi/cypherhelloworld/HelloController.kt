package com.naoki.takahashi.cypherhelloworld

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String): HelloWorld {
        return HelloWorld(
            message = "Hello, $name"
        )
    }
}
