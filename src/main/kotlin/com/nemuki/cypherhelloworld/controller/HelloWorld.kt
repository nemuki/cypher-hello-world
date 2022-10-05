package com.nemuki.cypherhelloworld.controller

import com.nemuki.cypherhelloworld.response.Message
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.validation.constraints.Size

@Validated
@RestController
class HelloWorld {
    @GetMapping("/")
    fun hello(@RequestParam(value = "name") @Size(min = 3, max = 10) name: String) = Message("Hello, $name")
}
