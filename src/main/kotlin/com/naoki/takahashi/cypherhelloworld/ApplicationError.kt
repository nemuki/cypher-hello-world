package com.naoki.takahashi.cypherhelloworld

data class ApplicationError(
    val statusCode: String,
    val reason: String,
    val detail: String
)
