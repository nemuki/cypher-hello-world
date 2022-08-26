package com.nemuki.cypherhelloworld

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorld {
    @GetMapping("/")
    fun hello(@RequestParam(value = "name") name: String) = Message("Hello, $name")
}