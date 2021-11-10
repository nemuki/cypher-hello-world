package com.naoki.takahashi.cypherhelloworld

import com.fasterxml.jackson.annotation.JsonCreator

data class HelloWorld @JsonCreator constructor(
    val message: String
)
