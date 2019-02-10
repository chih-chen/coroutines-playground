package io

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class CryptographyService {

    suspend fun encrypt(data: String): String {
        println("Current thread: ${Thread.currentThread().name}")
        println("Encrypting $data")

        delay(2000)

        return "encrypted.$data"
    }

    suspend fun encryptWithDifferentContext(data: String): String {
        println("Current thread: ${Thread.currentThread().name}")
        println("Switching context ...")
        withContext(Dispatchers.Default) {
            println("Current thread: ${Thread.currentThread().name}")
            println("Encrypting $data")
            delay(2000)
        }
        println("Current thread: ${Thread.currentThread().name}")
        return "encrypted.$data"
    }
}