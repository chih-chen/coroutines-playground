package io

import kotlinx.coroutines.delay

class CryptographyService {

    suspend fun encrypt(data: String): String {
        println("Current thread: ${Thread.currentThread().name}")
        println("Encrypting $data")

        delay(2000)

        return "encrypted.$data"
    }
}