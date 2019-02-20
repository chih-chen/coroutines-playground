package utils

import java.time.LocalDateTime

object Utils {

    suspend fun measureInMillis(block: suspend () -> Unit) {
        val start = System.currentTimeMillis()
        block()
        val end = System.currentTimeMillis()
        println("Time elapsed: ${end - start} ms")
    }

    fun log(message: String? = null) {
        println("[Time: ${LocalDateTime.now()} | Thread: ${Thread.currentThread()}] - ${message ?: ""}")
    }
}